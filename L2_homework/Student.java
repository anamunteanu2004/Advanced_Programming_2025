import java.time.LocalDate;

/**
 * Se creeaza aici un student cu cod matricol.
 */
public class Student extends Person {
    private final long regNumber;

     /**
     * Se creeaza un obiect 'Student' cu nume, data de nastere si cod matricol.
     *
     * @param name      Numele studentului.
     * @param birthdate Data nasterii a studentului.
     * @param regNumber Codul matricol al studentului (unic).
     */

    public Student(String name, LocalDate birthdate, long regNumber) {
        super(name, birthdate);
        this.regNumber = regNumber;
    }

    /**
     * Returneaza numarul matricol al unui student.
     *
     * @return Cod matricol.
     */

    public long getRegNumber() {
        return regNumber;
    }

    /**
     * Verifica daca un student este egal cu un alt obicet.
     * Doi studenti sunt 'egali' daca au acelasi nume, data de nastere si cod matricol.
     *
     * @param o Obiectul care se compara.
     * @return {@code true} daca obiectele sunt echivalente, {@code false} altfel.
     */

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return regNumber == student.regNumber;
    }

    /**
     * Returneaza hash code-ul unui student in functie de nume,data nasterii si cod matricol.
     * 
     *
     * @return Hash code.
     */

    @Override
    public int hashCode() {
        return super.hashCode() + Long.hashCode(regNumber);
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', birthdate=" + birthdate + ", regNumber=" + regNumber + "}";
    }
}
