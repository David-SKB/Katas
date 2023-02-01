package Main;

import java.util.Arrays;

public class GameScore {

    static final char strike    = 'X';
    static final char spare     = '/';
    static final char miss      = '-';

    public static void main(String[] args) {

        /*
        Scoring Rules

        Spare: 10 points + the number of pins you knock down for your first attempt at the next frame.

        Strike: score 10 points + the number of pins you knock down for the entire next frame.

        Double:
        1st frame – 20 points + the number of pins you knock down in 3rd frame
        2nd frame – same as scoring for strike

        Turkey:
        1st frame - 30 points
        2nd frame – same as scoring for double
        3rd frame – same as scoring for strike

        Four-Bagger:
        1st frame - 30 points
        2nd frame - 30 points

        3rd frame – same as scoring for double
        4th frame – same as scoring for strike
         */

        String frames = "X 9/ 5/ 72 X X X 9- 8/ 9/X";

        int score = calculateScore(frames);
        System.out.println(score);

    }

    public static int calculateScore(String frames) {

        int finalScore = 0;

        // Add additional 0 frame at the end for final frame OOB issues
        frames += " --";

        // Split frames into an array for processing
        String[] frameArray = frames.split(" ");

        // A game is usually 10 frames, assigning to a variable for flexibility
        int gameLength = frameArray.length - 1;

        // Array to keep track of running total
        int[] frameScores = new int[gameLength];

        // process each frame and calculate the score
        for (int i = 0; i < frameArray.length - 1; i++) {

            //int frameScore      = 0;
            int currentFrame    = i;
            char firstAttempt   = frameArray[i].charAt(0);

            if (firstAttempt == strike) {

                // Check subsequent roles to calculate score
                while(currentFrame < gameLength) {

                    // Another strike detected
                    if (frameArray[currentFrame+1].charAt(0) == strike) {

                        // Increment and check the next frame
                        currentFrame++;
                        continue;
                    }

                    // Check if consecutive strikes were found and add score
                    int consecutiveStrikes = currentFrame - i;

                    if (consecutiveStrikes > 0) {

                        // Turkey / Four-Bagger detected
                        if (consecutiveStrikes > 1) {
                            finalScore += 30;
                        }

                        // Double detected
                        if (consecutiveStrikes == 1) {
                            finalScore += ( 20 + getFrameScore(frameArray[currentFrame+1]) );
                        }

                    } else {

                        // Single strike detected, calculate score
                        int currentFrameScore = 10 + getFrameScore(frameArray[currentFrame+1]);
                        finalScore += currentFrameScore;

                    }

                    // Exit while loop and move on to next frame
                    break;

                }

            } else {

                // Not a strike, check if Spare and add first attempt of the next frame, otherwise sum score from current frame
                if (getFrameScore(frameArray[currentFrame]) == 10) {
                    finalScore += 10 + Character.getNumericValue(frameArray[currentFrame+1].charAt(0));
                } else {
                    finalScore += getFrameScore(frameArray[currentFrame]);
                }

            }

            // Log and move on to next frame
            frameScores[i] = finalScore;

        }

        // Display scores for each frame
        System.out.println(Arrays.toString(frameScores));

        // Return final score
        return finalScore;
    }

    // Helper used to calculate the score for a frame
    public static int getFrameScore(String frame) {

        // Check if final frame has 3 attempts
        if (frame.length() == 3) {

            // If spare detected, return 10 + last roll
            if (frame.charAt(1) == spare ) return 10 + getAttemptValue(frame.charAt(2));

            // Otherwise return 30, as triple strike is the only remaining possibility
            return 30;

        }

        // Return 10 if strike or spare
        if (frame.charAt(0) == strike || frame.charAt(1) == spare) return 10;

        // Otherwise sum attempts and return
        int firstAttempt    = ( frame.charAt(0) == miss ) ? 0 : Character.getNumericValue(frame.charAt(0));
        int secondAttempt   = ( frame.charAt(1) == miss ) ? 0 : Character.getNumericValue(frame.charAt(1));
        return ( firstAttempt + secondAttempt );

        //return (frame.charAt(0) == strike || frame.charAt(1) == spare ) ? 10 : frame.charAt(0) + frame.charAt(1);

    }

    public static int getAttemptValue(char attempt) {

        if (attempt == miss) return 0;
        if (attempt == strike || attempt == spare) return 10;
        return Character.getNumericValue(attempt);
    }
}
