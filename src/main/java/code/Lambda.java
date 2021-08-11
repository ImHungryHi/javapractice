package code;
import code.equality.Student;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda {
    // It's possible to create a new interface instance when directly implementing its methods inline
    //  into a variable
    public static Comparator<Student> studentsLastNameComparator = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getLastName().compareTo(o2.getLastName());
        }
    };

    // Alternatively - lambda
    public static Comparator<Student> studentsFirstNameComparator =
            (o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName());

    public static void compareExample() {
        Student s1 = new Student(1, "Chris", "De Smedt", "IT");
        Student s2 = new Student(2, "Sussy", "Baka", "Deceit");
        int lnameResult = studentsLastNameComparator.compare(s1, s2);
        int fnameResult = studentsFirstNameComparator.compare(s1, s2);

        List<Student> lst = new ArrayList<>() {{
            add(s1);
            add(s2);
        }};

        // Sorting lambda style
        lst.sort((o1, o2) -> o1.getDepartment().compareTo(o2.getDepartment()));
    }

    // Other lambda expressions:
    //  parameter -> expression
    //  (parameter1, parameter2) -> expression
    //  (parameter1, parameter2) -> { code block }

    // Helper interfaces
    public interface StringFunction { String run(String s); }

    public static void differentTypes() {
        // Simple String lambdas
        StringFunction exclaim = (s) -> s + "!";
        StringFunction question = (s) -> s + "?";
        System.out.println(exclaim.run("Hello"));   // prints Hello!
        System.out.println(question.run("Hello"));  // prints Hello?

        // Simple function in a lambda
        List<Integer> numbers = new ArrayList<>();
        java.util.function.Consumer<Integer> functionalOne = (n) -> { System.out.println(n); };

        for (int x = 1; x <= 10; x++) {
            numbers.add(x);
        }

        numbers.forEach(functionalOne);
        numbers.forEach((n) -> System.out.println(n));  // Same thing, without intermediary step

        // Map example
        HashMap<String, String> map = new HashMap<>();
        map.put("De Smedt", "Chris");
        map.put("Vermeulen", "Joske");
        map.put("Knievel", "Weevil");
        map.forEach((key, value) -> System.out.println(key));
    }

    public List<String> getLambdaMethodReference() {
        // Example of rewriting lambda even shorter
        //(s) -> System.out.println(s);
        //System.out::println;

        /*List<String> list = Stream.of("Monkey", "Lion", "Gorilla")
                .filter(s -> s.startsWith("L"))
                .map(String::toUpperCase)
                .sorted().collect(List<String>::Arrays.asList);*/
        List<String> list = new ArrayList<>();
        return list;
    }

    public static List<String> getLowerCase(List<String> names) {
        // Lambda with arrays
        String[] arrNames = new String[] { "Bob", "ALICE", "CHRIS", "Johnny" };
        List<String> lambdaLowerArrayList = Arrays.stream(arrNames)
                .filter(name -> !name.equals(name.toUpperCase()))
                .collect(Collectors.toList());

        // Lamba with list
        List<String> lambdaLowerList = names.stream()
                .filter(name -> !name.equals(name.toUpperCase()))
                .collect(Collectors.toList());

        // Non-lambda
        List<String> lowerList = new ArrayList<>();

        for (String name : names) {
            if (!name.equals(name.toUpperCase())) {
                lowerList.add(name);
            }
        }

        return lambdaLowerList;
    }

    public static List<String> getUpperCase(List<String> names) {
        // Lambda with arrays
        String[] arrNames = new String[] { "Bob", "ALICE", "CHRIS", "Johnny" };
        List<String> lambdaCapsArrayList = Arrays.stream(arrNames)
                .filter(name -> name.equals(name.toUpperCase()))
                .collect(Collectors.toList());

        // Lamba with list
        List<String> lambdaCapsList = names.stream()
                .filter(name -> name.equals(name.toUpperCase()))
                .collect(Collectors.toList());

        // Non-lambda
        List<String> capsList = new ArrayList<>();
        for (String name : names) {
            if (name.equals(name.toUpperCase())) {
                capsList.add(name);
            }
        }

        return lambdaCapsList;
    }

    public static boolean hasUpperCase(List<String> names) {
        // Lambda
        return names.stream()
                .anyMatch(name -> name.equals(name.toUpperCase()));

        // Non-lambda
        /*
        for (String name : names) {
            if (name.equals(name.toUpperCase())) {
                return true;
            }
        }
        */
    }

    // Functional interfaces = interface with a single method
    public static class GenericMixtureFunctionalInterfaces {
        static Animal turtle = new Animal("turtle", true, false);

        public static boolean genericCanHopAndSwim() {
            iPredicate<Animal> genSwim = t -> t.canSwim();
            Predicate<Animal> predHop = t -> t.canHop();
            boolean canSwim = genSwim.test(turtle);
            boolean canHop = predHop.test(turtle);
            return canSwim && canHop;
        }

        public static void consumesObjects() {
            StringConsumer stringConsumer = s -> System.out.println(s);
            stringConsumer.accept("Hello darkness, my old friend");

            Consumer<Animal> consumer = a -> System.out.println(a.getName());
            consumer.accept(turtle);

            AnimalConsumer animalConsumer = new AnimalConsumer();
            animalConsumer.accept(turtle);
        }

        public static Integer randomSupplier(int max) {
            iSupplier<Integer> number = (n) -> new Random().nextInt(n);
            return number.get(max);
        }

        interface iPredicate<T> {
            boolean test(T t);
        }

        interface iSupplier<T> {
            T get(int max);
        }

        interface StringConsumer {
            void accept(String s);
        }

        interface Consumer<T> {
            void accept(T t);
        }

        static class AnimalConsumer implements Consumer<Animal> {
            @Override
            public void accept(Animal animal) {
                System.out.println(animal.getName());
            }
        }

        private static class Animal {
            private boolean canSwim;
            private boolean canHop;
            private String name;

            public Animal(String name, boolean canSwim, boolean canHop) {
                this.name = name;
                this.canSwim = canSwim;
                this.canHop = canHop;
            }

            String getName() {
                return name;
            }

            boolean canSwim() {
                return canSwim;
            }

            boolean canHop() {
                return canHop;
            }
        }
    }
}
