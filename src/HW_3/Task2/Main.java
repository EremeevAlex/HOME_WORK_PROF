package HW_3.Task2;

import HW_3.Task1.IsLike;

public class Main {
    public static void main(String[] args) {
        check(LikeClass.class);
        check(NotLikeClass.class);
        check(SimpleClass.class);
    }

    public static void check(Class<?> cls) {
        if (!cls.isAnnotationPresent(IsLike.class)) {
            System.out.println("Annotation not found");
            return;
        }
        IsLike isLike = cls.getAnnotation(IsLike.class);
        System.out.println("IsLike: " + isLike.value());
    }

}
