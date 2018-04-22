package textContainer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by Yuliia Kulyk on 22.04.2018.
 */
@SaveTo(path = "src\\textContainer\\file.txt")
public class TextContainer {
    String text = "Some string";

    @Saver
    public void save(String path) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(new File(path))) {
            writer.print(this.text);
        }
    }
}
