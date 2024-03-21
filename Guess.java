// Amaan Seraj
// 01/09/2024
// CS & 145
// Lab 1: Guessing Game
// This program will make a guessing game in which
// you have to find the number by giving it guesses 
// until you get the answer correct

// import from library
import java.util.Random;
import java.util.Scanner;

public class Guess { 

    // main method
    public static void main(String[] args) { 
        Scanner console = new Scanner(System.in);
        Random numberGenerator = new Random(); // method for number generator
        // variables listed
        int games = 0;
        int bestGuess = 10000;
        int totalGuesses = 0;
        boolean gameOver = false;

        Intro(); // intro method

        do { // do while loop
            int testGuess = playGame(console, totalGuesses, numberGenerator);
            totalGuesses += testGuess;

            if (testGuess < bestGuess) {
                bestGuess = testGuess;
            }

            games++;

            System.out.print("Do you want to play again? ");
            char choice = console.next().toLowerCase().charAt(0);

            switch (choice) {
                case 'y':
                    break;
                case 'n':
                    Results(bestGuess, games, totalGuesses);
                    return;
                default:
                    System.out.println("Invalid choice. Please enter 'y' or 'n'.");
            }
        } while (!gameOver);
    }
    // this method introduces the game to the person playing
    public static void Intro() {
        System.out.println("I will think of a number between 1 and");
        System.out.println("100 and will allow you to guess until");
        System.out.println("you get it. For each guess, I will tell you");
        System.out.println("whether the answer is higher or lower");
        System.out.println("than your guess.");
    }
    // this method generates the actual game
    public static int playGame(Scanner console, int totalGuesses, Random numberGenerator) {
        int MAX = 100;
        System.out.println();
        System.out.println("I'm thinking of a number between 1 and " + MAX + "...");

        int number = numberGenerator.nextInt(MAX) + 1;
        boolean gameOver = false;
        int noOfGuesses = 0;

        while (!gameOver) {
            System.out.print("Your guess? ");

            if (!console.hasNextInt()) { // this is in case the user makes a mistake
                console.next(); // Consume invalid input
                System.out.println("Invalid input. Please enter a valid integer.");
                continue;
            }

            int guess = console.nextInt();
            noOfGuesses++;

            if (guess == number) {
                System.out.println("Congrats you got it right in " + noOfGuesses + " guess(es)");
                gameOver = true;
            } else if (guess > number) {
                System.out.println("It's lower.");
            } else {
                System.out.println("It's higher.");
            }
        }

        return noOfGuesses;
    }
    // this method generates results at the end 
    public static void Results(int bestGuess, int games, int totalGuesses) {
        System.out.println("Overall results:");
        System.out.println("    total games   = " + games);
        System.out.println("    total guesses = " + totalGuesses);
        System.out.println("    guesses/game  = " + roundNumber((double) totalGuesses / games));
        System.out.println("    best game     = " + bestGuess);
    }
    // method for rounding to get one decimal place for guesses/game
    public static double roundNumber(double number) {
        return (Math.round(number * 10)) / 10.0;
    }
}
