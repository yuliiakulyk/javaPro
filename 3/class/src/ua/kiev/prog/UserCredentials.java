package ua.kiev.prog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Yuliia Kulyk on 03.05.2018.
 */
public class UserCredentials {
    private String login;
    private String password;

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

    public static UserCredentials fromJson(String json) {
        UserCredentials userCredentials;
        Gson gson = new GsonBuilder().create();
        userCredentials = gson.fromJson(json, UserCredentials.class);
        System.out.println("Built object from Json: " + userCredentials);
        return userCredentials;
    }

    @Override
    public String toString() {
        return "UserCredentials{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
