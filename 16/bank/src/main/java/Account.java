import javax.persistence.*;
import java.util.List;

/**
 * Created by Yuliia Kulyk on 28.05.2018.
 */
@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    private String currency;
    private Double balance;
    @OneToMany(mappedBy = "fromAccount")
    private List<Transaction> transactionsOut;
    @OneToMany(mappedBy = "toAccount")
    private List<Transaction> transactionsIn;

    public Account(Client client, String currency, Double balance, List<Transaction> transactionsOut, List<Transaction> transactionsIn) {
        this.client = client;
        this.currency = currency;
        this.balance = balance;
        this.transactionsOut = transactionsOut;
        this.transactionsIn = transactionsIn;
    }

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactionsOut() {
        return transactionsOut;
    }

    public void setTransactionsOut(List<Transaction> transactionsOut) {
        this.transactionsOut = transactionsOut;
    }

    public List<Transaction> getTransactionsIn() {
        return transactionsIn;
    }

    public void setTransactionsIn(List<Transaction> transactionsIn) {
        this.transactionsIn = transactionsIn;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", client=" + client +
                ", currency='" + currency + '\'' +
                ", balance=" + balance +
                ", transactionsOut=" + transactionsOut +
                ", transactionsIn=" + transactionsIn +
                '}';
    }
}
