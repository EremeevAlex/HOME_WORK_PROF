package HW_1.Task2;

public class Main {
    public static void main(String[] args) {
        methodZero(0);
        methodZero(1);
    }

    public static void methodZero(int i) {
        if (i == 0) {
            System.out.println("0");
        } else {
            throw new MyUncheckedException("this is not zero");
        }
    }

}
