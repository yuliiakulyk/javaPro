import java.util.Scanner;

/**
 * Created by Yuliia Kulyk on 26.05.2018.
 */
public class Main {


    public static void main(String[] args) {
        String option;
        DishDao dishDao = new DishDao();
        while(true) {
            option = optionFromConsole();
            switch (option) {
                case "":
                    return;
                case "1":
                    dishDao.addDish(Dish.readDishFromConsole());
                    break;
                case "2":
                    Dish.printDishesList(dishDao.getAll());
                    break;
                case "3":
                    Dish.printDishesList(dishDao.priceFromTo(dishDao.getPriceRange()));
                    break;
                case "4":
                    Dish.printDishesList(dishDao.havingDiscount());
                    break;
                case "5":
                    Dish.printDishesList(dishDao.havingSum1kg());
                    break;
                default:
                    System.out.println("Option you entered doesn't exist");
            }
            if(option.equals("") || option == null) break;
        }
    }

    public static String optionFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select option:");
        System.out.println("1 - add dish");
        System.out.println("2 - select all dishes");
        System.out.println("3 - select dishes within price range");
        System.out.println("4 - select dishes with discount");
        System.out.println("5 - select dishes with total weight < 1 kg");
        return scanner.nextLine();
    }
}
