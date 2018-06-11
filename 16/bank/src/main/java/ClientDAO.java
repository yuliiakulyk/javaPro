import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Yuliia Kulyk on 28.05.2018.
 */
public class ClientDAO {
    public EntityManager em;

    public ClientDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Bank");
        this.em = emf.createEntityManager();
    }

    public void addClient(Client client) {
        em.getTransaction().begin();
        em.persist(client);
        em.getTransaction().commit();
    }

    public List<Client> getAll() {
        Query query = em.createQuery("select c from Client");
        return query.getResultList();
    }


}
