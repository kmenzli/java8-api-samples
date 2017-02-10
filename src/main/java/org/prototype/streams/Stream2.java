package org.prototype.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kmenzli on 2/10/17.
 */
public class Stream2 {

    //--Before Streams jdk < 8
    private static List<String> getFilterOutput(List<String> lines, String filter) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (!"mkyong".equals(line)) {
                result.add(line);
            }
        }
        return result;
    }

    //--- With Streams JDK 8
    private static void streamFilter(List<String> lines, String filter) {
        List <String> result = lines.stream() //convert list to stream
                            .filter(e -> !e.equals(filter)) //filters the line, equals to "mkyong"
                            .collect(Collectors.toList())//collect the output and convert streams to a List
                            ;
        result.forEach(e ->System.out.println(e));
    }
    public static void main(String[] args) {
        List<String> lines = Arrays.asList("spring", "node", "mkyong");
        List<String> result = getFilterOutput(lines, "mkyong");
        for (String temp : result) {
            System.out.println(temp);	//output : spring node
        }

        streamFilter(lines,"mkyong");

    }
}
