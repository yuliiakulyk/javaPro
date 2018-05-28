import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Yuliia Kulyk on 26.05.2018.
 */
@Entity
@Table(name = "Dishes")
//@NamedQuery(name = "Dish.findAll", query = "select d from Dish d")
public class Dish {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Double price;
    @Column(name = "weight_in_grams")
    private Integer weightInGrams;
    @Column(name = "has_discount")
    private Boolean hasDiscount;

    public Dish() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getWeightInGrams() {
        return weightInGrams;
    }

    public void setWeightInGrams(Integer weightInGrams) {
        this.weightInGrams = weightInGrams;
    }

    public Boolean getHasDiscount() {
        return hasDiscount;
    }

    public void setHasDiscount(Boolean hasDiscount) {
        this.hasDiscount = hasDiscount;
    }

    public static Dish readDishFromConsole() {
        Dish dish = new Dish();
        dish.setName(readPropertyFromConsole("dish name"));
        dish.setPrice(Double.parseDouble(readPropertyFromConsole("price (use . as delimiter)")));
        dish.setWeightInGrams(Integer.parseInt(readPropertyFromConsole("weight in grams")));
        dish.setHasDiscount(Boolean.parseBoolean(readPropertyFromConsole("has discount (true or false)")));
        return dish;
    }

    public static void printDishesList(List<Dish> list) {
        for (Dish dish: list) {
            System.out.println(dish);
        }
    }

    public static String readPropertyFromConsole(String property) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter " + property + ":");
        return scanner.nextLine();
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", weightInGrams=" + weightInGrams +
                ", hasDiscount=" + hasDiscount +
                '}';
    }
}
