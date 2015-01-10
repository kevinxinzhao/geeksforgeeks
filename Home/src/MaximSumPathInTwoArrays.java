//Given two sorted arrays such the arrays may have some common elements. 
//Find the sum of the maximum sum path to reach from beginning of any array to end of any of the two arrays. 
//We can switch from one array to another array only at common elements.
//Expected time complexity is O(m+n) where m is the number of elements in ar1[] and n is the number of elements in ar2[].

public class MaximSumPathInTwoArrays {

	public static void main(String[] args) {
		int[] arr1 = { 2, 3, 7, 10, 12 };
		int[] arr2 = { 1, 5, 7, 8 };

		findMaxSum(arr1, arr2);

		int[] arr3 = { 10, 12 };
		int[] arr4 = { 5, 7, 9 };
		findMaxSum(arr3, arr4);

		int[] arr5 = { 2, 3, 7, 10, 12, 15, 30, 34 };
		int[] arr6 = { 1, 5, 7, 8, 10, 15, 16, 19 };
		findMaxSum(arr5, arr6);
	}

	public static void findMaxSum(int[] array1, int[] array2) {
		if ((array1 == null && array2 == null) || (array1.length == 0 && array2.length == 0)) {
			System.out.println("No Sum");
			return;
		}
		if (array1.length == 0) {
			sumArray(array1);
			return;
		}
		if (array2.length == 0) {
			sumArray(array2);
			return;
		}
		int i = 0;
		int j = 0;
		int segmentSum1 = 0;
		int segmentSum2 = 0;
		int maximSum = 0;

		for (i = 0, j = 0; i < array1.length && j < array2.length;) {
			if (array1[i] == array2[j]) {
				segmentSum1 += array1[i++];
				segmentSum2 += array2[j++];
				maximSum += getMax(segmentSum1, segmentSum2);
				segmentSum1 = segmentSum2 = 0;
			} else if (array1[i] > array2[j]) {
				segmentSum2 += array2[j++];
			} else {
				segmentSum1 += array1[i++];
			}
		}
		if (i < array1.length) {
			for (; i < array1.length; i++) {
				segmentSum1 += array1[i];
			}
		}
		if (j < array2.length) {
			for (; j < array2.length; j++) {
				segmentSum1 += array2[j];
			}
		}
		maximSum += getMax(segmentSum1, segmentSum2);
		System.out.println(maximSum);
	}

	private static int getMax(int segmentSum1, int segmentSum2) {
		if (segmentSum1 > segmentSum2) {
			return segmentSum1;
		}
		return segmentSum2;
	}

	private static void sumArray(int[] array) {
		int sum = 0;
		for (int k = 0; k < array.length; k++) {
			sum += array[k];
		}
		System.out.println(sum);
		return;
	}
}
