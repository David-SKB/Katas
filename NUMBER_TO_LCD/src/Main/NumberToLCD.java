package Main;

public class NumberToLCD {

    public static void main(String[] args) {

        /*
        A program that given a number (with arbitrary number of digits), converts it into LCD style numbers using the following format:

           _  _     _  _  _  _  _  _
         | _| _||_||_ |_   ||_||_|| |
         ||_  _|  | _||_|  ||_| _||_|
        (each digit is 3 lines high)

        Todo: Part 2, variable width/height adjustment (e.g. width = 3 height = 2)

        When height = 1, lines = 3
        When height = 2, lines = 7
        when height = 3, lines = 9
        when height = 4, lines = 11

        formula = ???

        depends on spacers...

        when height is 1 gap is 0
        when height is 2 gap is 1
        can I assume when height is 3 gap is 2?

         ___
            |
            |
         ___
        |
        |
         ___

         ___
            |
            |
            |
         ___
        |
        |
        |
         ___

         ___
            |
            |
            |
            |
         ___
        |
        |
        |
        |
         ___

         */


    }

    public static String convert(int number) {

        // Assuming only positive numbers are allowed
        if (number < 0 ) return "Positive Numbers Only";

        String result   = "";
        int length      = String.valueOf(number).length();
        String numberString = String.valueOf(number);

        String line1 = "";
        String line2 = "";
        String line3 = "";

        // Append each numbers LCD line values
        for (int i = 0; i < length; i++) {

            String[] lines = getNumberLCDLine(numberString.charAt(i));

            line1 += lines[0];
            line2 += lines[1];
            line3 += lines[2];

        }

        // Append newline character
        line1 += "\n";
        line2 += "\n";
        line3 += "\n";

        // Add lines to result string
        result = line1 + line2 + line3;

        return result;
    }

    // Helper to retrieve the LCD line values for a given number
    public static String[] getNumberLCDLine(char value){

        String[] lines  = new String[3];

        // Convert character to int
        int number      = Integer.parseInt(String.valueOf(value));

        if (number == 1) {
            lines[0] = " ";
            lines[1] = "|";
            lines[2] = "|";
        }

        if (number == 2) {
            lines[0] = " _ ";
            lines[1] = " _|";
            lines[2] = "|_ ";
        }

        if (number == 3) {
            lines[0] = " _ ";
            lines[1] = " _|";
            lines[2] = " _|";
        }

        if (number == 4) {
            lines[0] = "   ";
            lines[1] = "|_|";
            lines[2] = "  |";
        }

        if (number == 5) {
            lines[0] = " _ ";
            lines[1] = "|_ ";
            lines[2] = " _|";
        }

        if (number == 6) {
            lines[0] = " _ ";
            lines[1] = "|_ ";
            lines[2] = "|_|";
        }

        if (number == 7) {
            lines[0] = " _ ";
            lines[1] = "  |";
            lines[2] = "  |";
        }

        if (number == 8) {
            lines[0] = " _ ";
            lines[1] = "|_|";
            lines[2] = "|_|";
        }

        if (number == 9) {
            lines[0] = " _ ";
            lines[1] = "|_|";
            lines[2] = " _|";
        }

        if (number == 0) {
            lines[0] = " _ ";
            lines[1] = "| |";
            lines[2] = "|_|";
        }

        return lines;
    }
}
