	package programs;

	import java.util.Arrays;

	public class SmallestDifference {
	    public static void main(String[] args) {
	        int[] A = {1, 3, 15, 11, 2};
	        int[] B = {23, 127, 235, 19, 8};

	        int smallestDifference = computeSmallestDifference(A, B);

	        System.out.println("Smallest Difference: " + smallestDifference);
	    }

	    private static int computeSmallestDifference(int[] A, int[] B) {
	        Arrays.sort(A);
	        Arrays.sort(B);

	        int minDifference = Integer.MAX_VALUE;
	        int i = 0;
	        int j = 0;

	        while (i < A.length && j < B.length) {
	            int difference = Math.abs(A[i] - B[j]);
	            minDifference = Math.min(minDifference, difference);

	            if (A[i] < B[j]) {
	                i++;
	            } else {
	                j++;
	            }
	        }

	        return minDifference;
	    }
	}

