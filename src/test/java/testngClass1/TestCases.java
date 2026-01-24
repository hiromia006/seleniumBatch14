package testngClass1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCases {
    @Test
    public void firstTestCase1() {
        System.out.println("This is the first test case.");
        Assert.assertEquals(10, 10);
    }

    @Test
    public void firstTestCase2() {
        System.out.println("This is the first test case.");
    }
}
