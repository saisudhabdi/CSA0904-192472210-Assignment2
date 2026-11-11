
import java.util.*;

class Student {
    private final String regNo;
    private final String name;

    public Student(String regNo, String name) {
        this.regNo = regNo;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;

        Student other = (Student) obj;
        return regNo.equals(other.regNo);
    }

    // TODO: Implement hashCode() in the next step.
}

public class Main {
    public static void main(String[] args) {

        // Test 1: Unique students
        HashSet<Student> uniqueStudents = new HashSet<>();

        uniqueStudents.add(new Student("101", "Arun"));
        uniqueStudents.add(new Student("102", "Bala"));

        System.out.println("TEST 1 - Unique Students");
        System.out.println("Number of students: " + uniqueStudents.size());

        // Test 2: Duplicate students
        HashSet<Student> attendance = new HashSet<>();

        attendance.add(new Student("101", "Arun"));
        attendance.add(new Student("101", "Arun"));
        attendance.add(new Student("102", "Bala"));

        System.out.println("\nTEST 2 - Duplicate Students");
        System.out.println("Students in HashSet: " + attendance.size());

        // Test 3: TreeSet comparator
        TreeSet<Student> sortedStudents =
            new TreeSet<>((s1, s2) ->
                s1.getName().compareTo(s2.getName()));

        sortedStudents.add(new Student("201", "Kiran"));
        sortedStudents.add(new Student("202", "Kiran"));

        System.out.println("\nTEST 3 - TreeSet Comparator");
        System.out.println("Students in TreeSet: " + sortedStudents.size());
    }
}
