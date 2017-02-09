package org.prototype.lambda.function;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;
/**
 * Created by kmenzli on 2/9/17.
 */
public class FunctionExample {
    // Use Stream.map(Function) with Java syntax <8.
    // Print out the molecules in List.
    public static void beforeJ8() {
        List<String> list = Arrays.asList("a", "c", "B", "e", "g");

        // Stream containing the elements of the list.
        Stream<String> stream = list.stream();

        // Stream.map(Function):
        // <R> Stream<R> map(Function<? super T, ? extends R> mapper);

        // Returns a new Stream, with the elements were changed.
        Stream<String> streamUpper = stream.map(new Function<String, String>() {

            @Override
            public String apply(String t) {
                return t == null ? null : t.toUpperCase();
            }

        });

        streamUpper.forEach(t -> System.out.println(t));
    }

    public static void java8Function() {
        List<String> list = Arrays.asList("a", "c", "B", "e", "g");

        // Stream containing the elements of the list.
        Stream<String> stream = list.stream();

        stream.map(t -> t == null ? null : t.toUpperCase()).forEach(
                t -> System.out.println(t));
    }

    public static void main(String[] args) {

        beforeJ8();

        java8Function();
    }
}
