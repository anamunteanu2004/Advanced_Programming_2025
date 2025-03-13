/**
 * Proiectul, cu numele si tipul acestuia.
 */
public class Project {
    private final String name;
    private final ProjectType type;

    /**
     * Construieste un obiect 'Project' cu numele si tipul specificate.
     *
     * @param name Numele proiectului.
     * @param type Tipul proiectului.
     */

    public Project(String name, ProjectType type) {
        this.name = name;
        this.type = type;
    }

    /**
     * Returneaza numele proiectului.
     *
     * @return Un sir de caractere ce reprezinta numele proiectului.
     */

    public String getName() {
        return name;
    }

    /**
     * Returneaza tipul proiectului.
     *
     * @return Tipul proiectului sub forma unui enum {@link ProjectType}.
     */

    public ProjectType getType() {
        return type;
    }

    /**
     * Verifica daca acest proiect este egal cu un alt obiect.
     * Doua proiecte sunt considerate egale daca au acelasi nume si acelasi tip.
     *
     * @param o Obiectul cu care se compara.
     * @return true daca obiectele sunt egale, false in caz contrar.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return name.equals(project.name) && type == project.type;
    }

    /**
     * Genereaza un hash code pentru acest proiect.
     *
     * @return Hash code-ul bazat pe numele si tipul proiectului.
     */

    @Override
    public int hashCode() {
        return name.hashCode() + type.hashCode();
    }

    /**
     * Returneaza o reprezentare sub forma de text a proiectului.
     *
     * @return Un sir de caractere ce contine numele si tipul proiectului.
     */

    @Override
    public String toString() {
        return "Project{name='" + name + "', type=" + type + "}";
    }
}
