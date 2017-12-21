import java.util.Arrays;

public class SplitArrayMaxDifference {

    //K splits an array in two
    //for each split, compute the max and
    //take the absolute difference
    //what's the maximum difference?
    public static int solution(int[] A) {
        int maxDifference = 0;

        int[] X = new int[A.length - 1];
        int[] Y = new int[A.length - 1];

        X[0] = A[0];
        for (int k = 1; k < A.length - 1; k++) {
            if (A[k] > X[k-1]) {
                X[k] = A[k];
            } else {
                X[k] = X[k-1];
            }
        }

        Y[Y.length - 1] = A[A.length - 1];
        for (int k = Y.length - 1; k >= 1; k--) {
            if (A[k] > Y[k]) {
                Y[k-1] = A[k];
            } else {
                Y[k-1] = Y[k];
            }
        }

        for (int i = 0; i < X.length; i++) {
            X[i] = Math.abs(X[i] - Y[i]);
        }

        for (int i = 0; i < X.length; i++) {
            if (X[i] > maxDifference) {
                maxDifference = X[i];
            }
        }

        return maxDifference;
    }

    public static int solution1(int[] A) {
        int K = 1;
        int maxDifference = 0;
        while (K < A.length) {
            int[] leftPart = Arrays.copyOfRange(A, 0, K);
            int[] rightPart = Arrays.copyOfRange(A, K, A.length);
            int maxLeft = max(leftPart);
            int maxRight = max(rightPart);
            int diff = Math.abs(maxLeft - maxRight);
            if (diff > maxDifference) {
                maxDifference = diff;
            }
            K++;
        }

        return maxDifference;
    }

    private static int max(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) max = a[i];
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,3,-3}) + ", " + solution1(new int[] {1,3,-3}));
        System.out.println(solution(new int[] {4,3,2,5,1,1}) + ", " + solution1(new int[] {4,3,2,5,1,1}));
        System.out.println(solution(new int[] {1,2}) + ", " + solution1(new int[] {1,2}));
    }
}