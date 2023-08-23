import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!!!!!!");

        boolean playAgain = true;
        while (playAgain) {
            int generatedNumber = (int) (Math.random() * (maxRange - minRange + 1)) + minRange;
            System.out.println("I have generated a number between " + minRange + " and " + maxRange);

            int userGuess;
            int attempts = 0;
            boolean hasGuessed = false;

            while (!hasGuessed && attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You've guessed the number " + generatedNumber + " correctly in " + attempts + " attempts!");
                    score++;
                    hasGuessed = true;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Your guess is too low.Try Again");
                } else {
                    System.out.println("Your guess is too high.Try Again");
                }
            }

            if (!hasGuessed) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + generatedNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            playAgain = playAgainResponse.equals("yes");
        }

        scanner.close();
        System.out.println("Thanks for playing! Your total score is: " + score);
    }
}
