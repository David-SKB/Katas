package Test;


import Main.Wordle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordleTest {

    Wordle wordle;

    @Test
    public void testNoMatchingCharacters(){

        String target   = "ropes";
        String guess    = "child";

        String expected = "00000";
        String result   = wordle.match(target, guess);

        assertEquals(expected, result);
    }

    @Test
    public void testCharactersMatchInCorrectPositions(){

        String target   = "alert";
        String guess    = "alarm";

        String expected = "22020";
        String result   = wordle.match(target, guess);

        assertEquals(expected, result);

    }

    @Test
    public void testCharacterInWrongPosition(){

        String target   = "stair";
        String guess    = "chore";

        String expected = "00010";
        String result   = wordle.match(target, guess);

        assertEquals(expected, result);

    }

    @Test
    public void testMixOfMatchAndWrongPosition(){

        String target   = "hairy";
        String guess    = "charm";

        String expected = "01120";
        String result   = wordle.match(target, guess);

        assertEquals(expected, result);

    }

    @Test
    public void testMultipleCharactersInWrongPositions(){

        String target   = "reads";
        String guess    = "elect";

        String expected = "10000";
        String result   = wordle.match(target, guess);

        assertEquals(expected, result);

    }

    @Test
    public void testInvalidStringLength(){

        String target   = "reading";
        String guess    = "elect";

        String expected = "String must be 5 characters long";
        String result   = wordle.match(target, guess);

        assertEquals(expected, result);

    }


}
