import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static String userName = "none";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Enter your login: ");
			String login = scanner.nextLine();

			Thread th = new Thread(new GetThread());
			th.setDaemon(true);
			th.start();

            UsersOnline.addUserOnline(login);
            userName = login;

			while (true) {
			    try {
                    System.out.println("Enter your message: ");
                    String text = scanner.nextLine();
                    if (text.isEmpty()) break;
                    Action.ActionType actionType = Action.defineActionType(text);
                    switch (actionType) {
                        case LOGIN:
                            System.out.println("Login in progress...");
                            Login.doLogin();
                            break;
                        case PRIVATE_MESSAGE:
                            String recipient = text.split(" ")[0].replaceAll("@", "");
                            String messageText = text.replaceAll("@" + recipient + " ", "");
                            Message privateMessage = new Message(login, recipient, messageText);
                            int resPriv = privateMessage.send(Utils.getURL() + "/add");
                            if (resPriv != 200) { // 200 OK
                                System.out.println("HTTP error occured: " + resPriv);
                            }
                            break;
                        case CREATE_CHAT_ROOM:
                            System.out.println("Create chat room in progress...");
                            break;
                        case USERS_ONLINE:
                            UsersOnline.getUsersOnline();
                            break;
                        case SEND_TO_ALL:
                            System.out.println("Sending to all in progress...");
                            Message m = new Message(login, text);
                            int res = m.send(Utils.getURL() + "/add");
                            if (res != 200) { // 200 OK
                                System.out.println("HTTP error occured: " + res);
                            }
                            break;
                    }
                } catch (Exception e) {
			        e.printStackTrace();
                }
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			scanner.close();
		}
	}
}
