import java.time.LocalDate;

/**
 * Se creeaza o persoana cu numele si data nasterii.
 */
public abstract class Person {
    protected String name;
    protected LocalDate birthdate;

     /**
     * Creeaza un obiect 'Person' cu numele si data nasterii specificate.
     *
     * @param name      Numele persoanei.
     * @param birthdate Data nasterii persoanei.
     */

    public Person(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    /**
     * Returneaza numele persoanei.
     *
     * @return Numele persoanei.
     */

    public String getName() {
        return name;
    }

    /**
     * Returneaza data nasterii persoanei.
     *
     * @return Data nasterii.
     */

    public LocalDate getBirthdate() {
        return birthdate;
    }

    /**
     * Compara acest obiect cu un altul pentru a verifica daca sunt egale.
     *
     * @param o Obiectul de comparat.
     * @return true daca obiectele sunt egale, false in caz contrar.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) && birthdate.equals(person.birthdate);
    }

    /**
     * Calculeaza hash code-ul al obiectului pe baza numelui si a datei nasterii.
     *
     * @return Hash code-ul al obiectului.
     */

    @Override
    public int hashCode() {
        return name.hashCode() + birthdate.hashCode();
    }
}
