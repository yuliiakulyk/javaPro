import java.util.List;
import java.util.Scanner;

/**
 * Created by Yuliia Kulyk on 19.05.2018.
 */
public class Utils <T> {

    public static String getValueFromConsole(String parameter, Scanner scanner) {
        System.out.println("Enter '" + parameter + "' value: ");
        return scanner.nextLine().trim();
    }

    public static <T> void printListOfObjects(List<T> list) {
        for (T t: list) {
            System.out.println(t);
        }
    }
}
