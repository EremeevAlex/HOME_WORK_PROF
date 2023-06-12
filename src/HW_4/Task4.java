package HW_4;

import java.util.Collections;
import java.util.stream.Stream;

public class Task4 {

    public static void main(String[] args) {
        Stream.of(-25.6, -10.31, -10.3, 0.89, 0.895, 0.1)
                .sorted(Collections.reverseOrder())
                .forEach(System.out::println);

        //List.of(-25.6, -10.31, -10.3, 0.89, 0.895, 0.1).stream().sorted((x, y) -> y.compareTo(x)).forEach(System.out::println);
    }
}