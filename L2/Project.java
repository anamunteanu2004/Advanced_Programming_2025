//enum pentru tipurile de proiect
enum ProjectType {
    THEORETICAL,
    PRACTICAL
}

public class Project {
    private String name;
    private ProjectType type;

    //constructor care primește numele și tipul de proiect
    public Project(String name, ProjectType type) {
        this.name = name;
        this.type = type;
    }

    //getter pentru numele proiectului
    public String getName() {
        return name;
    }

    //setter pentru numele proiectului
    public void setName(String name) {
        this.name = name;
    }

    public ProjectType getType() {
        return type;
    }

    public void setType(ProjectType type) {
        this.type = type;
    }

    //metoda pentru a afisa detalii despre proiect
    @Override
    public String toString() {
        return "Project{name='" + name + "', type=" + type + "}";
    }
}
