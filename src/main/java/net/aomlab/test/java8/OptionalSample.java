package net.aomlab.test.java8;

import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalInt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: takuma_mori
 * Date: 13/07/30
 * Time: 10:33
 * To change this template use File | Settings | File Templates.
 */
public class OptionalSample {

    /**
     * process is performed if value is not null
     * isPresent method : return value != null;
     */
    @Test
    public void testIsPresent() {
        try {
            Optional<String> nameY = Optional.empty();
            nameY.get();
        } catch (Exception e) {
            assertTrue(e instanceof NoSuchElementException);
        }

        Optional<String> nameX = Optional.of("name");
        if (nameX.isPresent()) {
            assertEquals("name", nameX.get());
        }
    }

    /**
     * process is performed if value is not null (shorten the initialization)
     * ifPresent method : if (value != null) consumer.accept(value);
     */
    @Test
    synchronized public void testIfPresent() {
        Optional<String> nameX = Optional.empty();
        nameX.ifPresent(x -> System.out.println(x));

        Optional<String> nameY = Optional.of("test name");
        nameY.ifPresent(y -> System.out.println(y));
    }

    /**
     * default is selected if value is null
     * orElse : return value != null ? value : other;
     */
    @Test
    public void testOrElse() {
        Optional<String> nameX = Optional.of("value");
        assertEquals("value", nameX.orElse("default value"));

        Optional<String> nameY = Optional.empty();
        assertEquals("default value", nameY.orElse("default value"));
    }

    /**
     * shorten the initialization
     * orElseGet : return value != null ? value : other.get();
     */
    @Test
    public void testOrElseGet() {
        Optional<String> nameX = Optional.of("value");
        assertEquals("value", nameX.orElseGet(() -> "default value"));

        Optional<String> nameY = Optional.empty();
        assertEquals("default value", nameY.orElseGet(() -> "default value"));
    }

    /**
     * throw an Exception if there is no value
     * orElseThrow : return value != null ? value : other.get();
     */
    @Test
    public void testOrElseThrow() {
        Optional<String> name = Optional.empty();
        try {
            System.out.println(name.orElseThrow(() -> new Exception("name is null !!")));
        } catch (Exception e) {
            assertTrue(e instanceof Exception);
        }
    }

    @Test
    public void testOptionalInt() {
        OptionalInt optionalInt = OptionalInt.of(1);
        int value = optionalInt.getAsInt();
        assertEquals(1, value);
    }
}