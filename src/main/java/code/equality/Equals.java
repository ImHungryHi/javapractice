package code.equality;

public class Equals {
    public static void main(String[] args) {
        Student s1 = new Student(1, "Chris", "De Smedt", "IT");
        Student s2 = new Student(2, "Charel", "De Boskabouter", "Showbizz");
        Student s3 = new Student(1, "Chris", "De Smedt", "IT");

        System.out.println("Diff");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        System.out.println("Same");
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));  // Default willl be false since reference is used
    }
}
