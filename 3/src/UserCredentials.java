/**
 * Created by Yuliia Kulyk on 05.05.2018.
 */
public class UserCredentials {
    protected String login;
    protected String password;

    public UserCredentials(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
