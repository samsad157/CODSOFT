import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minRange = 1;
        int maxRange = 100;
        int secretNumber, maxAttempts, attempts, roundsPlayed, roundsWon;
        boolean playAgain = true;

        roundsPlayed = 0;
        roundsWon = 0;

        while (playAgain) {
            secretNumber = (int) (Math.random() * (maxRange - minRange + 1)) + minRange;
            maxAttempts = 5;
            attempts = 0;

            System.out.println("I'm thinking of a number between " + minRange + " and " + maxRange + ". You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == secretNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    roundsWon++;
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }

                if (attempts == maxAttempts) {
                    System.out.println("Sorry, you ran out of attempts. The secret number was " + secretNumber);
                }
            }

            roundsPlayed++;

            System.out.print("Do you want to play again? (yes/no): ");
            String answer = scanner.next();
            playAgain = answer.equalsIgnoreCase("yes");
        }

        System.out.println("Game Over!");
        System.out.println("Rounds Played: " + roundsPlayed);
        System.out.println("Rounds Won: " + roundsWon);
        System.out.println("Score: " + (double) roundsWon / roundsPlayed);

        scanner.close();
    }
}