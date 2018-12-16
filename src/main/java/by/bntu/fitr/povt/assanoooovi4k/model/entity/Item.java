package by.bntu.fitr.povt.assanoooovi4k.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer price;
    private String description;
    private String category;
    private String pathToFile;


    public Item(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public Item() {

    }

    public Item(String name, Integer price, String description, String category, String pathToFile) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.pathToFile = pathToFile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return Objects.equals(getName(), item.getName()) &&
                Objects.equals(getPrice(), item.getPrice()) &&
                Objects.equals(getDescription(), item.getDescription()) &&
                Objects.equals(getCategory(), item.getCategory()) &&
                Objects.equals(getPathToFile(), item.getPathToFile());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getPrice(), getDescription(), getCategory(), getPathToFile());
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", pathToFile='" + pathToFile + '\'' +
                '}';
    }
}
