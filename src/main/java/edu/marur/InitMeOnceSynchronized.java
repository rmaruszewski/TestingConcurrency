package edu.marur;

public class InitMeOnceSynchronized {

    private int value = 0;

    public synchronized int init() throws InterruptedException {
        if (value == 0) {
            value++;
        }

        return value;
    }

    public synchronized int getValue() {
        return value;
    }
}
