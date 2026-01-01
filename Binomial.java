/** Computes the binomial(n,k) function. */
public class Binomial { 
    public static void main(String[] args) {
        //// Uncomment the version of binomial that you want to test
 
        // Testing the basic binomial implementation:
        // System.out.println(binomial1(Integer.parseInt(args[0]), Integer.parseInt(args[1])));

        // Testing the optimized binomial implementation:
        // We assume arguments are passed via command line, e.g., "java Binomial 5 2"
        if (args.length >= 2) {
             System.out.println(binomial(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
        }
    }

    // Computes the Binomial function, basic version.
    public static int binomial1(int n, int k) { 
        if (k > n) {
            return 0;
        }
        if (k == 0 || n == 0) {
            return 1;
        }
        return binomial1(n - 1, k) + binomial1(n - 1, k - 1);
     }
    
    // Computes the Binomial function, efficiently
    public static int binomial(int n, int k) {
        // Create the memoization array of size (n+1) x (k+1)
        int[][] memo = new int[n + 1][k + 1];
        
        // Initialize all elements to -1
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                memo[i][j] = -1;
            }
        }
        
        // Call the recursive function with the memo array
        return binomial(n, k, memo);
    }

    private static int binomial(int n, int k, int[][] memo) {
        if (memo[n][k] != -1) {
            return memo[n][k];
        }
        // Base case
        if (k > n) {
            memo[n][k] = 0; 
            return 0;
        }
        // Another base case
        if (n == 0 || k == 0) {
            memo[n][k] = 1; 
            return 1;
        }
        // Recursive step with memoization
        memo[n][k] = binomial(n - 1, k, memo) + binomial(n - 1, k - 1, memo);
        return memo[n][k];
    }
}