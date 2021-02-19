import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Collections {
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
    // Getting or setting a list is faster with ArrayList
    public static List getListForGet() {
        return new ArrayList();
    }

    public static List getListForSet() {
        return new ArrayList();
    }

    // While adding, inserting and removing is faster on a LinkedList
    public static List getListForAddOrInsert() {
        return new LinkedList();
    }

    public static List getListForRemove() {
        return new LinkedList();
    }

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
}
