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

    public Optional<List<ArrayList<Steen>>> maakKetting(ArrayList<Steen> todo) {
        oplossingen.clear();
        lengte = todo.size();
        while (oplossingen.size() == 0) {
            for (int i = 0; i < todo.size(); ++i) {
                ArrayList<Steen> huidige = new ArrayList<>();
                var eerste = new Steen(todo.remove(i));
                huidige.add(eerste);
                zoekAlleOplossingen(todo, huidige);
                var kopie = new Steen(eerste);
                kopie.flip();
                todo.add(i, kopie);
            }
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
                if (kanSluiten(huidige)) {
                    oplossingen.add(new ArrayList<>(huidige));
                }
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

    private boolean kanSluiten(ArrayList<Steen> oplossing) {
        if (oplossing.size() <= 1) return true;
        var eerste = oplossing.get(0);
        var laatste = oplossing.get(oplossing.size() - 1);
        if (eerste.getOgen1() != laatste.getOgen2()) {
            return false;
        }
        return (eerste.getKleur() != laatste.getKleur());
    }
}

