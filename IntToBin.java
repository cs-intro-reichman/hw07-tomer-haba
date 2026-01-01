/** Returns the binary representation of a given integer. */
public class IntToBin {

    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        System.out.println("Binary representation of " + x + " is: " + toBinary(x));
    }

    /** Returns the binary representation of the given integer, as a string of 0's and 1's.  */
    public static String toBinary(int x) {
        // Base cases: if x is 0 or 1, return the string representation directly
        if (x == 0) {
            return "0";
        }
        if (x == 1) {
            return "1";
        }
        // Recursive step: solve for x/2 and append the remainder (x%2)
        return toBinary(x / 2) + (x % 2);
    }    
 }