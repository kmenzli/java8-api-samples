package org.prototype.lambda.consumer;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
/**
 * Created by kmenzli on 2/9/17.
 */
public class ConsumerExample {
    // Using the method List.forEach (Consumer) with Java <8.
    // Print out the elements of the list
    public static void beforeJ8() {
        List<String> list = Arrays.asList("a", "b", "c", "a1", "a2");

        list.forEach(new Consumer<String>() {

            @Override
            public void accept(String t) {
                System.out.println(t);
            }

        });
    }

    // Using the method List.forEach(Consumer) with Java 8 syntax.
    // (Using lambda expression).
    public static void java8Consumer() {
        List<String> list = Arrays.asList("a", "b", "c", "a1", "a2");

        list.forEach((String t) -> {
            System.out.println(t);
        });
    }

    // Using the method List.forEach(Consumer) with Java 8 syntax.
    // (Using lambda expression).
    // (More simply)
    public static void java8ConsumerMoreSimple() {
        List<String> list = Arrays.asList("a", "b", "c", "a1", "a2");

        list.forEach((String t) -> System.out.println(t));
    }
}
