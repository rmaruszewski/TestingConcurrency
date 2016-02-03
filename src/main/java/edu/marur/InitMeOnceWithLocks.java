package edu.marur;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class InitMeOnceWithLocks {

    private int value = 0;
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();

    public int init() throws InterruptedException {
        writeLock.lock();

        try {
            if (value == 0) {
                value++;
            }

            return value;
        } finally {
            writeLock.unlock();
        }
    }

    public int getValue() {
        readLock.lock();

        try {
            return value;
        } finally {
            readLock.unlock();
        }
    }
}
