/**
 * This class implements various recursive methods.
 * 
 * @author Kyle Robert Harrison
 * @version 1.0, 02 Apr 2025
 */
public class Recursion {
    /**
     * This method calculates the sum of the squares first n natural numbers.
     * @param n the number of natural numbers to sum.
     * @return the sum of the squares of the first n natural numbers.
     */
    public int sumSquares(int n) {
        return 0;
    }

    /**
     * This method calculates the greatest common divisor of two numbers.
     * @param x the first number.
     * @param y the second number.
     * @return the greatest common divisor of x and y.
     */
    public int gcd(int x, int y) {
        return 0;
    }

    /**
     * Determine if the given character is a vowel, regardless of case. 
     * Note: y is not considered a vowel.
     * 
     * @param c the character to check.
     * @return true if the character is a vowel, false otherwise.
     */
    private boolean isVowel(char c) {
        switch (Character.toLowerCase(c)) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                break;
        }

        return false;
    }

    /**
     * Count the number of vowels in the given string.
     * @param s the string to check.
     * @param pos the current position in the string.
     * @return the number of vowels in the string.
     */
    public int countVowels(String s, int pos) {
        return 0;
    }

    /**
     * This method calculates the sum of the elements in an array.
     * @param arr the array to sum.
     * @param pos the current position in the array.
     * @return the sum of the elements in the array.
     */
    public int sumArray(int[] arr, int pos) {
        return 0;
    }

    /**
     * Determine if the given string is a palindrome. 
     * This is considered an extra task, and is more challenging than the others.
     * @param s the string to check.
     * @param left the left index.
     * @param right the right index.
     * @return true if the string is a palindrome, false otherwise.
     */
    public boolean isPalindrome(String s, int left, int right) {
        return false;
    }
}
