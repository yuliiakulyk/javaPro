package ua.kiev.prog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.LinkedList;

/**
 * Created by Yuliia Kulyk on 06.05.2018.
 */
public class PrivateMessageList {
    private LinkedList<Message> privateMessageList;
    private final Gson gson;

    public PrivateMessageList() {
        this.privateMessageList = new LinkedList<>();
        gson = new GsonBuilder().create();
    }

    public void addPrivateMessage(Message message) {
        this.privateMessageList.add(message);
    }

    public synchronized JsonMessages getPrivateMessages(int from) {
        //if (from == privateMessageList.size()) return null;
        return new JsonMessages(privateMessageList, from);
    }

    public synchronized String toJson(int n) {
        if (n == privateMessageList.size()) return null;
        return gson.toJson(new JsonMessages(privateMessageList, n));
    }
}
