import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuliia Kulyk on 28.05.2018.
 */
@Entity
public class Client {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Account> accounts = new ArrayList<>();

    public Client(String name, String surname, List<Account> accounts) {
        this.name = name;
        this.surname = surname;
        this.accounts = accounts;
    }

    public Client() {
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

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
