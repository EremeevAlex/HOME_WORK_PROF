package HW_4;

import java.util.List;
import java.util.stream.Stream;

public class Task2 {  public static void main(String[] args) {
    System.out.println(List.of(1, 2, 3, 4, 5).stream().reduce(1, (mul, i) -> mul * i));
    System.out.println(Stream.of(1, 2, 3, 4, 5).reduce(1, (mul, i) -> mul * i));
}
}
