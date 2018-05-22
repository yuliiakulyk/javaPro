import java.util.Scanner;

/**
 * Created by Yuliia Kulyk on 16.05.2018.
 */
public class Client {
    @Id
    @Column(name = "client_id")
    private int id;
    private String name;
    @Column(name = "delivery_address")
    private String deliveryAddress;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "is_male")
    private boolean isMale;

    public Client(String name, String deliveryAddress, String phoneNumber, boolean isMale) {
        this.name = name;
        this.deliveryAddress = deliveryAddress;
        this.phoneNumber = phoneNumber;
        this.isMale = isMale;
    }

    public Client() {
    }

    public static Client readObjectFromConsole(Scanner scanner) {
        Client client = new Client();
        client.name = Utils.getValueFromConsole("Name", scanner);
        client.deliveryAddress = Utils.getValueFromConsole("Delivery address", scanner);
        client.phoneNumber = Utils.getValueFromConsole("Phone number", scanner);
        client.isMale = Boolean.parseBoolean(Utils.getValueFromConsole("Is male -  true / false", scanner));
        return client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    @Override
    public String toString() {
        return "Client{" +
                "Id=" + id +
                ", name='" + name + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", isMale=" + isMale +
                '}';
    }
}
