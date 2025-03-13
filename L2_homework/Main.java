//Munteanu Anastasia - 2E2

import java.time.LocalDate;

/**
 * Aici se testeaza...
 */
public class Main {
    public static void main(String[] args) {
        Project p1 = new Project("AI Research", ProjectType.THEORETICAL);
        Project p2 = new Project("Mobile App", ProjectType.PRACTICAL);
        Project p3 = new Project("Blockchain Security", ProjectType.THEORETICAL);

        Teacher t1 = new Teacher("Prof. Ionescu", LocalDate.of(1980, 5, 20), new Project[]{p1, p2});
        Teacher t2 = new Teacher("Prof. Popescu", LocalDate.of(1975, 8, 10), new Project[]{p3});

        Student s1 = new Student("Nina", LocalDate.of(2000, 1, 15), 123456789);
        Student s2 = new Student("George", LocalDate.of(1999, 6, 30), 987654321);

        Problem problem = new Problem(new Student[]{s1, s2}, new Teacher[]{t1, t2});

        for (Person person : problem.getAllPersons()) {
            System.out.println(person);
        }

        problem.allocateProjects();
    }
}
