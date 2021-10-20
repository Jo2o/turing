package hackerrank.fibonacci;

public class FibonacciMemoization {

    public static void main(String[] args) {
        int[] memo = {0, 0, 0, 0, 0, 0};
        System.out.println(fibonacci(6, memo));
    }

    /**
     * Finds n-th Fibonacci number.
     */
    private static int fibonacci(int n, int[] memo) {
        int result = -1;

        if (memo[n-1] != 0) {
            return memo[n-1];
        }

        if (n == 1 || n == 2) {
            return 1;
        } else {
            result = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
            memo[n-1] = result;
        }

        return result;
    }
}
