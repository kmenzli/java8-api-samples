package org.prototype.streams;

import org.prototype.streams.Person;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kmenzli on 2/10/17.
 */
public class Stream3 {

    //--- Old Scholl with JDK < 8
    private static Person getStudentByName(List<Person> persons, String name) {

        Person result = null;
        for (Person temp : persons) {
            if (name.equals(temp.getName())) {
                result = temp;
            }
        }
        return result;
    }


    private static void findAny(List<Person> persons, String name) {
        Person p = persons.stream() //--- get a stream
                                    .filter(x -> x.getName().equals(name)) // --- get only Person with filter name
                                    .findAny() //--- Non deterministic , return an element or null ==> If 'findAny' then return found
                                    .orElse(null); // If not found, return null
        System.out.println("Name is "+p.getName()+" Prenom is "+p.getPrenom()+" Age is "+p.getAge());
    }

    private static void findAnyMultiple(List<Person> persons, String name) {
        Person p = persons.stream() //--- get a stream
                .filter(x -> x.getName().equals(name) && x.getAge() < 33) // --- get only Person with filter name
                .findAny() //--- Non deterministic , return an element or null ==> If 'findAny' then return found
                .orElse(null); // If not found, return null
        System.out.println("Name is "+p.getName()+" Prenom is "+p.getPrenom()+" Age is "+p.getAge());
    }

    public static void main(String[] args) {

        List<Person> persons = Arrays.asList(new Person("khemais","Tounsi",30),new Person("khemais","menzli",35), new Person("sarra","hfaidth",35), new Person("Lili","hassen",60));

        Person result = getStudentByName(persons, "michael");

        //--- > Khemais
        findAny(persons,"khemais");
        System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");

        findAnyMultiple(persons,"khemais");
    }
}
