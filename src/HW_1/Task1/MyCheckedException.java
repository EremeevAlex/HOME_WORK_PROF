package HW_1.Task1;

public class MyCheckedException
//    extends  RuntimeError/RuntimeException - unchecked
        extends Exception {
    public MyCheckedException(String message) {
        super(message);
    }
}