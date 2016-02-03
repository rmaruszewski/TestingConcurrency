package edu.marur;

import com.google.testing.threadtester.*;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test7ThreadWeaverWithLocks {

    private InitMeOnceWithLocks initMeOnce;

    @Test
    public void testThreading() {
        AnnotatedTestRunner runner = new AnnotatedTestRunner();
        // Run all Weaver tests in this class, using MyList as the Class Under Test
        runner.runTests(this.getClass(), InitMeOnceWithLocks.class);
    }

    @ThreadedBefore
    public void setUp() {
        initMeOnce = new InitMeOnceWithLocks();
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