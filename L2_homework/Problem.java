/**
 * Problema alocarii studentilor la proiecte.
 */
public class Problem {
    private final Student[] students;
    private final Teacher[] teachers;

    /**
     * Creeaza un obiect 'Problem' cu listele de studenti si profesori specificate.
     *
     * @param students Lista studentilor implicati in alocare.
     * @param teachers Lista profesorilor care ofera proiecte.
     */

    public Problem(Student[] students, Teacher[] teachers) {
        this.students = students;
        this.teachers = teachers;
    }

    /**
     * Returneaza toate persoanele implicate in problema (studenti si profesori).
     *
     * @return Un vector de obiecte de tip {@link Person}.
     */
    public Person[] getAllPersons() {
        Person[] persons = new Person[students.length + teachers.length];
        System.arraycopy(students, 0, persons, 0, students.length);
        System.arraycopy(teachers, 0, persons, students.length, teachers.length);
        return persons;
    }

    /**
     * Aici se implementeaaza un algoritm greedy simplu pentru alocarea proiectelor catre studenti.
     * Fiecare student primeste primul proiect disponibil din lista de proiecte ale profesorilor.
     */
    public void allocateProjects() {
        boolean[] studentAllocated = new boolean[students.length];
        
        int projectCount = 0;
        for (Teacher teacher : teachers) {
            projectCount += teacher.getProjects().length;
        }
        
        Project[] allProjects = new Project[projectCount];
        int index = 0;
        for (Teacher teacher : teachers) {
            for (Project project : teacher.getProjects()) {
                allProjects[index++] = project;
            }
        }
        
        int projectIndex = 0;
        for (int i = 0; i < students.length; i++) {
            if (projectIndex < allProjects.length) {
                System.out.println("Allocating " + allProjects[projectIndex].getName() + 
                                  " to " + students[i].getName());
                studentAllocated[i] = true;
                projectIndex++;
            } else {
                System.out.println("No project available for " + students[i].getName());
            }
        }
        
        for (int i = 0; i < students.length; i++) {
            if (!studentAllocated[i]) {
                System.out.println("Student " + students[i].getName() + " was not allocated a project");
            }
        }
    }
}
