package net.aomlab.test.java8;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 * User: takuma_mori
 * Date: 13/07/30
 * Time: 10:33
 * To change this template use File | Settings | File Templates.
 */
public class OptionalSample {
    public static void main(String[] args) {
        testIfPresent();
        testIsPresent();

        testOrElse();
        testOrElseGet();
        testOrElseThrow();
    }

    /**
     * process is performed if value is not null
     * isPresent method : return value != null;
     */
    public static void testIsPresent() {
        // NoSuchElementException
        Optional<String> nameY = Optional.empty();
        //nameY.get();

        Optional<String> nameX = Optional.of("name");
        if (nameX.isPresent()) {
            System.out.println(nameX.get());
        }
    }

    /**
     * process is performed if value is not null (shorten the initialization)
     * ifPresent method : if (value != null) consumer.accept(value);
     */
    public static void testIfPresent() {
        Optional<String> nameX = Optional.empty();
        nameX.ifPresent(x -> System.out.println(x));

        Optional<String> nameY = Optional.of("test name");
        nameY.ifPresent(y -> System.out.println(y));
    }

    /**
     * default is selected if value is null
     * orElse : return value != null ? value : other;
     */
    public static void testOrElse() {
        Optional<String> nameX = Optional.of("value");
        System.out.println(nameX.orElse("default value"));

        Optional<String> nameY = Optional.empty();
        System.out.println(nameY.orElse("default value"));
    }

    /**
     * shorten the initialization
     * orElseGet : return value != null ? value : other.get();
     */
    public static void testOrElseGet() {
        Optional<String> name = Optional.empty();
        System.out.println(name.orElseGet(() -> "default value"));
    }

    /**
     * throw an Exception if there is no value
     * orElseThrow : return value != null ? value : other.get();
     */
    public static void testOrElseThrow() {
        Optional<String> name = Optional.empty();
        try {
            System.out.println(name.orElseThrow(() -> new Exception("name is null !!")));
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}