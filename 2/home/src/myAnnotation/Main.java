package myAnnotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Yuliia Kulyk on 22.04.2018.
 */
public class Main {
    public static void main(String[] args) {
        runAnnotatedMethodsForClass("myAnnotation.ContainsAnnotatedMethod");
    }

    public static void runAnnotatedMethodsForClass(String className) {
        try {
            Class<?> c = Class.forName("myAnnotation.ContainsAnnotatedMethod");
            Method[] methods = c.getDeclaredMethods();
            for (Method method: methods) {
                System.out.println("Checking class " + className + ", method " + method.getName());
                if (method.isAnnotationPresent(MyAnnotation.class)) {
                    System.out.println("Class " + className + " contains annotated method " + method.getName());
                    Object o = c.newInstance();
                    MyAnnotation test = method.getAnnotation(MyAnnotation.class);
                    method.invoke(o, test.a(), test.b());
                }
            }
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
}
