package edu.marur;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Test2MultiThreaded {

    private final static int NUM_THREADS = 10;
    private InitMeOnce initMeOnce;

    @Before
    public void setUp() {
        initMeOnce = new InitMeOnce();
    }

    @Test
    public void testInitWithThreads() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        List<Future<Integer>> results = new ArrayList<>();

        for (int i = 0; i < NUM_THREADS; i++) {
            results.add(executorService.submit(() -> initMeOnce.init()));
        }

        for (int i = 0; i < NUM_THREADS; i++) {
            assertThat(results.get(i).get()).isEqualTo(1);
        }
    }
}