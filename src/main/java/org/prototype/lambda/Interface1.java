package org.prototype.lambda;

/**
 * Created by kmenzli on 2/8/17.
 */
public class Interface1 {

    public static void main(String[] args) {

        Formula formula1 = new FormulaImpl();

        ;     // 100.0
                // 0.0
                // 0.0

//        Formula formula2 = (a) -> sqrt( a * 100);

        System.out.println("Calculate "+formula1.calculate(100));
        System.out.println("sqrt "+ formula1.sqrt(-23) );
        System.out.println("positive "+ Formula.positive(-4));
    }
}
