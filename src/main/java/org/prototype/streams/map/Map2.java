package org.prototype.streams.map;

import org.prototype.streams.Person;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kmenzli on 2/10/17.
 */
public class Map2 {

    private static void map (List<Person> persons, String filter) {
        String name = persons.stream()
                .filter(x -> filter.equals(x.getName()))
                .map(Person::getName)						//convert stream to String
                .findAny()
                .orElse("");
        System.out.println(" NAME is "+name);
    }
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(new Person("khemais","Tounsi",30),new Person("khemais","menzli",35), new Person("sarra","hfaidth",35), new Person("Lili","hassen",60));

        map(persons, "khemais");
    }
}
