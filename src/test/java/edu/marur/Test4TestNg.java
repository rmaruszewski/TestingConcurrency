package edu.marur;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test4TestNg {

    private InitMeOnce initMeOnce;

    @BeforeTest
    public void setUp() {
        initMeOnce = new InitMeOnce();
    }

    @DataProvider(name = "inputData", parallel = true)
    public Object[][] whatever() {
        return new Object[][] {
                {"test1", 1},
                {"test2", 1},
                {"test3", 1}
        };
    }

    @Test(threadPoolSize = 3, invocationCount = 5, dataProvider = "inputData")
    public void testParallel(String testId, int result) throws Exception {
        assertThat(initMeOnce.init()).isEqualTo(result);
    }
}