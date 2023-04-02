import java.util.*;
public class GameMaster {
    private final ArrayList<Integer> digits = getSecretNumber();
    private static ArrayList<Integer> getSecretNumber() {
        ArrayList<Integer> numbersOneToTen = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbersOneToTen.add(i);
        }
        Collections.shuffle(numbersOneToTen, new Random());
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            numbers.add(numbersOneToTen.get(i));
        }
        return numbers;
    }
    public BullsAndCows countBullsAndCows(int[] guess) {
        int cows = 0;
        int bulls = 0;

        for (int i = 0; i < 4; i++) {
            if (guess[i] == digits.get(i)) {
                bulls++;
            } else if (contains(digits, guess[i])) {
                cows++;
            }
        }
        return new BullsAndCows(cows, bulls);
    }
    public record BullsAndCows(int cows, int bulls) {
    }
    private static boolean contains(ArrayList<Integer> array, int value) {
        for (int j : array) {
            if (j == value) {
                return true;
            }
        }
        return false;
    }
}
