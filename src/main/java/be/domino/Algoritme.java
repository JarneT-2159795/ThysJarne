package be.domino;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Jarne Thys
 */
public class Algoritme {
    private final List<ArrayList<Steen>> oplossingen = new ArrayList<>();
    private int lengte;
    public int dubbels;

    public Optional<List<ArrayList<Steen>>> maakKetting(ArrayList<Steen> todo) {
        oplossingen.clear();
        lengte = todo.size();
        while (oplossingen.size() == 0) {
            dubbels = 0;
            ArrayList<Steen> huidige = new ArrayList<>();
            huidige.add(new Steen(todo.remove(0)));
            zoekAlleOplossingen(todo, huidige);
            --lengte;
        }
        int size = oplossingen.size();
        for (int i = 0; i < size; ++i) {
            ArrayList<Steen> nieuw = new ArrayList<>();
            for (int j = lengte; j >= 0; --j) {
                var steen = new Steen(oplossingen.get(i).get(j));
                steen.flip();
                nieuw.add(steen);
            }
            oplossingen.add(new ArrayList<>(nieuw));
        }
        return Optional.of(oplossingen);
    }

    private void zoekAlleOplossingen(ArrayList<Steen> stenen, ArrayList<Steen> huidige) {
        if (huidige.size() == lengte) {
            if (!oplossingen.contains(huidige)) {
                oplossingen.add(new ArrayList<>(huidige));
                System.out.println("Oplossing " + oplossingen.size() + " gevonden met " + huidige.size() + " stenen");
            } else {
                ++dubbels;
            }
            return;
        }
        for (int i = 0; i < stenen.size(); ++i) {
            probeerSteen(stenen, huidige, i);
            stenen.get(i).flip();
            probeerSteen(stenen, huidige, i);
        }
    }

    private void probeerSteen(ArrayList<Steen> stenen, ArrayList<Steen> huidige, int huidigeSteen) {
        var steen = new Steen(stenen.remove(huidigeSteen));
        if (kanLinks(huidige, steen)) {
            huidige.add(0, new Steen(steen));
            zoekAlleOplossingen(stenen, new ArrayList<>(huidige));
            huidige.remove(0);
        }
        if (kanRechts(huidige, steen) && huidige.size() > 0) {
            huidige.add(new Steen(steen));
            zoekAlleOplossingen(stenen, new ArrayList<>(huidige));
            huidige.remove(huidige.size() - 1);
        }
        stenen.add(huidigeSteen, steen);
    }

    private boolean kanLinks(ArrayList<Steen> oplossing, Steen steen) {
        if (oplossing.isEmpty()) return true;
        return ((oplossing.get(0).getOgen1() == steen.getOgen2()) && (oplossing.get(0).getKleur() != steen.getKleur()));
    }

    private boolean kanRechts(ArrayList<Steen> oplossing, Steen steen) {
        if (oplossing.isEmpty()) return true;
        return ((oplossing.get(oplossing.size() - 1).getOgen2() == steen.getOgen1()) && (oplossing.get(oplossing.size() - 1).getKleur() != steen.getKleur()));
    }
}

