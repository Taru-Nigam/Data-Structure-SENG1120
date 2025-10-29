/**
 * Demonstration of using recursion to solve problems.
 * 
 * @author Kyle Robert Harrison
 * @version 1.0, 02 Apr 2025
 */
public class App {
    public static void main(String[] args) throws Exception {
        Recursion r = new Recursion();

        // testing sumSquares
        int numSquares = 5;
        System.out.println("The sum of the squares of the first " + numSquares + " natural numbers is " + r.sumSquares(numSquares));

        // testing gcd
        int x = 20;
        int y = 12;
        System.out.println("The greatest common divisor of " + x + " and " + y + " is " + r.gcd(x, y));

        // testing countVowels
        String s = "The quick brown fox jumps over the lazy dog. ThE qUIck brOwn fOx jUmps OvEr thE lAzy dOg.";
        System.out.println("The number of vowels in \"" + s + "\" is "  + r.countVowels(s, 0));

        // testing sumArray
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("The sum of the elements in the array is " + r.sumArray(arr, 0));

        // testing isPalindrome with palindrome
        String palString = "madam";
        if(r.isPalindrome(palString, 0, palString.length() - 1)) {
            System.out.println("\"" + palString + "\" is a palindrome.");
        } else {
            System.out.println("\"" + palString + "\" is not a palindrome.");
        }

        // testing isPalindrome with non-palindrome
        String nonPalString = "DataStructures";
        if(r.isPalindrome(nonPalString, 0, nonPalString.length() - 1)) {
            System.out.println("\"" + nonPalString + "\" is a palindrome.");
        } else {
            System.out.println("\"" + nonPalString + "\" is not a palindrome.");
        }
    }
}
