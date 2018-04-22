package textContainer;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Yuliia Kulyk on 22.04.2018.
 */
public class Main {
    public static void main(String[] args) {
        try {
            saveTextToFile();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void saveTextToFile() throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> clsContainer = Class.forName("textContainer.TextContainer");
        if (clsContainer.isAnnotationPresent(SaveTo.class)) {
            Method[] methods = clsContainer.getDeclaredMethods();
            for (Method method: methods) {
                if (method.isAnnotationPresent(Saver.class)) {
                    Object o = clsContainer.newInstance();
                    SaveTo annotation = clsContainer.getAnnotation(SaveTo.class);
                    method.invoke(o, annotation.path());
                }
            }
        }
    }

}
