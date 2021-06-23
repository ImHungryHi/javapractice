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
}
