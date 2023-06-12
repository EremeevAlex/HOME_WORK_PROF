package HW_2.Task1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task1 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0, 1, 1, 2, 3, 4, 4, 5);
        List<Integer> list1 = List.of(0, 1, 1, 2, 3, 4, 4, 5);
        System.out.println(convert(list));
    }

    public static <T> Set<T> convert(List<T> from) {
//        HashSet<T> res = new HashSet<>();
//        return res.addAll(from);
        return new HashSet<>(from);
    }
}