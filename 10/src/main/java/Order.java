import java.util.Scanner;

/**
 * Created by Yuliia Kulyk on 19.05.2018.
 */
public class Order {
    @Id
    @Column(name = "order_id")
    private int orderNumber;
    @Column(name = "client_id")
    private int clientId;
    @Column(name = "product_code")
    private int productCode;
    @Column(name = "product_quantity")
    private int productQuantity;
    @Column(name = "is_paid")
    private boolean isPaid;

    public Order(int orderNumber, int clientId, int productCode, int productQuantity, boolean isPaid) {
        this.orderNumber = orderNumber;
        this.clientId = clientId;
        this.productCode = productCode;
        this.productQuantity = productQuantity;
        this.isPaid = isPaid;
    }

    public Order() {
    }

    public static Order readObjectFromConsole(Scanner scanner) {
        Order order = new Order();
        order.clientId = Integer.parseInt(Utils.getValueFromConsole("Client id", scanner));
        order.isPaid = Boolean.parseBoolean(Utils.getValueFromConsole("is paid - true / false", scanner));
        order.productCode = Integer.parseInt(Utils.getValueFromConsole("product code", scanner));
        order.productQuantity = Integer.parseInt(Utils.getValueFromConsole("product quantity", scanner));
        return order;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public double getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", clientId=" + clientId +
                ", productCode=" + productCode +
                ", productQuantity=" + productQuantity +
                '}';
    }
}
