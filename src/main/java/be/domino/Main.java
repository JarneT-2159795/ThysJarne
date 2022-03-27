package be.domino;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Jarne Thys
 */
public class Main {

    private static final String defaultInput = "12R 16R 23G 34B";

    public static void main(String[] args) {
        String input;
        if (args.length == 0) input = defaultInput;
        else input = readFileAsString(args[0]);

        ArrayList<Steen> stenen = readStones(input);
        if (stenen.size() > 1) stenen.get(1).flip();

        Algoritme rekenaar = new Algoritme();
        Optional<List<ArrayList<Steen>>> oplossingen = rekenaar.maakKetting(stenen);
        if (oplossingen.isEmpty()) {
            System.out.println("Geen oplossing");
        }
        else if (oplossingen.get().size() == 0) {
            System.out.println("Geen oplossing");
        }
        else {
            var alle = oplossingen.get();
            for (var opl : alle) {
                System.out.println(opl);
            }
            System.out.println(String.valueOf(alle.size()) + " oplossingen gevonden met " + alle.get(0).size() + " stenen");
        }
    }

    public static String readFileAsString(String fileName)
    {
        try {
            String data;
            data = new String(Files.readAllBytes(Paths.get(fileName)));
            return data;
        }
        catch (Exception e) {
            return defaultInput;
        }
    }

    public static ArrayList<Steen> readStones(String txt) {
        ArrayList<Steen> stenen = new ArrayList<>();
        for (int i=0; i < txt.length(); i=i+4) {
            stenen.add(parseStone(txt.substring(i, i+3)));
        }
        return stenen;
    }

    public static Steen parseStone(String txt) {
        try {
            int ogen1 = Integer.parseInt(txt.substring(0,1));
            int ogen2 = Integer.parseInt(txt.substring(1,2));
            char kleur = txt.charAt(2);
            return new Steen(ogen1, ogen2, kleur);
        }
        catch (Exception e) {
            return new Steen(9);
        }
    }

}
