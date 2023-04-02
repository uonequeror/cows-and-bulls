import java.util.*;
public class Main {
    public static void main (String[] args) {
        GameMaster gameMaster = new GameMaster();
        System.out.println();
        int attempts = 0;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a 4-digit number with no space and repeating digits: ");
            String guessString = scanner.nextLine();
            if (!isValidInput(guessString)) {
                System.out.println("Invalid input. Please enter a 4-digit number with no space and repeating digits.");
                continue;
            }
            int[] guess = stringToDigits(guessString);
            GameMaster.BullsAndCows result = gameMaster.countBullsAndCows(guess);
            System.out.println(result.cows() + " cows " + result.bulls() + " bulls");
            System.out.println();
            attempts++;
            if (result.bulls() == 4) {
                System.out.println("Congratulations! You guessed the secret number in " + attempts + " attempts.");
                return;
            }
        }
    }
    private static int[] stringToDigits( String guessString) {
            int[] guess = new int[4];
            for (int i = 0; i < 4; i++) {
                guess[i] = Character.getNumericValue(guessString.charAt(i));
            }
        return guess;
    }
    private static boolean isValidInput(String guessString) {
        if (guessString.length() != 4) {
            return false;
        }
        Set<Character> uniqueChars = new HashSet<>();
        for (int i = 0; i < guessString.length(); i++) {
            char ch = guessString.charAt(i);
            if (!Character.isDigit(ch)) {
                return false;
            }
            if (!uniqueChars.add(ch)) {
                return false;
            }
        }
        return true;
    }
}