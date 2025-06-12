import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberGuessGame {

    private static final Scanner sc = new Scanner(System.in);
    private static final int MIN = 1;
    private static final int MAX = 100;
    private static final int MAX_ATTEMPTS = 7;

    public static void main(String[] args) {
        System.out.println("=== Welcome to the Number Guessing Game ===");
        System.out.println("I'm thinking of a number between " + MIN + " and " + MAX + ".");
        System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess it.\n");

        int totalRounds = 0;
        int totalWins = 0;

        do {
            totalRounds++;
            boolean won = playSingleRound();
            if (won) totalWins++;

        } while (askToPlayAgain());

        System.out.println("\nGame Over!");
        System.out.println("Rounds played: " + totalRounds);
        System.out.println("Rounds won: " + totalWins);
        System.out.println("Thanks for playing!");
        sc.close();
    }

    // for each round of the guessing game
    private static boolean playSingleRound() {
        int target = generateRandomNumber();
        int attemptsLeft = MAX_ATTEMPTS;

        while (attemptsLeft > 0) {
            System.out.println("Attempts remaining: " + attemptsLeft);
            int guess = getValidGuess();

            if (guess == target) {
                System.out.println(" Bang on! You guessed it right.");
                System.out.println("The number was: " + target + "\n");
                return true;
            } else {
                giveHint(guess, target);
                attemptsLeft--;
            }
        }

        System.out.println(" Out of attempts! The number was: " + target + "\n");
        return false;
    }

    // to generate a random number within the specified range
    private static int generateRandomNumber() {
        return (int) (Math.random() * (MAX - MIN + 1)) + MIN;
    }

    // Prompt the user for a valid guess within range (MIN-MAX)
    private static int getValidGuess() {
        int guess = -1;
        while (true) {
            System.out.print("Enter your guess (" + MIN + "-" + MAX + "): ");
            try {
                guess = sc.nextInt();
                if (guess >= MIN && guess <= MAX) {
                    return guess;
                } else {
                    System.out.println("Please enter a number between " + MIN + " and " + MAX + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("That's not a number. Try again.");
                sc.next(); // Clear invalid input
            }
        }
    }

    // Giving hints based on the user's guess
    private static void giveHint(int guess, int target) {
        if (guess < target) {
            System.out.println("Too low!");
        } else {
            System.out.println("Too high!");
        }
    }

    // Ask if the user wants to play another round
    private static boolean askToPlayAgain() {
        System.out.print("Would you like to play another round? (yes/no): ");
        sc.nextLine(); // clear buffer
        String response = sc.nextLine().trim().toLowerCase();
        return response.equals("yes") || response.equals("y");
    }
}
