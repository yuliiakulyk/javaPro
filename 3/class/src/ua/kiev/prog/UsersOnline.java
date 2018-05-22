package ua.kiev.prog;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by Yuliia Kulyk on 06.05.2018.
 */
public class UsersOnline {
    private static Map<String, PrivateMessageList> usersOnline = new TreeMap<>();

    public static Set<String> getUsersOnlineNames() {
        Set<String> set = usersOnline.keySet();
        return set;
    }

    public static Map<String, PrivateMessageList> getUsersOnline() {
        return usersOnline;
    }

    public static void addUserOnline(String userName) {
        usersOnline.put(userName, new PrivateMessageList());
        System.out.println("Added user " + userName + " to list on users online");
    }
}
