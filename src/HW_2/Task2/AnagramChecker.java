package HW_2.Task2;

import java.util.Arrays;

public class AnagramChecker {
    public static void main(String[] args) {
        System.out.println(isAnagram("бейсбол", "бобслей"));
    }

    public static boolean isAnagram(String str1, String str2) {
        char[] charArr1 = str1.replace(" ", "").toCharArray();
        char[] charArr2 = str2.replace(" ", "").toCharArray();

        if (charArr1.length != charArr2.length) {
            return false;
        }
        Arrays.sort(charArr1);
        Arrays.sort(charArr2);
        return Arrays.equals(charArr1, charArr2);
    }

    public static boolean check(String s1, String s2) {
        return Arrays.equals(s1.chars().sorted().toArray(), s2.chars().sorted().toArray());
    }
}