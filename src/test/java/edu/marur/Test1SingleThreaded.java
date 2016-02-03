package edu.marur;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test1SingleThreaded {

    private InitMeOnce initMeOnce;

    @Before
    public void setUp() {
        initMeOnce = new InitMeOnce();
    }

    @Test
    public void testInit() throws Exception {
        initMeOnce.init();
        initMeOnce.init();
        assertThat(initMeOnce.init()).isEqualTo(1);
    }
}