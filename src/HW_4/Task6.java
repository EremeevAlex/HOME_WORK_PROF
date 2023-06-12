package HW_4;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Task6 {
    public static void main(String[] args) {
        System.out.println(Set.of(
                        Set.of(1, 2, 3), Set.of(4, 5, 6), Set.of(7, 8, 9)
                )
                .stream()
                .flatMap(Set::stream)
                .collect(Collectors.toSet()));


        Set<Integer> set1 = new HashSet<>();
        set1.add(38);
        set1.add(39);
        set1.add(40);
        set1.add(45);
        set1.add(46);
        Set<Integer> set2 = new HashSet<>();
        set2.add(38);
        set2.add(27);
        set2.add(29);
        set2.add(22);
        set2.add(20);
        Set<Integer> set3 = new HashSet<>();
        set3.add(15);
        set3.add(22);
        set3.add(6);
        set3.add(89);

        Set<Set<Integer>> setSetInt = new HashSet<Set<Integer>>();
        setSetInt.add(set1);
        setSetInt.add(set2);
        setSetInt.add(set3);

        Set<Integer> finalSet = new HashSet<>();

        setSetInt.forEach(finalSet::addAll);

        finalSet.stream().sorted().forEach(System.out::println);
    }

    private static Set<Integer> convertSet(Set<Set<Integer>> sets) {
        return sets.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }
}