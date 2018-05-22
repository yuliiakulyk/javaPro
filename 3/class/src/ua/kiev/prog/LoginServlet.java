package ua.kiev.prog;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yuliia Kulyk on 02.05.2018.
 */
public class LoginServlet extends HttpServlet {
    private static final Map<String, String> correctCredentials = addCredentials();

    private static HashMap<String,String> addCredentials() {
        HashMap<String, String> map = new HashMap<>();
        map.put("admin", "admin");
        return map;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String request = inputStreamToString(req.getInputStream());
        UserCredentials userCredentials = UserCredentials.fromJson(request);
        if (areCredentialsValid(userCredentials)) {
            resp.addHeader("loginSuccessful", "true");
            req.getSession(true).setAttribute("loggedIn", true);
            resp.getOutputStream().println("Login successful");
        } else {
            resp.addHeader("loginSuccessful", "false");
            req.getSession(true).setAttribute("loggedIn", false);
            resp.getOutputStream().println("Login failed");
        }
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    public static String inputStreamToString(InputStream inputStream) throws IOException {
        StringBuilder builder = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String string;
            while ((string = reader.readLine()) != null) {
                builder.append(string);
            }
        }
        System.out.println("Read string from input stream: " + builder);
        return builder.toString();
    }

    public static boolean areCredentialsValid(UserCredentials userCredentials) {
        String correctPassword = correctCredentials.get(userCredentials.getLogin());
        if (correctPassword == null) {
            return false;
        } else if (correctPassword.equals(userCredentials.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

}
