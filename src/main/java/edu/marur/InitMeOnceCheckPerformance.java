package edu.marur;

public class InitMeOnceCheckPerformance {

    private int value = 0;

    public int init() throws InterruptedException {
        long cmpStartTime = System.nanoTime();
        if (value == 0) {
            long cmpEndTime = System.nanoTime();
            value++;
            long incEndTime = System.nanoTime();
            System.out.printf("Cmp: %d\n", cmpEndTime - cmpStartTime);
            System.out.printf("Inc: %d\n", incEndTime - cmpEndTime);
            System.out.printf("Sum: %d\n", cmpEndTime - cmpStartTime + incEndTime - cmpEndTime);
        }

        return value;
    }

    public static void main(String[] args) throws InterruptedException {
        new InitMeOnceCheckPerformance().init();
    }
}
