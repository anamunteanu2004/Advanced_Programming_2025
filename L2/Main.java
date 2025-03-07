//Munteanu Anastasia - 2E2

import java.time.LocalDate;

public class Main {
    public static void main(String args[]) {
    Student c1 = new Student();
    c1.setName("Student 1");
    c1.setBirthdate(LocalDate.of(1999, 12, 31));
    c1.setRegNumber(123_456_789L);
    System.out.println(c1);

    Student c2 = new Student("Student 2");
    System.out.println(c2.getName());

    Student c3 = new Student("Student 1");
    System.out.println(c1 == c3);
    System.out.println(c1.equals(c3));

    Project p = new Project("Some App", ProjectType.PRACTICAL);
    System.out.println(p);
    }
}
