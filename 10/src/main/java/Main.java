import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by Yuliia Kulyk on 15.05.2018.
 */
public class Main {
    static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/ordersdb"; //?autoReconnect=true&useSSL=false&characterEncoding=utf8&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "root";
    static String createTableClientsStatement = "CREATE TABLE IF NOT EXISTS Clients (client_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(20) NOT NULL, delivery_address VARCHAR(100) NOT NULL, phone_number VARCHAR(20), is_male BOOLEAN DEFAULT NULL);";
    static String createTableProductsStatement = "CREATE TABLE IF NOT EXISTS Products (product_code INT NOT NULL AUTO_INCREMENT PRIMARY KEY, product_name VARCHAR(50) NOT NULL, product_description VARCHAR(50) NOT NULL, price DOUBLE NOT NULL);";
    static String createTableOrdersStatement = "CREATE TABLE IF NOT EXISTS Orders (order_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, client_id INT NOT NULL, product_code INT NOT NULL, product_quantity INT NOT NULL, is_paid BOOLEAN NOT NULL DEFAULT 0);";
    //static String createTableOrderItemsStatement = "CREATE TABLE OrderItems (order_id INT NOT NULL, item_total_price DOUBLE NOT NULL, item_quantity INT NOT NULL, is_paid BOOLEAN NOT NULL DEFAULT 0);";


    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            AbstractDAO clientDAO = new AbstractDAO<Client>(Client.class, conn, "Clients", createTableClientsStatement);
            AbstractDAO productDAO = new AbstractDAO<Product>(Product.class, conn, "Products", createTableProductsStatement);
            AbstractDAO ordersDAO = new AbstractDAO<Order>(Order.class, conn, "Orders", createTableOrdersStatement);

            clientDAO.createTableIfNotExists();
            productDAO.createTableIfNotExists();
            ordersDAO.createTableIfNotExists();

            Scanner scanner = new Scanner(System.in);
            String operation;
            while (true) {
                System.out.println("Choose operation: \n 1 - create client \n 2 - create product \n 3 - create order");
                System.out.println("4 - select all clients \n 5 - select all products \n 6 - select all orders");
                System.out.println("7 - remove client \n 8 - remove product \n 9 - remove order");
                operation = scanner.nextLine().trim();
                switch (operation) {
                    case "1":
                        Client client = Client.readObjectFromConsole(scanner);
                        clientDAO.add(client);
                        break;
                    case "2":
                        Product product = Product.readObjectFromConsole(scanner);
                        productDAO.add(product);
                        break;
                    case "3":
                        Order order = Order.readObjectFromConsole(scanner);
                        ordersDAO.add(order);
                        break;
                    case "4":
                        Utils.printListOfObjects(clientDAO.getAll(Client.class));
                        break;
                    case "5":
                        Utils.printListOfObjects(productDAO.getAll(Product.class));
                        break;
                    case "6":
                        Utils.printListOfObjects(ordersDAO.getAll(Order.class));
                        break;
                    case "7":
                        String id = Utils.getValueFromConsole("client id", scanner);
                        clientDAO.remove(Integer.parseInt(id));
                        break;
                    case "8":
                        String id2 = Utils.getValueFromConsole("product id", scanner);
                        productDAO.remove(Integer.parseInt(id2));
                        break;
                    case "9":
                        String id3 = Utils.getValueFromConsole("order id", scanner);
                        ordersDAO.remove(Integer.parseInt(id3));
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
