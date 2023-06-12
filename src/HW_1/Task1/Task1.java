package HW_1.Task1;

public class Task1 {
    public static void main(String[] args) {
        try {
            methodZero(0);
            methodZero(1);
        }
        catch (MyCheckedException e) {
            e.printStackTrace();
        }
    }

    public static void methodZero(int i) throws MyCheckedException {
        if (i == 0) {
            System.out.println("0");
        }
        else {
            throw new MyCheckedException("This is not zero");
        }
    }
}