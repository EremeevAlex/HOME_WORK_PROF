package HW_4;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task5 {
    public static void main(String[] args) {
        System.out.println(Stream.of("abc", "def", "qqq")
                .map(String::toUpperCase)
                .collect(Collectors.joining(", ")));

        System.out.println(Stream.of("abc", "def", "qqq").map(String::toUpperCase).collect(Collectors.joining(", ")));

    }
}