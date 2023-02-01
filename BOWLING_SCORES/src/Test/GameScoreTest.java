package Test;
import Main.GameScore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameScoreTest {

    GameScore gameScore;

    @Test
    public void testGetFrameScoreSpare() {
        String frame = "5/";

        int expected = 10;
        int result = gameScore.getFrameScore(frame);

        assertEquals(expected, result);
    }

    @Test
    public void testGetFrameScoreStrike() {
        String frame = "X";

        int expected = 10;
        int result = gameScore.getFrameScore(frame);

        assertEquals(expected, result);
    }

    @Test
    public void testGetFrameScoreNumeric() {
        String frame = "53";

        int expected = 8;
        int result = gameScore.getFrameScore(frame);

        assertEquals(expected, result);
    }

    @Test
    public void testGetFrameScoreOneMiss() {
        String frame = "9-";

        int expected = 9;
        int result = gameScore.getFrameScore(frame);

        assertEquals(expected, result);
    }

    @Test
    public void testGetFrameScoreTwoMisses() {
        String frame = "--";

        int expected = 0;
        int result = gameScore.getFrameScore(frame);

        assertEquals(expected, result);
    }

    @Test
    public void testGetFrameScoreFinalFrame() {
        String frame = "9/X";

        int expected = 20;
        int result = gameScore.getFrameScore(frame);

        assertEquals(expected, result);
    }

    @Test
    public void testGetAttemptValueMiss() {
        char attempt = '-';

        int expected = 0;
        int result = gameScore.getAttemptValue(attempt);

        assertEquals(expected, result);
    }

    @Test
    public void testGetAttemptValueStrike() {
        char attempt = 'X';

        int expected = 10;
        int result = gameScore.getAttemptValue(attempt);

        assertEquals(expected, result);
    }

    @Test
    public void testGetAttemptValueSpare() {
        char attempt = '/';

        int expected = 10;
        int result = gameScore.getAttemptValue(attempt);

        assertEquals(expected, result);
    }

    @Test
    public void testGetAttemptValueNumeric() {
        char attempt = '5';

        int expected = 5;
        int result = gameScore.getAttemptValue(attempt);

        assertEquals(expected, result);
    }

    @Test
    public void testGetGameScore() {
        String frames = "5- 34 52 9- 33 63 73 9- 34 90";

        int expected = 87;
        int result = gameScore.calculateScore(frames);

        assertEquals(expected, result);
    }

}
