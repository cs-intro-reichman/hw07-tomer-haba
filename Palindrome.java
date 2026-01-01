/** Checks if a given string is a palindrome. */
public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(args[0]));
    }
    
    /** Checks if the given string is a palindrome. */
    public static boolean isPalindrome(String s) {
        // Base case: if the string has length 0 or 1, it is a palindrome
        if (s.length() <= 1) {
            return true;
        }

        // Check if the first and last characters are different
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }

        // Recursive step: call the function with the substring excluding the first and last characters
        return isPalindrome(s.substring(1, s.length() - 1));
    }
}