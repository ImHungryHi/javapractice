package code.equality;
import lombok.Getter;
import java.util.Objects;

@Getter
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String department;

    public Student(int id, String firstName, String lastName, String department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(department, student.department);
    }
}
