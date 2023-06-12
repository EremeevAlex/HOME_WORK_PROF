package HW_4;

import java.util.List;
import java.util.function.Predicate;

public class Task3 {
    public static void main(String[] args) {
        System.out.println(List.of("abc", "", "", "def", "qqq")
                .stream().filter(s -> s.length() > 0).count());
    }

    private static long calc(List<String> list) {
        return list.stream()
                .filter(Predicate.not(String::isBlank)).count();
    }
}