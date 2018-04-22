package myAnnotation;

import java.lang.annotation.*;

/**
 * Created by Yuliia Kulyk on 22.04.2018.
 *
 * 1. Создать аннотацию, которая принимает параметры для метода. Написать код, который вызовет метод,
 * помеченный этой аннотацией, и передаст параметры аннотации в вызываемый метод.
 * @Test(a=2, b=5)
 * public void test(int a, int b) {…}
 *
 */
@Target(value=ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    int a();
    int b();
}
