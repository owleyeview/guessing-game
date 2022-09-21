// Rashaan Lightpool
// 9/21/2022
// CS 145
// This program asks the user to guess a random number

import java.util.*;

public class GuessingGame {
      
   // Organizes the program and prompts the user to play additional games
   public static void main(String[] args) {
      
      // Sets the range the program will populate a number from
      final int MAX = 100;
      
      Random r = new Random();
      Scanner s = new Scanner(System.in);
      int numGames = 0;
      int totalGuesses = 0;
      int bestGame = 9999;
      intro(MAX);
      char playing;
      do {
         numGames++;
         int thisGame = game(MAX);
         totalGuesses += thisGame;
         if (bestGame > thisGame) {
            bestGame = thisGame;
         }
         System.out.println("Do you want to play again?");
         playing = s.next().charAt(0);
         System.out.println();
      } while (playing == 'y' || playing == 'Y');           
      results (numGames, totalGuesses, bestGame);    
   }
      
   // Introduces the game to the user
   public static void intro(int MAX) {
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("I will think of a number between 1 and");
      System.out.println(MAX + " and will allow you to guess until");
      System.out.println("you get it.  For each guess, I will tell you");
      System.out.println("whether the right answer is higher or lower");
      System.out.println("than your guess.");
      System.out.println();
   }
   
   // Plays one game with the user and returns the number of guesses it took
   public static int game(int MAX) {
      try {
         Random r = new Random();
         Scanner s = new Scanner(System.in);
         int numToGuess = r.nextInt(MAX) + 1;
         System.out.println("I'm thinking of a number between 1 and " + MAX + "...");
         int guess = 0;
         int numOfTries = 0;
         while (guess != numToGuess) {
            System.out.print("Your guess? ");
            guess = s.nextInt();
            numOfTries++;
            if (guess < numToGuess) {
               System.out.println("It's higher.");
            } else if (guess > numToGuess) {
               System.out.println("It's lower.");
            } else {
               if (numOfTries > 1) {
                  System.out.println("You got it right in " + numOfTries + " guesses");
               } else {
                  System.out.println("You got it right in 1 guess");
               }
            }
         }
         return numOfTries;
      } catch (Exception e) {
            System.out.println("Sorry, enter an integer next time.");
            System.exit(0);
      }
      return 0;
   }
   
   // Given the number of games, total guesses and best game score
   // the results from this session of play are displayed
   public static void results(int numGames ,int totalGuesses ,int bestGame) {
      double doubNumGames = numGames;
      double doubTotalGuesses = totalGuesses;
      double guessesDivGame = doubTotalGuesses / doubNumGames;
      System.out.println("Overall results:");
      System.out.println("\t total games   = " + numGames);
      System.out.println("\t total guesses = " + totalGuesses);
      System.out.printf("\t guesses/game  = %.1f\n", guessesDivGame);
      System.out.println("\t best game     = " + bestGame);
   }
} 