package com.gbhqatest.test;

import com.gbhqatest.utils.BaseTest;
import org.testng.annotations.Test;

public class Test1 extends BaseTest {
    @Test
    public void testMethod1() throws InterruptedException {
        Thread.sleep(2500);
    }
}
