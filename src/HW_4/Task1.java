package HW_4;

import java.util.stream.IntStream;

public class Task1 {
    public static void main(String[] args) {
        System.out.println(IntStream.rangeClosed(1, 100)
                .filter(i -> i % 2 == 0)
                .reduce(0, Integer::sum)
        );
    }

    static void calc() {
        int res = IntStream.iterate(2, m -> (m + 2)).limit(50).sum();
    }
}
