package org.prototype.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
/**
 * Created by kmenzli on 2/8/17.
 */
public class Lambda1 {
    public static void main(String[] args) {

        //---  how to sort a list of strings in prior versions of Java 8
        //--- The static utility method Collections.sort accepts a list and a comparator in order to sort the elements of the given list
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
/**
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
*/
        //--- Fin

        //--- Instead of creating anonymous objects all day long, Java 8 comes with a much shorter syntax
/**
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });
*/
        //--- FIN

        //--- Even shorter with java
/**
        Collections.sort(names, (String a, String b) -> b.compareTo(a));
*/
        //--- FIN

        //--- Even shorter with java8 :The java compiler is aware of the parameter types so you can skip them as well.
        Collections.sort(names, (a, b) -> a.compareTo(b));
        //--- FIN

        System.out.println("First "+names);

        names.sort(Collections.reverseOrder());

        System.out.println(names);

        List<String> names2 = Arrays.asList("peter", null, "anna", "mike", "xenia");
        names2.sort(Comparator.nullsLast(String::compareTo));
        System.out.println(names2);

        List<String> names3 = null;

        Optional.ofNullable(names3).ifPresent(list -> list.sort(Comparator.naturalOrder()));

        System.out.println(names3);
    }
}
