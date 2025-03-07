import java.time.LocalDate;

public class Student {
    private String name;
    private LocalDate birthdate;
    private Long regNumber;

    public Student() {
        //constructor default
    }

    public Student(String name) {
        this.name = name;
    }

    public void StudentType(String name, LocalDate birthdate, Long regNumber)
    {
        this.name = name;
        this.birthdate = birthdate;
        this.regNumber = regNumber;
    }

    public String getName() {
        return name;
    }

    //modified access modifier from default to public
    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Long getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(Long regNumber) {
        this.regNumber = regNumber;
    }

    //toString method
    @Override
    public String toString() {
        return "Student{" +
               "name='" + name + '\'' +
               ", birthdate=" + birthdate +
               ", regNumber=" + regNumber +
               '}';
    }

    // @Override
    // public boolean equals(Object o) {
    //     if (this == o) return true;
    //     if (o == null || getClass() != o.getClass()) return false;
    //     Student student = (Student) o;
    //     return Objects.equals(name, student.name) &&
    //            Objects.equals(birthdate, student.birthdate) &&
    //            Objects.equals(regNumber, student.regNumber);
    // }

    // @Override
    // public int hashCode() {
    //     return Objects.hash(name, birthdate, regNumber);
    // }

}
