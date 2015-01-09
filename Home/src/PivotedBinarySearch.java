import java.util.Arrays;

//An element in a sorted array can be found in O(log n) time via binary search. 
//But suppose I rotate the sorted array at some pivot unknown to you beforehand. 
//So for instance, 1 2 3 4 5 might become 3 4 5 1 2. Devise a way to find an element in the rotated array in O(log n) time.

public class PivotedBinarySearch {
	public static void main(String[] args) {
		int[] array = { 13, 15, 0, 1, 2, 3, 4, 5, 9, 10 };
		int pivot = findPivot(array, 0, array.length - 1);
		if (pivot < 0) {
			System.out.print("Return");
			return;
		}
		int[] subarray_1 = Arrays.copyOfRange(array, 0, pivot + 1);
		int[] subarray_2 = Arrays.copyOfRange(array, pivot + 1, array.length);

		int index = binarySearch(subarray_1, 0, subarray_1.length - 1, 9);
		if (index == -1) {
			index = binarySearch(subarray_2, 0, subarray_2.length - 1, 9);
			if (index == -1) {
				System.out.print("Cannot find");
			}else{
				index += subarray_1.length;
			}
		}
		System.out.print("index:" + index);
	}

	public static int findPivot(int[] pivotedSortedArray, int left, int right) {
		if (left > right) {
			return -1;
		} else if (left == right) {
			return left;
		}
		int mid = (right - left + 1) / 2;
		if (left < mid && pivotedSortedArray[mid - 1] > pivotedSortedArray[mid]) {
			return mid - 1;
		} else if (mid < right
				&& pivotedSortedArray[mid] > pivotedSortedArray[mid + 1]) {
			return mid;
		} else if (pivotedSortedArray[mid] >= pivotedSortedArray[right]) {
			return findPivot(pivotedSortedArray, mid + 1, right);
		} else {
			return findPivot(pivotedSortedArray, left, mid - 1);
		}
	}

	public static int binarySearch(int[] sortedArray, int left, int right,
			int target) {
		if (left > right) {
			return -1;
		}
		int mid = (right + left) / 2;

		if (sortedArray[mid] == target) {
			return mid;
		} else if (sortedArray[mid] < target) {
			return binarySearch(sortedArray, mid + 1, right, target);
		} else {
			return binarySearch(sortedArray, left, right - 1, target);
		}
	}
}
