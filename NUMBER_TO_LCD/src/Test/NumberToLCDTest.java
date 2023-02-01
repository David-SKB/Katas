package Test;

import Main.NumberToLCD;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class NumberToLCDTest {

    NumberToLCD numberToLCD;

    @Test
    public void testNumberToLCDAllNumbers() {

        int number = 1234567890;

        String line1 = "  _  _     _  _  _  _  _  _ \n";
        String line2 = "| _| _||_||_ |_   ||_||_|| |\n";
        String line3 = "||_  _|  | _||_|  ||_| _||_|\n";

        String result           = NumberToLCD.convert(number);
        String expected         = line1 + line2 + line3;

        assertEquals(expected, result);

    }

    @Test
    public void testNumberToLCDNegative() {

        int number = -1234567890;

        String result           = NumberToLCD.convert(number);
        String expected         = "Positive Numbers Only";

        assertEquals(expected, result);

    }



}
