package edu.marur;

public class InitMeOnce {

    private int value = 0;

    public int init() throws InterruptedException {
        if (value == 0) {
            value++;
        }

        return value;
    }

    public int getValue() {
        return value;
    }
}
