package net.aomlab.test.java8;

/**
 * Created with IntelliJ IDEA.
 * User: A12715
 * Date: 13/07/29
 * Time: 18:34
 * To change this template use File | Settings | File Templates.
 */
public class DefaultMethod implements A, B {
    public static void main(String[] args) {
        DefaultMethod method = new DefaultMethod();
        method.print("default method");
    }

    @Override
    public void print(String s) {
        System.out.print(s);
    }

    @Override
    public void defaultPrint(String s) {
        A.super.defaultPrint(s);
        B.super.defaultPrint(s);
    }
}

interface A {
    void print(String s);

    default void defaultPrint(String s) {
        print(s);
    }
}

interface B {
    void print(String s);

    default void defaultPrint(String s) {
        print(s);
    }
}