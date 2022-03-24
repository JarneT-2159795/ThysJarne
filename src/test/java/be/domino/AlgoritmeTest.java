package be.domino;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class AlgoritmeTest {
    @Test
    void kanLinks_steenKanLinks_true() {
        // Private methode testen
        // https://www.javacodegeeks.com/2021/02/unit-testing-private-methods.html
        // https://www.javacodegeeks.com/2021/02/unit-testing-private-methods.html
        Class[] args = new Class[2];
        args[0] = ArrayList.class;
        args[1] = Steen.class;
        Method method;
        try {
            method = Algoritme.class.getDeclaredMethod("kanLinks", args);
            method.setAccessible(true);
            ArrayList<Steen> stenen = new ArrayList<>();
            stenen.add(new Steen(1, 2, 'R'));
            var steen = new Steen(2, 1, 'G');
            var algoritme = new Algoritme();

            var result = (boolean)method.invoke(algoritme, stenen, steen);
            Assertions.assertTrue(result);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    void kanLinks_steenKanNietLinksDoorKleur_false() {
        // Private methode testen
        // https://www.javacodegeeks.com/2021/02/unit-testing-private-methods.html
        // https://www.javacodegeeks.com/2021/02/unit-testing-private-methods.html
        Class[] args = new Class[2];
        args[0] = ArrayList.class;
        args[1] = Steen.class;
        Method method;
        try {
            method = Algoritme.class.getDeclaredMethod("kanLinks", args);
            method.setAccessible(true);
            ArrayList<Steen> stenen = new ArrayList<>();
            stenen.add(new Steen(1, 2, 'R'));
            var steen = new Steen(2, 1, 'R');
            var algoritme = new Algoritme();

            var result = (boolean)method.invoke(algoritme, stenen, steen);
            Assertions.assertFalse(result);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    void kanLinks_steenKanNietLinksDoorOgen_false() {
        // Private methode testen
        // https://www.javacodegeeks.com/2021/02/unit-testing-private-methods.html
        // https://www.javacodegeeks.com/2021/02/unit-testing-private-methods.html
        Class[] args = new Class[2];
        args[0] = ArrayList.class;
        args[1] = Steen.class;
        Method method;
        try {
            method = Algoritme.class.getDeclaredMethod("kanLinks", args);
            method.setAccessible(true);
            ArrayList<Steen> stenen = new ArrayList<>();
            stenen.add(new Steen(1, 2, 'R'));
            var steen = new Steen(2, 3, 'G');
            var algoritme = new Algoritme();

            var result = (boolean)method.invoke(algoritme, stenen, steen);
            Assertions.assertFalse(result);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    void kanLinks_steenKanLinksWantLeeg_true() {
        // Private methode testen
        // https://www.javacodegeeks.com/2021/02/unit-testing-private-methods.html
        // https://www.javacodegeeks.com/2021/02/unit-testing-private-methods.html
        Class[] args = new Class[2];
        args[0] = ArrayList.class;
        args[1] = Steen.class;
        Method method;
        try {
            method = Algoritme.class.getDeclaredMethod("kanLinks", args);
            method.setAccessible(true);
            ArrayList<Steen> stenen = new ArrayList<>();
            var steen = new Steen(3, 2, 'G');
            var algoritme = new Algoritme();

            var result = (boolean)method.invoke(algoritme, stenen, steen);
            Assertions.assertTrue(result);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    void kanRechts_steenKanRechts_true() {
        // Private methode testen
        // https://www.javacodegeeks.com/2021/02/unit-testing-private-methods.html
        // https://www.javacodegeeks.com/2021/02/unit-testing-private-methods.html
        Class[] args = new Class[2];
        args[0] = ArrayList.class;
        args[1] = Steen.class;
        Method method;
        try {
            method = Algoritme.class.getDeclaredMethod("kanRechts", args);
            method.setAccessible(true);
            ArrayList<Steen> stenen = new ArrayList<>();
            stenen.add(new Steen(1, 2, 'R'));
            var steen = new Steen(2, 1, 'G');
            var algoritme = new Algoritme();

            var result = (boolean)method.invoke(algoritme, stenen, steen);
            Assertions.assertTrue(result);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    void kanRechts_steenKanNietRechtsDoorKleur_false() {
        // Private methode testen
        // https://www.javacodegeeks.com/2021/02/unit-testing-private-methods.html
        // https://www.javacodegeeks.com/2021/02/unit-testing-private-methods.html
        Class[] args = new Class[2];
        args[0] = ArrayList.class;
        args[1] = Steen.class;
        Method method;
        try {
            method = Algoritme.class.getDeclaredMethod("kanRechts", args);
            method.setAccessible(true);
            ArrayList<Steen> stenen = new ArrayList<>();
            stenen.add(new Steen(1, 2, 'R'));
            var steen = new Steen(2, 1, 'R');
            var algoritme = new Algoritme();

            var result = (boolean)method.invoke(algoritme, stenen, steen);
            Assertions.assertFalse(result);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    void kanRechts_steenKanNietRechtsDoorOgen_false() {
        // Private methode testen
        // https://www.javacodegeeks.com/2021/02/unit-testing-private-methods.html
        // https://www.javacodegeeks.com/2021/02/unit-testing-private-methods.html
        Class[] args = new Class[2];
        args[0] = ArrayList.class;
        args[1] = Steen.class;
        Method method;
        try {
            method = Algoritme.class.getDeclaredMethod("kanRechts", args);
            method.setAccessible(true);
            ArrayList<Steen> stenen = new ArrayList<>();
            stenen.add(new Steen(1, 2, 'R'));
            var steen = new Steen(3, 2, 'G');
            var algoritme = new Algoritme();

            var result = (boolean)method.invoke(algoritme, stenen, steen);
            Assertions.assertFalse(result);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    void kanRechts_steenKanRechtsWantLeeg_true() {
        // Private methode testen
        // https://www.javacodegeeks.com/2021/02/unit-testing-private-methods.html
        // https://www.javacodegeeks.com/2021/02/unit-testing-private-methods.html
        Class[] args = new Class[2];
        args[0] = ArrayList.class;
        args[1] = Steen.class;
        Method method;
        try {
            method = Algoritme.class.getDeclaredMethod("kanRechts", args);
            method.setAccessible(true);
            ArrayList<Steen> stenen = new ArrayList<>();
            var steen = new Steen(3, 2, 'G');
            var algoritme = new Algoritme();

            var result = (boolean)method.invoke(algoritme, stenen, steen);
            Assertions.assertTrue(result);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
