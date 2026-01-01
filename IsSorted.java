public class IsSorted {

    // Public function: called by the user
    public static boolean isSorted(int[] a) {
        return isSorted(a, 0);
    }

    // Helper recursive function
    private static boolean isSorted(int[] a, int i) {
        // Base case: if we reached the last element (or array is empty), it's sorted.
        // There are no more pairs to compare.
        if (i >= a.length - 1) {
            return true;
        }
        
        // If the current element is greater than the next one, the array is not sorted.
        if (a[i] > a[i+1]) {
            return false; 
        }
        
        // Recursive step: check the rest of the array starting from the next index.
        return isSorted(a, i + 1);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 5};
        System.out.println(isSorted(a)); // true

        int[] b = {1, 3, 2};
        System.out.println(isSorted(b)); // false
    }
}