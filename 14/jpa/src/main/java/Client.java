import javax.persistence.*;

/**
 * Created by Yuliia Kulyk on 22.05.2018.
 */
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private String address;
    private Integer age;
    @Column(name = "is_male")
    private boolean isMale;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private ClientImage clientImage;

    public Client() {
    }

    public Client(String name, String surname, String address, Integer age, boolean isMale) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.age = age;
        this.isMale = isMale;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public ClientImage getClientImage() {
        return clientImage;
    }

    public void setClientImage(ClientImage clientImage) {
        this.clientImage = clientImage;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", isMale=" + isMale +
                '}';
    }
}
