import java.util.Scanner;
class numguess{

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int number = (int) (Math.random() * 100) + 1; // Random number between 1 and 100
            int guess = 0;
            int attempts = 0;
            
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have selected a number between 1 and 100. Try to guess it!");
            
            while (guess != number) {
                System.out.print("Enter your guess: ");
                guess = sc.nextInt();
                attempts++;
                
                if (guess < number) {
                    System.out.println("Too low! Try again.");
                } else if (guess > number) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You've guessed the number " + number + " in " + attempts + " attempts.");
                }
            }
        } // Random number between 1 and 100
    }
}