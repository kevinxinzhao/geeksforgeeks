import java.util.HashMap;
import java.util.Map;

//Given an array containing only 0s and 1s, find the largest subarray which contain equal no of 0s and 1s. 
//Expected time complexity is O(n). 
public class LargestSubarrayWithEqualZeroAndOne {

	public static void main(String[] args) {
		int[] arr = { 0, 0, 1, 1, 0 };
		// largestSubarrayWithEqual0and1(arr);
		int[] arr2 = { 1, 0, 1, 1, 1, 0, 0 };
		// largestSubarrayWithEqual0and1(arr2);
		int[] arr3 = { 1, 1, 1, 1 };
		// largestSubarrayWithEqual0and1(arr3);

		int[] arr4 = { 1, 1, 1, 0, 0, 1 };
		// largestSubarrayWithEqual0and1(arr4);

		largestSubarrayWithEqual0and1Version2(arr4);
	}

	public static void largestSubarrayWithEqual0and1Version2(int[] array) {
		if (array == null || array.length == 0) {
			return;
		}
		int[] sumleft = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			int value = array[i] == 0 ? -1 : array[i];
			if (i - 1 >= 0) {
				sumleft[i] = sumleft[i - 1] + value;
			} else {
				sumleft[i] = value;
			}
		}

		//case 1:
		int max = -1;
		int startIdx = Integer.MIN_VALUE;
		int endIdx = Integer.MAX_VALUE;

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < sumleft.length; i++) {
			if (map.containsKey(sumleft[i])) {
				if (sumleft[i] == sumleft[map.get(sumleft[i])]) {
					max = i - map.get(sumleft[i]);
					startIdx = map.get(sumleft[i]) + 1;
					endIdx = i;
				}
			} else {
				map.put(sumleft[i], i);
			}
		}

		// case 2:
		for (int i = array.length - 1; i >= 0; i--) {
			if (sumleft[i] == 0 && i >= max) {
				System.out.println("0 to " + i);
			}
		}
		
		if (max != -1) {
			System.out.println(startIdx + " to " + endIdx);
		} else {
			System.out.println("No such array");
		}
	}

	public static void largestSubarrayWithEqual0and1(int[] array) {
		if (array == null || array.length == 0) {
			return;
		}
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			int value = array[i] == 0 ? -1 : array[i];
			result += value;
		}
		if (result > 0) {
			// number of 1 is larger than number of 0
			checkContinusProp(array, result, 1);
		} else if (result < 0) {
			// number of 0 is larger than number of 1
			checkContinusProp(array, -result, 0);
		} else {
			System.out.println("no such subarray.");
		}
	}

	private static void checkContinusProp(int[] array, int result, int target) {
		boolean flag = false;
		// case 1:
		int i;
		for (i = 0; i < result; i++) {
			if (array[i] != target) {
				break;
			}
		}
		if (i == result && i < array.length) {
			System.out.println(result + 1 + " to " + array.length);
			flag = true;
		}
		// case 2:
		for (i = array.length - 1; i >= 0; i--) {
			if (array[i] != target) {
				break;
			}
		}
		if (array.length - i - 1 == result && i >= 0) {
			System.out.println("1 to " + (array.length - result + ""));
			flag = true;
		}
		// case 3:
		int num = 0;
		for (i = 0; i < result; i++) {
			if (array[i] != target) {
				break;
			}
			num++;
		}
		if (num != result) {
			int j;
			for (j = array.length - 1; j >= 0; j--) {
				if (array[j] != target) {
					break;
				}
				num++;
			}
			if (num == result) {
				System.out.println(i + " to " + j);
				flag = true;
			}
		}

		if (flag == false) {
			System.out.println("No such subarray");
		}
	}
}
