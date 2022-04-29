import java.io.Serializable;

public class Animal implements Serializable {
    private String name;
    private Boolean edible;

    public Animal(String name) {
        this.name = name;
    }

    public Animal(String name, boolean edible) {
        this.name = name;
        this.edible=edible;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getEdible() {
        return edible;
    }

    public void setEdible(Boolean edible) {
        this.edible = edible;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", edible=" + edible +
                '}';
    }
}


