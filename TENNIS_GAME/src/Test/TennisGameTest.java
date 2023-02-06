package Test;

import Main.TennisGame;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TennisGameTest {

    TennisGame tennisGame = new TennisGame();

    @Test
    public void beginningOfGameLoveAll() {

        tennisGame.newGame();

        String score = tennisGame.getScore();
        String expected = "Love All";

        assertEquals(expected, score);
    }

    @Test
    public void TestAddSinglePoint() {

        tennisGame.newGame();

        String score    = tennisGame.addPoint(1);
        String expected = "Player 1 gained a point! 15-Love";

        assertEquals(expected, score);

    }

    @Test
    public void TestGetGameScoreSinglePoint() {

        tennisGame.newGame();

        tennisGame.addPoint(1);

        String score    = tennisGame.getScore();
        String expected = "15-Love";

        assertEquals(expected, score);

    }

    @Test
    public void TestGetGameScoreMultiplePoints() {

        tennisGame.newGame();

        tennisGame.addPoint(1);
        tennisGame.addPoint(2);
        tennisGame.addPoint(1);

        String score    = tennisGame.getScore();
        String expected = "30-15";

        assertEquals(expected, score);

    }

    @Test
    public void TestGetGameScoreDeuce() {

        tennisGame.newGame();

        tennisGame.addPoint(1);
        tennisGame.addPoint(2);
        tennisGame.addPoint(1);
        tennisGame.addPoint(2);
        tennisGame.addPoint(1);
        tennisGame.addPoint(2);

        String score    = tennisGame.getScore();
        String expected = "Deuce";

        assertEquals(expected, score);

    }

    @Test
    public void TestGetGameScoreAdvantage1() {

        tennisGame.newGame();

        tennisGame.addPoint(1);
        tennisGame.addPoint(2);
        tennisGame.addPoint(1);
        tennisGame.addPoint(2);
        tennisGame.addPoint(1);
        tennisGame.addPoint(2);
        tennisGame.addPoint(1);

        String score    = tennisGame.getScore();
        String expected = "Advantage Player 1";

        assertEquals(expected, score);

    }

    @Test
    public void TestGetGameScoreAdvantage2() {

        tennisGame.newGame();

        tennisGame.addPoint(1);
        tennisGame.addPoint(2);
        tennisGame.addPoint(1);
        tennisGame.addPoint(2);
        tennisGame.addPoint(1);
        tennisGame.addPoint(2);
        tennisGame.addPoint(2);

        String score    = tennisGame.getScore();
        String expected = "Advantage Player 2";

        assertEquals(expected, score);

    }

    @Test
    public void TestPlayer1Wins() {

        tennisGame.newGame();

        tennisGame.addPoint(1);
        tennisGame.addPoint(2);
        tennisGame.addPoint(1);
        tennisGame.addPoint(1);
        tennisGame.addPoint(2);
        tennisGame.addPoint(1);

        String score    = tennisGame.getScore();
        String expected = "Player 1 wins!";

        assertEquals(expected, score);

    }

    @Test
    public void TestPlayer2Advantage() {

        tennisGame.newGame();

        tennisGame.addPoint(1); // 15-0
        tennisGame.addPoint(2); // 15-15
        tennisGame.addPoint(1); // 30-15
        tennisGame.addPoint(1); // 40-15
        tennisGame.addPoint(2); // 40-30
        tennisGame.addPoint(2); // Deuce
        tennisGame.addPoint(2); // Advantage Player 2

        String score    = tennisGame.getScore();
        String expected = "Advantage Player 2";

        assertEquals(expected, score);

    }

    @Test
    public void TestPlayer2Wins() {

        tennisGame.newGame();

        tennisGame.addPoint(1); // 15-0
        tennisGame.addPoint(2); // 15-15
        tennisGame.addPoint(1); // 30-15
        tennisGame.addPoint(1); // 40-15
        tennisGame.addPoint(2); // 40-30
        tennisGame.addPoint(2); // Deuce
        tennisGame.addPoint(2); // Advantage Player 2
        tennisGame.addPoint(1); // Deuce
        tennisGame.addPoint(2); // Advantage Player 2
        tennisGame.addPoint(2); // Player 2 Wins

        String score    = tennisGame.getScore();
        String expected = "Player 2 wins!";

        assertEquals(expected, score);

    }

    @Test
    public void TestInvalidPlayerPoint() {

        tennisGame.newGame();

        String score    = tennisGame.addPoint(0);
        String expected = "Invalid Player: 0, please enter 1 or 2";

        assertEquals(expected, score);

    }



}
