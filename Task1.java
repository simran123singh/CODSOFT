import java.util.Scanner;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        int totalScore = 0;
        boolean playAgain = true;

        System.out.println(" Welcome to the Number Guessing Game!");

        while (playAgain) {
            int numberToGuess = rand.nextInt(100) + 1;  // generates number between 1 to 100
            int attemptsLeft = 7;  
            boolean guessedCorrectly = false;

            System.out.println("\nI have picked a number between 1 and 100.");
            System.out.println("Can you guess it? You have " + attemptsLeft + " attempts!");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess;

                // Input validation
                if (input.hasNextInt()) {
                    userGuess = input.nextInt();
                } else {
                    System.out.println("Please enter a valid number!");
                    input.next(); 
                    continue;
                }

                if (userGuess < 1 || userGuess > 100) {
                    System.out.println("Please guess a number between 1 and 100.");
                    continue;
                }

                attemptsLeft--;

                if (userGuess == numberToGuess) {
                    System.out.println(" Correct! You guessed the number!");
                    guessedCorrectly = true;
                    totalScore += (attemptsLeft + 1); 
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                System.out.println("Attempts left: " + attemptsLeft);
            }

            if (!guessedCorrectly) {
                System.out.println(" You’ve used all attempts. The number was: " + numberToGuess);
            }

            System.out.println("Your current score: " + totalScore);
            System.out.println("The number was: "  +guessedCorrectly);

            System.out.print("Do you want to play another round? (yes/no): ");
            String choice = input.next().toLowerCase();

            if (!choice.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\n Game Over! Your total score is: " + totalScore);
        System.out.println("Thanks for playing!");
        input.close();
    }
}