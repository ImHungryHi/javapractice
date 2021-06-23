package code;
import code.equality.Student;
import java.util.*;

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
    }
}
