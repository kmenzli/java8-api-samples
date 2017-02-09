package org.prototype.lambda.reference;

/**
 * Created by kmenzli on 2/9/17.
 */
public class MethodReferenceExample {
    // The third parameter of this method is MyFunction (A Functional Interface).
    // When using this method:
    // You can pass the reference of method, if the method is structured
    // similar to the abstract method of MyFunction.

    public static int action(int a, int b, MyFunction func) {
        return func.doSomething(a, b);
    }
    public static void main(String[] args) {
        int a = 100;
        int b = 30;
        // Pass the reference of MyMathUtils.sum method.
        // ==> 130
        int c = action(a, b, MyMathUtils::sum);
        System.out.println("c = " + c);

        // Pass the reference of MyMathUtils.minus method.
        // == 70
        int d = action(a, b, MyMathUtils::minus);

        System.out.println("d = " + d);

        // Pass the reference of Math.subtractExact method.
        // ==> 70
        int e = action(a, b, Math::subtractExact);

        System.out.println("e = " + e);

        // Pass the reference of Math.min method.
        // ==> 30
        int f = action(a, b, Math::min);

        System.out.println("f = " + f);

    }
}
