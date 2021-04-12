import code.Sorting;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Hello {
    // Om testmodules toe te voegen, maak je een subdirectory in de root (naast src) en markeer je deze als "test sources root"
    //   Hierin kun je tests schrijven om je src te doorlopen, liefst gebruik makende van junit
    // Om jUnit te gebruiken ga je naar de maven repositories, kijk je naar de nieuwste versie van junit en keer je terug naar IDEA.
    //   In IntelliJ kun je dan via file > project structure > libraries een library toevoegen uit maven.
    // Om tests te genereren vanuit een klasse, klik je rechts op de klassenaam, kies show context actions en daarna create tests
    public static void main(String[] args) {
        //TestCase.sayHello();
        //TestCase.tafelVanTien();
        //TestCase.demoOperands();
        //TestCase.nestedLoops();
        //TestCase.whileLoops();
        //TestCase.forLoops();
        //TestCase.timing();
        //TestCase.stringOperations();
        //System.out.println(TestCase.sumDigitsInNumber(1234567));
        //TestCase.printEratosthenesAlt();
        //System.out.println(TestCase.sieveOfEratosthenes(100).toString());
        //TestCase.printFactorial(6);
        //TestCase.printFibonacci(100);
        //TestCase.printNFibonacci(5);
        //TestCase.printFibonacciEven(20);
        //TestCase.compareBubbleSortTiming();
        //TestCase.compareEratosthenesTiming();
        //TestCase.compareFactorialTiming();
        //TestCase.compareFibonacciTiming();
        //TestCase.doBubbleRecursive();
        //System.out.println(TestCase.sumOf3And5Multiples(100));
        //TestCase.compareNumericPalindromeTiming();

        /*ArrayList<ArrayList<Integer>> lstList = new ArrayList<ArrayList<Integer>>() {{
           add(new ArrayList<Integer>() {{
               add(4);
               add(9);
               add(20);
               add(34);
               add(39);
           }});
           add(new ArrayList<Integer>() {{
               add(1);
               add(2);
               add(5);
               add(16);
               add(18);
               add(21);
               add(22);
           }});
           add(new ArrayList<Integer>() {{
               add(3);
               add(6);
               add(7);
               add(10);
               add(15);
               add(19);
           }});
        }};

        Sorting.mergeSort(lstList);*/

        /*code.haml.NodeList nodeList = new code.haml.NodeList();
        nodeList.fillExample();
        for (code.haml.Node node : nodeList) {
            System.out.println(node.get("tagName")+ ";" + node.getChildren());
        }*/
        Superb s = new Beta(2);
        System.out.println(s.someInt);
    }

    public static class Superb {
        int someInt;
    }
    public static class Beta extends Superb {
        int someInt;
        public Beta(int someInt) {
            super.someInt = someInt;
        }
    }
}
