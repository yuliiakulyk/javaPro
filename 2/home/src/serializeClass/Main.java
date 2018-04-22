package serializeClass;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Yuliia Kulyk on 22.04.2018.
 */
public class Main {
    public static void main(String[] args) {
        try {
            TestClass testClass = createObject(TestClass.class, "String1", "String2", 3, "String4");
            System.out.println(testClass);
            saveClassToFile(testClass);
            TestClass testClassRestored = restoreClassFromFile(TestClass.class);
            System.out.println(testClassRestored);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveClassToFile(TestClass o) throws FileNotFoundException, IllegalAccessException {
        Class<?> classObject = o.getClass();
        if (classObject.isAnnotationPresent(SaveToFile.class)) {
            Field[] fields = classObject.getDeclaredFields();
            SaveToFile annotation = classObject.getAnnotation(SaveToFile.class);
            try (PrintWriter writer = new PrintWriter(new File(annotation.path()))) {
                for (Field field: fields) {
                    if (field.isAnnotationPresent(Save.class)) {
                        writer.println(field.getName() + "=" + field.get(o));
                    }
                }
            }
        }
    }

    public static TestClass restoreClassFromFile(Class<?> classObject) throws IOException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        if(classObject.isAnnotationPresent(SaveToFile.class)) {
            SaveToFile annotation = classObject.getAnnotation(SaveToFile.class);
            TestClass o = (TestClass) classObject.newInstance();
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(annotation.path()))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    if (classObject.getField(line.split("=")[0]).getType().equals(String.class)) {
                        classObject.getField(line.split("=")[0]).set(o, line.split("=")[1]);
                    } else if(classObject.getField(line.split("=")[0]).getType().equals(int.class)) {
                        classObject.getField(line.split("=")[0]).set(o, Integer.parseInt(line.split("=")[1]));
                    }
                }
            }
            return o;
        }
        return null;
    }

    public static TestClass createObject(Class<?> classObject, String field1, String field2, int field3, String field4) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = classObject.getConstructor(String.class, String.class, int.class, String.class);
        TestClass o = (TestClass) constructor.newInstance(field1, field2, field3, field4);
        return o;
    }
}
