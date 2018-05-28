import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.File;

/**
 * Created by Yuliia Kulyk on 22.05.2018.
 */
@Entity
public class ClientImage {
    @Id
    private Long id;
    @Column(name = "client_image")
    private byte[] clientImage;

    @OneToOne(mappedBy = "clientImage")
    private Client client;


}
