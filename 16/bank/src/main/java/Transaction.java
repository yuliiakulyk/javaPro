import org.hibernate.mapping.Join;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Yuliia Kulyk on 28.05.2018.
 */
@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "account_from_id")
    private Account fromAccount;
    @ManyToOne
    @JoinColumn(name = "account_to_id")
    private Account toAccount;
    private Long creditedFromAccount;
    private Long debitedToAccount;
    private Date date;

    public Transaction(Account fromAccount, Account toAccount, Long creditedFromAccount, Long debitedToAccount, Date date) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.creditedFromAccount = creditedFromAccount;
        this.debitedToAccount = debitedToAccount;
        this.date = date;
    }

    public Transaction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public void setToAccount(Account toAccount) {
        this.toAccount = toAccount;
    }

    public Long getCreditedFromAccount() {
        return creditedFromAccount;
    }

    public void setCreditedFromAccount(Long creditedFromAccount) {
        this.creditedFromAccount = creditedFromAccount;
    }

    public Long getDebitedToAccount() {
        return debitedToAccount;
    }

    public void setDebitedToAccount(Long debitedToAccount) {
        this.debitedToAccount = debitedToAccount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", fromAccount=" + fromAccount +
                ", toAccount=" + toAccount +
                ", creditedFromAccount=" + creditedFromAccount +
                ", debitedToAccount=" + debitedToAccount +
                ", date=" + date +
                '}';
    }
}
