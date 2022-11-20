package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {
    Bun bun = new Bun("TestBunName", 3.1f);

    @Test
    public void isGetNameReturnsName() {
        String testName = bun.getName();
        assertEquals("TestBunName", testName);
    }

    @Test
    public void isGetPriceReturnsPrice() {
        float testPrice = bun.getPrice();
        assertEquals(3.1f, testPrice, 0.0f);
    }
}
