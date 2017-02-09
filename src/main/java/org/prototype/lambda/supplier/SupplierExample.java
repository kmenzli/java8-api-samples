package org.prototype.lambda.supplier;

import java.util.function.Supplier;
/**
 * Created by kmenzli on 2/9/17.
 */
public class SupplierExample {
    // A method with parameter is Supplier<String>.
    public static void display(Supplier<String> supp) {
        System.out.println(supp.get());
    }

    // Not used Lambda.
    public static void beforeJ8() {
        display(new Supplier<String>() {

            @Override
            public String get() {
                return "Hello";
            }
        });
        display(new Supplier<String>() {

            @Override
            public String get() {
                return "World";
            }
        });
    }

    // Using Lambda expressions.
    public static void java8Supplier() {
        display(() -> {
            return "Hello";
        });

        display(() -> {
            return "World";
        });
    }

    // Using Lambda expressions.
    // (Write shorter).
    public static void java8SupplierShortest() {
        display(() -> "Hello");

        display(() -> "World");
    }

    public static void main(String[] args) {

    }
}
