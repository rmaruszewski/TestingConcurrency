package edu.marur;

public class InitMeOnce {

    private int value = 0;

    public int init() throws InterruptedException {
        if (value == 0) {
            // a little cheating...
            Thread.sleep(0, 1);
            value++;
        }

        return value;
    }
}
