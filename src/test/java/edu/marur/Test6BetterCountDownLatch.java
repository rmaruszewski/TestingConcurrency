package edu.marur;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Test6BetterCountDownLatch {

    private final static int NUM_THREADS = 10;
    private InitMeOnce initMeOnce;

    @Before
    public void setUp() {
        initMeOnce = new InitMeOnce();
    }

   @Test
    public void testCountDownLatch() throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(NUM_THREADS);
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        List<Future<Integer>> results = new ArrayList<>();

        for (int i = 0; i < NUM_THREADS; i++) {
            results.add(executorService.submit(() -> {
                countDownLatch.countDown();
                countDownLatch.await();
                return initMeOnce.init();
            }));
        }

        for (int i = 0; i < NUM_THREADS; i++) {
            assertThat(results.get(i).get()).isEqualTo(1);
        }
    }
}