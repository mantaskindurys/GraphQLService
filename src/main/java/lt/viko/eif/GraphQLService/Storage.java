package lt.viko.eif.GraphQLService;

import io.leangen.graphql.annotations.GraphQLQuery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Storage {

    @Id
    @GeneratedValue
    @GraphQLQuery(name = "id", description = "storage's id")
    private Long id;

    @GraphQLQuery(name = "name", description = "A storage's name")
    private String name;

    @GraphQLQuery(name = "price", description = "A storage's name")
    private double price;

    @GraphQLQuery(name = "quantity", description = "A storage's name")
    private int quantity;

    @GraphQLQuery(name = "StoringConditions", description = "A storage's name")
    private String StoringConditions;

    @GraphQLQuery(name = "days", description = "A storage's expiry date")
    private int days;

    public Storage() {
    }

    public Storage(String name, double price, int quantity, String storingConditions) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        StoringConditions = storingConditions;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStoringConditions() {
        return StoringConditions;
    }

    public void setStoringConditions(String storingConditions) {
        StoringConditions = storingConditions;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", StoringConditions='" + StoringConditions + '\'' +
                ", days=" + days +
                '}';
    }
}
