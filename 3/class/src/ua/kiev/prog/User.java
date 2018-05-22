package ua.kiev.prog;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yuliia Kulyk on 06.05.2018.
 */
public class User {
    private String userName;
    private HttpSession session;
    private PrivateMessageList privateMessageList;

    public User(String userName, HttpSession session) {
        this.userName = userName;
        this.session = session;
        this.privateMessageList = new PrivateMessageList();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }
}
