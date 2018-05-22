/**
 * Created by Yuliia Kulyk on 24.04.2018.
 */
public class Action {

    public static enum ActionType {
        LOGIN, USERS_ONLINE, PRIVATE_MESSAGE, CREATE_CHAT_ROOM, SEND_TO_ALL;
    }

    public static ActionType defineActionType(String input) {
        if (input.trim().equalsIgnoreCase("login")) {
            System.out.println("Login action is chosen...");
            return ActionType.LOGIN;
        } else if(input.trim().equalsIgnoreCase("users online")) {
            System.out.println("Printing users online...");
            return ActionType.USERS_ONLINE;
        } else if(input.trim().toLowerCase().startsWith("create chat")) {
            System.out.println("Creating chat...");
            return ActionType.CREATE_CHAT_ROOM;
        } else if(input.startsWith("@")) {

            System.out.println("Private message selected...");
            return ActionType.PRIVATE_MESSAGE;
        } else {
            return ActionType.SEND_TO_ALL;
        }
    }
}
