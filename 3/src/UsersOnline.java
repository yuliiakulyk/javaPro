import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Yuliia Kulyk on 05.05.2018.
 */
public class UsersOnline {
    public static void getUsersOnline() throws IOException {
        String response = sendGetRequest();
        System.out.println(response);
    }

    private static String sendGetRequest() throws IOException {
        URL url = new URL(Utils.getURL() + "/usersOnline");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String s;
            while((s = reader.readLine()) != null) {
                builder.append(s);
            }
        }
        return builder.toString();
    }

    public static void addUserOnline(String userName) throws IOException {
        URL url = new URL(Utils.getURL() + "/usersOnline");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        try (OutputStream outputStream = connection.getOutputStream()) {
            outputStream.write(userName.getBytes());
        }
        String s;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }
        }
    }
}
