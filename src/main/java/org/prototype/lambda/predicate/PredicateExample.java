package org.prototype.lambda.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;
/**
 * Created by kmenzli on 2/9/17.
 */
public class PredicateExample {
    // Use the Stream.filter(Predicate <T>) method way Java <8.
    // Filter a list of integers and prints the odd.
    public static void beforeJ8() {
        List<Integer> list = Arrays.asList(1, 4, 5, 1, 7, 8);


        // Stream containing the elements of the list above.
        Stream<Integer> stream = list.stream();

        // A new stream contains odd
        Stream<Integer> stream2 = stream.filter(new Predicate<Integer>() {

            @Override
            public boolean test(Integer t) {
                return t % 2 == 1;
            }
        });
    }


    // Use the Stream.filter (Predicate <T>) method way Java>= 8.
    // Filter a list of integers and prints the odd.
    // Using Lambda expressions.
    public static void java8Predicate() {
        List<Integer> list = Arrays.asList(1, 4, 5, 1, 7, 8);

        // Stream containing the elements of the list above.
        Stream<Integer> stream = list.stream();

        // A new stream contains odd
        Stream<Integer> stream2 = stream.filter(t -> {
            return t % 2 == 1;
        });

        // Stream.forEach(Consumer<T>)
        stream2.forEach(t -> System.out.println(t));
    }

    // Use the method Stream.filter (Predicate <T>) way Java>= 8.
    // Filter a list of integers and prints the odd.
    // Using Lambda expressions.
    // Simple and more concise.
    public static void java8ConsumerMoreSimple() {
        List<Integer> list = Arrays.asList(1, 4, 5, 1, 7, 8);

        // Stream containing the elements of the list above.
        Stream<Integer> stream = list.stream();

        stream.filter(t -> t % 2 == 1).forEach(t -> System.out.println(t));
    }
}
