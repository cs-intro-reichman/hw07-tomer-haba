/** Computes the binomial(n,k) function. */
public class Binomial { 
    public static void main(String[] args) {
        // Testing the optimized binomial implementation:
        if (args.length >= 2) {
             System.out.println(binomial(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
        }
    }

    // Computes the Binomial function, basic version.
    // We keep this as int because it's not efficient enough for large numbers anyway.
    public static int binomial1(int n, int k) { 
        if (k > n) {
            return 0;
        }
        if (k == 0 || n == 0) {
            return 1;
        }
        return binomial1(n - 1, k) + binomial1(n - 1, k - 1);
     }
    
    // Computes the Binomial function, efficiently using memoization.
    // CHANGED return type to long to handle large results like binomial(50, 25).
    public static long binomial(int n, int k) {
        // Create the memoization array of size (n+1) x (k+1)
        // CHANGED array type to long[][]
        long[][] memo = new long[n + 1][k + 1];
        
        // Initialize all elements to -1
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                memo[i][j] = -1;
            }
        }
        
        // Call the recursive function with the memo array
        return binomial(n, k, memo);
    }

    // Helper function with memoization
    // CHANGED return type to long and argument to long[][]
    private static long binomial(int n, int k, long[][] memo) {
        // If the value is already computed (not -1), return it
        if (memo[n][k] != -1) {
            return memo[n][k];
        }
        
        // Base case: if k > n, the result is 0
        if (k > n) {
            memo[n][k] = 0; 
            return 0;
        }
        
        // Base case: if k is 0 or n is 0 (and k<=n), the result is 1
        if (n == 0 || k == 0) {
            memo[n][k] = 1; 
            return 1;
        }
        
        // Recursive step: compute and store in memo
        // The result is the sum of the two recursive calls
        memo[n][k] = binomial(n - 1, k, memo) + binomial(n - 1, k - 1, memo);
        
        return memo[n][k];
    }
}