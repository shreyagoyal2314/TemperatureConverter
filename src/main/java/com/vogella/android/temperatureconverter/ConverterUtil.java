package com.vogella.android.temperatureconverter;

/**
 * Utility class for celsius to farhenheit conversion and vice versa.
 */
public class ConverterUtil {
    public static float celsiusToFarhenheit(float celsius) {
        return (9 * celsius) / 5 + 32;
    }

    public static float farhenheitToCelsius(float farhenheit) {
        return (farhenheit -32) * 5 / 9;
    }
}
