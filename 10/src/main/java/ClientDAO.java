import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Yuliia Kulyk on 17.05.2018.
 */
public class ClientDAO {
    private final Connection conn;
    //private final String table;
    private final String createTableClientsStatement = "CREATE TABLE IF NOT EXISTS Clients (client_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(20) NOT NULL, delivery_address VARCHAR(100) NOT NULL, phone_number VARCHAR(20), is_male BOOLEAN DEFAULT NULL);";

    public ClientDAO(Connection conn) {
        this.conn = conn;
    }

    public void createTableIfNotExists() throws SQLException {
        try (Statement st = conn.createStatement()) {
            st.execute(createTableClientsStatement);
        }
    }

    public void add(Client client) throws SQLException {
        StringBuilder builder = new StringBuilder("insert into Clients (name, delivery_address, phone_number, is_male) values (");
        builder.append("\"" + client.getName() + "\",");
        builder.append("\"" + client.getDeliveryAddress() + "\",");
        builder.append("\"" + client.getPhoneNumber() + "\",");
        builder.append(client.isMale() + ");");
        System.out.println(builder);
        try (Statement statement = conn.createStatement()) {
            statement.execute(builder.toString());
        }
    }

    public void remove(int id) {
        StringBuilder builder = new StringBuilder("delete from Clients where client_id = \"" + id + "\";");
    }
}
