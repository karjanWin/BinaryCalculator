package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BinaryCalculatorTest {
    @Test
    public void testCalculateBinary() {
        BinaryCalculator calculator = new BinaryCalculator();
        assertEquals("101", calculator.calculateBinary(5));
        assertEquals("0", calculator.calculateBinary(0));
    }
}
