package Main;

public class TennisGame {

    int player1Score = 0;
    int player2Score = 0;
    int winner = 0;

    public static void main(String args[]) {

    }

    public void newGame() {
        this.player1Score = 0;
        this.player2Score = 0;
        this.winner = 0;
    }

    public String getScore(){

        if (player1Score == 0 && player2Score == 0) {

            return "Love All";

        }

        if (player1Score == player2Score && player1Score >= 3) {

            return "Deuce";

        }

        // Check if the game is over
        int difference      = Math.abs(player1Score - player2Score);
        int combinedScore   = player1Score + player2Score;

        if ( winner != 0 || (difference >= 2 && combinedScore > 4) ) {

            this.winner = (player1Score > player2Score) ? 1 : 2;
            return "Player " + winner + " wins!";

        }

        // Check for advantage if a player is leading by 1 point and both players have 3 points or more
        if (combinedScore > 6) {

            if (player1Score - player2Score == 1) {
                return "Advantage Player 1";
            }
            else {
                return "Advantage Player 2";
            }

        }

        // Otherwise return score
        return getScoreString(player1Score) + "-" + getScoreString(player2Score);

    }

    private String getScoreString(int score) {

        // Score is 0 (Love)
        if (score == 0) {
            return "Love";
        }

        // Score is 1 or 2 (15 or 30)
        if (score == 1 || score == 2) {

            return Integer.toString(score * 15);
        }

        // Score is 3 or greater (score is 40 unless advantage)
        if (score >= 3) {
            return "40";
        }

        // Uncaught exception
        return "Invalid Score";

    }

    public String addPoint(int player) {

        if (winner != 0) {
            return "Game has ended, Player " + winner + " wins. Play again with .newGame()";
        }

        if (player == 1 || player == 2) {

            if (player == 1) { this.player1Score++; } else { this.player2Score++; };

            return "Player " + player + " gained a point! " + getScore();

        }

        return "Invalid Player: " + player + ", please enter 1 or 2";

    }

}
