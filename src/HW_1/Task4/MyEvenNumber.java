package HW_1.Task4;

public class MyEvenNumber {
    private int n;

    public MyEvenNumber(int n) {
        if (n % 2 == 0) {
            this.n = n;
        }
        else {
            throw new IllegalArgumentException("Not even number: " + n);
        }
    }
}
