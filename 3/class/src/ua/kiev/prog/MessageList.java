package ua.kiev.prog;

import java.util.LinkedList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MessageList {
	private static final MessageList msgList = new MessageList();
    private static final int LIMIT = 100;

    private final Gson gson;
	private final List<Message> list = new LinkedList<Message>();
	
	public static MessageList getInstance() {
		return msgList;
	}
  
  	private MessageList() {
		gson = new GsonBuilder().create();
	}
	
	public synchronized void add(Message m) {
		list.add(m);
	}

	public synchronized JsonMessages getMessages(int from) {
		//if (from == list.size()) return null;
		return new JsonMessages(list, from);
	}
	
	public synchronized String toJSON(int n) {
		if (n == list.size()) return null;
		return gson.toJson(new JsonMessages(list, n));
	}
}
