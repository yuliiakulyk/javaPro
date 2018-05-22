import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Scanner;

public class Utils {
    private static final String URL = "http://127.0.0.1";
    private static final int PORT = 8080;

    public static String getURL() {
        return URL + ":" + PORT;
    }

    public static String readLineFromConsole(String showHint) {
        System.out.println(showHint);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    public static String toJSON(Object o) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(o);
    }
}
