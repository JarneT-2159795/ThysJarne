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

    public Optional<List<ArrayList<Steen>>> maakKetting(ArrayList<Steen> todo) {
        oplossingen.clear();
        zoekAlleOplossingen(todo, new ArrayList<>(), 0);
        return Optional.of(oplossingen);
    }

    private void zoekAlleOplossingen(ArrayList<Steen> stenen, ArrayList<Steen> huidige, int gelegdeStenen) {
        if (gelegdeStenen == stenen.size()) {
            if (!oplossingen.contains(huidige)) {
                oplossingen.add(new ArrayList<>(huidige));
            }
            return;
        }
        for (int i = gelegdeStenen; i < stenen.size(); ++i) {
            var steen = stenen.get(i);
            probeerSteen(stenen, huidige, gelegdeStenen, steen);
            steen.flip();
            probeerSteen(stenen, huidige, gelegdeStenen, steen);
        }
    }

    private void probeerSteen(ArrayList<Steen> stenen, ArrayList<Steen> huidige, int gelegdeStenen, Steen steen) {
        if (kanLinks(huidige, steen)) {
            huidige.add(0, new Steen(steen.getOgen1(), steen.getOgen2(), steen.getKleur()));
            zoekAlleOplossingen(stenen, huidige, gelegdeStenen + 1);
            huidige.remove(0);
        }
        if (kanRechts(huidige, steen)) {
            huidige.add(new Steen(steen.getOgen1(), steen.getOgen2(), steen.getKleur()));
            zoekAlleOplossingen(stenen, huidige, gelegdeStenen + 1);
            huidige.remove(huidige.size() - 1);
        }
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

