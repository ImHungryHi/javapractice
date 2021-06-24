package code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Collections {
    // Lists are your everyday basic collections, contains a number of rows filled with (possibly duplicate) data
    List<String> exampleAList = new ArrayList<>();  // When in doubt, pick ArrayList - most use, usually most performant
    List<String> exampleLList = new LinkedList<>(); // For your specific needs
    // Sets are collections in which no duplicate data is allowed - duplicates are dropped and original data is kept
    Set<String> exampleTSet = new TreeSet<>();          // Stores data in a naturally sorted hierarchical order (LT or GT branching); alternatively sorted with a comparator param
    Set<String> exampleHSet = new HashSet<>();          // Best performance, stores data in a hash table
                                                        //  (not unlike a hashmap with hash strings as secondary param)
                                                        //  can temporarily remain in a certain order, without guarantee
    Set<String> exampleLHSet = new LinkedHashSet<>();   // Like hashset, stored in hash table - with addition of the sequential order of a linked list
    // Maps are like dictionaries in C# - they contain key-value pairs
    Map<String, String> exampleHMap = new HashMap<>();          // Keys should be unique, newer values with a duplicate key will overwrite existing values
    Map<String, String> exampleTMap = new TreeMap<>();          // Stores pairs in ascending order, possibly useful for iterator-heavy maps
    Map<String, String> exampleLHMap = new LinkedHashMap<>();   // Stores pairs in insertion order

    public static HashMap<String, String> createHashMap() {
        HashMap<String, String> map = new HashMap<String, String>();

        map.put("Backeljau", "Cois");
        map.put("Jeans", "Jean-Jean");
        map.put("Van Anus", "Urbanus");
        map.put("De Smedt", "Chris");
        map.put("Potter", "Harry");
        map.put("Weasley", "Ronald");
        map.put("Granger", "Hermione");
        map.put("Prefect", "Ford");
        map.put("Beeblebrox", "Zaphod");
        map.put("Everdeen", "Katniss");

        return map;
    }

    /*
     * -----------------------------------------------------------------------------------------
     * ---------------------------------- ArrayList OPERATIONS ---------------------------------
     * -----------------------------------------------------------------------------------------
     */
    // Interesting way to add a number and sort it in 1 go
    public static void sortedAdd(ArrayList<Integer> list, int input) {
        boolean added = false;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > input) {
                list.add(i, input);
                added = true;
                break;
            }
        }

        if (!added) {
            list.add(input);
        }
    }

    // Month in arraylist (as opposed to the correct way of hashmaps...) - V1
    public static void monthInArrayListV1() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine();

            List<ArrayList> parent = new ArrayList<ArrayList>();
            ArrayList<String> months = new ArrayList<String>();
            ArrayList<Integer> nums = new ArrayList<Integer>();
            months.add("January");
            months.add("February");
            months.add("March");
            months.add("April");
            months.add("May");
            months.add("June");
            months.add("July");
            months.add("August");
            months.add("September");
            months.add("October");
            months.add("November");
            months.add("December");

            for (int x = 1; x <= 12; x++)
                nums.add(x);

            parent.add(nums);
            parent.add(months);

            for (int x = 0; x < 12; x++) {
                int num = Integer.parseInt(parent.get(0).get(x).toString());
                String month = parent.get(1).get(x).toString();

                if (month.equals(input))
                    System.out.println(month + " is month " + num);
            }
        }
        catch (Exception ex) {}
    }

    // V2 alternate solution
    public static void monthInArrayListV2() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            List<String> months = new ArrayList<>();
            months.add("January");
            months.add("February");
            months.add("March");
            months.add("April");
            months.add("May");
            months.add("June");
            months.add("July");
            months.add("August");
            months.add("September");
            months.add("October");
            months.add("November");
            months.add("December");

            String month = reader.readLine();
            if (months.contains(month)) {
                int monthNumber = months.indexOf(month) + 1;
                System.out.println(month + " is month " + monthNumber);
            } else {
                System.out.println(month + " isn't a month");
            }
        }
        catch (Exception ex) {}
    }

    /*
     * -----------------------------------------------------------------------------------------
     * --- PERFORMANCE ON LinkedList OR ArrayList CAN VARY DEPENDING ON THE TYPE OF OPERATION --
     * -----------------------------------------------------------------------------------------
     */
    // ----- Getting or setting on a list is faster with ArrayList, as well as searching ----- //
    public static List getListForGet() {
        return new ArrayList();
    }

    public static List getListForSet() {
        return new ArrayList();
    }

    // Getting an element is a direct link to a place in memory, whereas a LinkedList has to go over every element
    public static List getListForSearch() { return new ArrayList(); }

    // ----- While adding, inserting and removing is faster on a LinkedList ----- //
    public static List getListForAddOrInsert() {
        return new LinkedList();
    }

    public static List getListForRemove() {
        return new LinkedList();
    }

    // ArrayList requires extra memory for indexes and element data
    public static List getListForMemoryOverhead() { return new LinkedList(); }

    /*
     * -----------------------------------------------------------------------------------------
     * ---- MULTIPLE WAYS TO ITERATE THROUGH A HashMap<String, String> (OR OTHER) COLLECTION ---
     * -----------------------------------------------------------------------------------------
     */
    public static void hashmapIterationOne(HashMap<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.print(entry.getKey() + ";");
        }

        System.out.println();
    }

    public static void iterateHashMapKeys(HashMap<String, String> map) {
        for (String key : map.keySet()) {
            System.out.print(key + " - " + map.get(key) + ";");
        }

        System.out.println();
    }

    public static void iterateHashMapValues(HashMap<String, String> map) {
        for (String value : map.values()) {
            System.out.print(value + ";");
        }

        System.out.println();
    }

    /*
     * -----------------------------------------------------------------------------------------
     * ------------------------ COMPARE/ITERATE/REMOVE A HashSet OF PETS -----------------------
     * -----------------------------------------------------------------------------------------
     */
    // Create some sets first, we'll need pets to fill them in
    public static class Cat {}
    public static class Dog {}
    public static Set<Cat> createCats() {
        HashSet<Cat> result = new HashSet<Cat>();

        for (int x = 0; x < 4; x++)
            result.add(new Cat());

        return result;
    }

    public static Set<Dog> createDogs() {
        HashSet<Dog> result = new HashSet<Dog>();

        for (int x = 0; x < 3; x++)
            result.add(new Dog());

        return result;
    }

    // Iterate through a HashSet (initialized with one HashSet) and add its objects to another HashSet
    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        Set<Object> pets = new HashSet<Object>(cats);
        Iterator iter = dogs.iterator();

        while (iter.hasNext())
            pets.add(iter.next());

        return pets;
    }

    // Iterate again, only remove cats from the HashSet
    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        Iterator iter = pets.iterator();

        while (iter.hasNext()) {
            Object pet = iter.next();
            Iterator catsIter = cats.iterator();

            while (catsIter.hasNext()) {
                Cat cat = (Cat) catsIter.next();

                if (cat.equals(pet))
                    iter.remove();
            }
        }
    }

    // Iterate through the HashSet and print out the object inside (the value)
    public static void printPets(Set<Object> pets) {
        Iterator iter = pets.iterator();

        while (iter.hasNext()) {
            Object pet = iter.next();
            System.out.println(pet);
        }
    }

    /*
     * -----------------------------------------------------------------------------------------
     * ---------------------------------- Classroom iterators ----------------------------------
     * -----------------------------------------------------------------------------------------
     */
    public static class ArrayListIterator {
        public static void main(String[] args) {
            List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
            Iterator it = numbers.iterator();   // Alternative is listIterator which moves bidirectionally

            while (it.hasNext()) {
                System.out.println(it.next());
            }

            // This works the same behind the curtains
            for (Integer el : numbers) {
                System.out.println(el);
            }
        }
    }

    public static class LinkedListIterator {
        public static void main(String[] args) {
            List<String> list = new LinkedList<>();
            list.add("Take");
            list.add("me");
            list.add("to");
            list.add("your");
            list.add("leader");

            System.out.println("List is: " + list);
            Iterator<String> it = list.iterator();

            while (it.hasNext()) {
                System.out.println(it.next());
            }

            it.remove();
            System.out.println("After deletion: " + list);
        }
    }
}
