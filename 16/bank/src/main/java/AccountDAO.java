import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by Yuliia Kulyk on 29.05.2018.
 */
public class AccountDAO {
    private EntityManager em;

    public AccountDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Bank");
        this.em = emf.createEntityManager();
    }

    public void creditAccount(Account account, Double amount) {
        account.setBalance(account.getBalance() - amount);
    }

    public void debitAccount(Account account, Double amount) {
        account.setBalance(account.getBalance() + amount);
    }
}
