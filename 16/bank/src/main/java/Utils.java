import java.util.List;

/**
 * Created by Yuliia Kulyk on 28.05.2018.
 */
public class Utils<T> {
    public static <T> void print(List<T> list) {
        for (T object: list) {
            System.out.println(object);
        }
    }
}
