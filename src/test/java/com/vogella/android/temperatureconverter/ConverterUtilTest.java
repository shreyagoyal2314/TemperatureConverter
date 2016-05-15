package com.vogella.android.temperatureconverter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ConverterUtilTest {
    @Test
    public void celsiusToFarhenhietTest() throws Exception {
        assertEquals(32, (int) ConverterUtil.celsiusToFarhenheit(0));
        assertEquals(212, (int) ConverterUtil.celsiusToFarhenheit(100));
    }

    @Test
    public void farhenhietToCelsiusTest() throws Exception {
        assertEquals(0, (int) ConverterUtil.farhenheitToCelsius(32));
        assertEquals(100, (int) ConverterUtil.farhenheitToCelsius(212));
    }
}