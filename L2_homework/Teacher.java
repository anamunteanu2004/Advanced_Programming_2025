import java.time.LocalDate;
import java.util.Arrays;

/**
 * Se creeaza aici profesorii (care dau proiectele).
 */
public class Teacher extends Person {
    private Project[] projects;

    /**
     * Se construieste un obiect 'Teacher' cu numele, data nasterii si proiectele specificate.
     *
     * @param name      Numele profesorului.
     * @param birthdate Data nasterii a profesorului.
     * @param projects  Lista proiectelor propuse de profesor.
     */
    
    public Teacher(String name, LocalDate birthdate, Project[] projects) {
        super(name, birthdate);
        this.projects = projects;
    }

    /**
     * Returneaza lista proiectelor propuse de acest profesor.
     *
     * @return Un vector ce contine proiectele.
     */

    public Project[] getProjects() {
        return projects;
    }

    /**
     * Returneaza o reprezentare sub forma de text a profesorului.
     *
     * @return Un sir de caractere cu numele, data nasterii si proiectele profesorului.
     */

    @Override
    public String toString() {
        return "Teacher{name='" + name + "', birthdate=" + birthdate + ", projects=" + java.util.Arrays.toString(projects) + "}";
    }

    /**
     * Verifica daca acest profesor este egal cu un alt obiect.
     * Doi profesori sunt considerati 'egali' daca au acelasi nume, data de nastere si proiecte.
     *
     * @param o Obiectul cu care se compara.
     * @return true daca obiectele sunt egale, false in caz contrar.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Teacher)) return false;
        Teacher teacher = (Teacher) o;
        return Arrays.equals(projects, teacher.projects);
    }

    /**
     * Genereaza un cod hash pentru acest profesor.
     *
     * @return Hash code.
     */
    @Override
    public int hashCode() {
        return super.hashCode() + Arrays.hashCode(projects);
    }
}
