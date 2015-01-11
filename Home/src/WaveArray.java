//
//Sort an array in wave form
//
//Given an unsorted array of integers, sort the array into a wave like array. An array ‘arr[0..n-1]’ is sorted in wave form if 
//arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >=
public class WaveArray {

	public static void main(String[] args) {
		int[] array = {10,90,49,2,1,5,23};
		waveSort(array);
	}

	public static void waveSort(int[] arrays) {
		for (int i = 1; i < arrays.length; i = i + 2) {
			if (arrays[i] > arrays[i - 1]) {
				swap(arrays, i);
			}
			if (i < arrays.length - 1 && arrays[i] > arrays[i + 1]) {
				swap(arrays, i + 1);
			}
		}
		for (int i = 0; i < arrays.length; i++) {
			System.out.print(arrays[i] + " ");
		}
	}

	private static void swap(int[] arrays, int i) {
		int val = arrays[i];
		arrays[i] = arrays[i - 1];
		arrays[i - 1] = val;

	}
}
