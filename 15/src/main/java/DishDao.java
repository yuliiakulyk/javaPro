import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Yuliia Kulyk on 26.05.2018.
 */
public class DishDao {
    public EntityManagerFactory emf;
    public EntityManager em;

    public DishDao() {
        this.emf = Persistence.createEntityManagerFactory("DishApp");
        this.em = emf.createEntityManager();
    }

    public void addDish(Dish dish) {
        em.getTransaction().begin();
        em.persist(dish);
        em.getTransaction().commit();
    }

    public List<Dish> getAll() {
        Query query = em.createQuery("select d from Dish d", Dish.class);
        return query.getResultList();
    }

    public List<Dish> priceFromTo(Double[] lowAndHigh) {
        Query query = em.createQuery("select d from Dish d where d.price >= " + lowAndHigh[0] + " and d.price <= " + lowAndHigh[1], Dish.class);
        return query.getResultList();
    }

    public List<Dish> havingDiscount() {
        Query query = em.createQuery("select d from Dish d where d.hasDiscount = true");
        return query.getResultList();
    }

    public List<Dish> havingSum1kg() {
        List<Dish> all = getAll();
        List<Dish> result = new ArrayList<>();
        Integer totalWeight = new Integer(0);
        Random random = new Random();
        System.out.println("Dishes under 1000 g in total: ");
        //int size = all.size();
        Dish randomDish;
        while (totalWeight < 1000 && all.size() > 0) {
            randomDish = all.get(random.nextInt(all.size()));
            all.remove(randomDish);
            if (totalWeight + randomDish.getWeightInGrams() <= 1000) {
                System.out.println(randomDish);
                totalWeight += randomDish.getWeightInGrams();
            }
        }
        return result;
    }

    public Double[] getPriceRange() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter lowest price:");
        Double low = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter highest price:");
        Double high = Double.parseDouble(scanner.nextLine());
        Double[] prices = {low, high};
        return prices;
    }
}
