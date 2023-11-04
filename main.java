import java.util.Scanner;
import java.util.Random;

public class WordGuessingGame {
    public static void main(String[] args) {
        String[] words = {"programming", "java", "computer", "algorithm", "coding", "developer", "debugging"};
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        String randomWord = words[random.nextInt(words.length)];
        char[] guessedWord = new char[randomWord.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }

        int attempts = 7;
        boolean wordGuessed = false;

        System.out.println("Welcome to the Word Guessing Game!");
        System.out.println("Guess the word: " + new String(guessedWord));

        while (attempts > 0 && !wordGuessed) {
            System.out.print("Enter a letter: ");
            char guess = scanner.next().charAt(0);
            boolean correctGuess = false;

            for (int i = 0; i < randomWord.length(); i++) {
                if (randomWord.charAt(i) == guess) {
                    guessedWord[i] = guess;
                    correctGuess = true;
                }
            }

            if (correctGuess) {
                System.out.println("Correct guess! Updated word: " + new String(guessedWord));
            } else {
                System.out.println("Incorrect guess! Attempts left: " + --attempts);
            }

            if (new String(guessedWord).equals(randomWord)) {
                wordGuessed = true;
                System.out.println("Congratulations! You guessed the word: " + randomWord);
            }
        }

        if (!wordGuessed) {
            System.out.println("Sorry, you have run out of attempts. The word was: " + randomWord);
        }

        scanner.close();
    }
}
