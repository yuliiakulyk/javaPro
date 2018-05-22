import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Yuliia Kulyk on 24.04.2018.
 */
public class Login {
    public String userAccessToken;

    public static void doLogin() {
        String login = Utils.readLineFromConsole("Please enter login: ");
        String password = Utils.readLineFromConsole("Please enter password: ");
        try {
            sendCredentials(login, password);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendCredentials(String login, String password) throws IOException {
        URL url = new URL(Utils.getURL() + "/login");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("POST");

        UserCredentials userCredentials = new UserCredentials(login, password);
        httpURLConnection.setDoOutput(true);
        try (OutputStream outputStream = httpURLConnection.getOutputStream()) {
            String json = Utils.toJSON(userCredentials);
            outputStream.write(json.getBytes());

        }
        String string;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()))) {
            while((string = reader.readLine()) != null) {
                System.out.println(string);
            }
        }
        System.out.println("Login finished. Continue work...");
    }

    public static void addUserOnline() {

    }
}
