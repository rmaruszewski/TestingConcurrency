package edu.marur;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class InitMeOnceGuardedBy {

    @GuardedBy("this")
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
