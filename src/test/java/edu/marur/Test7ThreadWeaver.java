package edu.marur;

import com.google.testing.threadtester.*;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test7ThreadWeaver {

    private InitMeOnce initMeOnce;

    @Test
    public void testThreading() {
        AnnotatedTestRunner runner = new AnnotatedTestRunner();
        // Run all Weaver tests in this class, using InitMeOnce as the Class Under Test
        runner.runTests(this.getClass(), InitMeOnce.class);
    }

    @ThreadedBefore
    public void setUp() {
        initMeOnce = new InitMeOnce();
    }

    @ThreadedMain
    public void mainThread() throws Exception {
       initMeOnce.init();
    }

    @ThreadedSecondary
    public void secondThread() throws Exception {
        initMeOnce.init();
    }

    @ThreadedAfter
    public void after() throws Exception {
        assertThat(initMeOnce.init()).isEqualTo(1);
    }
}