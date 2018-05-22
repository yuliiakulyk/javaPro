package ua.kiev.prog;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetListServlet extends HttpServlet {
	
	private MessageList msgList = MessageList.getInstance();

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		String fromStr = req.getParameter("from");
		String fromPrivateStr = req.getParameter("privateFrom");
		int from;
		int privateFrom;
		String userName = req.getParameter("userName");
		try {
			from = Integer.parseInt(fromStr);
			privateFrom = Integer.parseInt(fromPrivateStr);
		} catch (Exception ex) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
		}
		String json = null;
		if (userName.equals("none")) {
            JsonMessages publicMessages = msgList.getMessages(from);
            if (publicMessages != null) {
                json = publicMessages.toJSON();
            }
        } else {
            JsonMessages publicMessages = msgList.getMessages(from);
            PrivateMessageList privateMessagesAll = UsersOnline.getUsersOnline().get(userName);
            JsonMessages privateMessages = privateMessagesAll.getPrivateMessages(privateFrom);
            List<Message> allMessages = publicMessages.getList();
            if (allMessages == null) {
                allMessages = privateMessages.getList();
            } else {
                allMessages.addAll(privateMessages.getList());
            }
            JsonMessages allJsonMessages = new JsonMessages(allMessages, 0);
            json = allJsonMessages.toJSON();
        }
		if (json != null) {
            OutputStream os = null;
            try {
                os = resp.getOutputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] buf = json.getBytes(StandardCharsets.UTF_8);
            try {
                os.write(buf);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
}
