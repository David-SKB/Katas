package Main;

import java.util.HashMap;
import java.util.Map;

public class Wordle {

    public static void main(String[] args){

        /*
        a program, which, given a 5 character string as a target word, and a 5 character string as a guess, return a 5 character string where:

        ‘2’ = this letter is in this position
        ‘1’ = this letter is in the target word but not this position
        ‘0’ = this letter is either not in the target word, or is not in the target word as many times as it is in the guess
         */

    }

    // Mutable counter class for character occurrences
    static class Counter {

        int value = 1;
        public void increment ()    { value++;      }
        public void decrement ()    { value--;      }
        public int get ()           { return value; }
    }

    public static String match(String target, String guess){

        String result = "";

        // Return if string is of invalid length
        if (target.length() != 5 || guess.length() != 5) {
            return "String must be 5 characters long";
        }
        // Create a map for storing occurrences of each character in the target word
        Map<Character,Counter> charCount = new HashMap<Character, Counter>();

        // Map occurrence of each character
        for (int i = 0; i < target.length(); i++) {

            Counter count = charCount.get(target.charAt(i));

            if (count == null) {

                // Create mapping if absent
                charCount.put(target.charAt(i), new Counter());

            } else {

                // Otherwise increment
                count.increment();

            }

        }

        // Compare characters in each position
        for (int j = 0; j < target.length(); j++) {

            char targetChar     = target.charAt(j);
            char guessChar      = guess.charAt(j);
            Counter count       = charCount.get(guessChar);

            // Check if character does not exist in target word
            if (charCount.get(guessChar) == null) {

                result += "0";
                continue;
            }

            // Letter is in correct position
            if (targetChar == guessChar) {

                // Check if there are no more occurrences to be found*
                if (count.value == 0) result += "0";

                // Check if there are still occurrences are left to be found
                if (count.value > 0) {

                    // Decrement counter to keep track of how many occurrences have been found
                    count.decrement();
                    result += "2";

                }

            } else {

                // Letter is out of position, check if any occurrences are left
                if (count.value > 0) {

                    // Decrement counter to keep track of how many occurrences have been found
                    count.decrement();
                    result += "1";

                } else {

                    // No occurrences left
                    result += "0";

                }

            }

        }

        return result;
    }
}
