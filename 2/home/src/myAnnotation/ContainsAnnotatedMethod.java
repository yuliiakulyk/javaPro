package myAnnotation;

/**
 * Created by Yuliia Kulyk on 22.04.2018.
 */
public class ContainsAnnotatedMethod {

    @MyAnnotation(a = 2, b = 10)
    public void test(int a, int b) {
        System.out.println(a + " + " + b + " = " + (a + b));
    }

    @MyAnnotation(a = 5, b = 15)
    public void test2(int x, int y) {
        System.out.println("x = " + x + ", y = " + y);
    }

}
