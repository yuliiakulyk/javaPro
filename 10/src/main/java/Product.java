import java.util.Scanner;

/**
 * Created by Yuliia Kulyk on 19.05.2018.
 */
public class Product {
    @Id
    @Column(name = "product_code")
    private int productId;
    @Column(name = "product_name")
    private String productTitle;
    @Column(name = "product_description")
    private String productDescription;
    private double price;

    public Product(int productId, String productTitle, String productDescription, double price) {
        this.productId = productId;
        this.productTitle = productTitle;
        this.productDescription = productDescription;
        this.price = price;
    }

    public Product() {
    }

    public static Product readObjectFromConsole(Scanner scanner) {
        Product product = new Product();
        product.productTitle = Utils.getValueFromConsole("product title", scanner);
        product.productDescription = Utils.getValueFromConsole("product description", scanner);
        product.price = Double.parseDouble(Utils.getValueFromConsole("price (use . as delimiter)", scanner));
        return product;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productTitle='" + productTitle + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", price=" + price +
                '}';
    }
}
