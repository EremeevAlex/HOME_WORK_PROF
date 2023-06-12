package HW_3.Task3;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {

        Class<APrinter> cls = APrinter.class;

        try {
            cls.getMethod("print", int.class).invoke(cls.getConstructor().newInstance(), 5);
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException |
                 IllegalArgumentException |
                 InvocationTargetException e) {
            System.out.println(e.getMessage());
        }
    }
}