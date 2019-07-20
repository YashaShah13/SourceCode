package sorting;

public class Sorting {

	public static boolean selectionSort(int[] arr, int low, int high) {

		for (int i = low; i <= high; i++) {
			int min = i;
			int j = i;
			while (j <= high) {
				if (arr[min] > arr[j])
					min = j;
				j++;
			}
			swap(arr, i, min);
		}
		return true;
	}

	public static boolean insertionSort(int[] arr, int low, int high) {
		for (int i = 0; i < high; i++) {
			int min = i + 1;
			int prev = min - 1;

			int irr = min;

			while (prev >= 0 && arr[irr] < arr[prev]) {
				swap(arr, irr, prev);
				irr--;
				prev--;
			}

		}
		return true;
	}

	public static boolean bubbleSort(int[] arr, int low, int high) {
		boolean notSorted = true;
		while (notSorted) {
			for (int i = low; i < high; i++) {
				notSorted = false;
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
					notSorted = true;
				}
			}
			high--;
		}
		return true;
	}

	private static boolean swap(int[] arr, int i, int min) {

		// TODO Auto-generated method stub
		int temp = arr[i];
		arr[i] = arr[min];
		arr[min] = temp;
		return true;

	}

	public static void quickSort(int[] arr, int low, int high) {
		if (low == high) {
			return;
		}
		int left = low;
		int right = high - 1;
		int pevot = high;

		while (left != right) {
			if (arr[left] > arr[pevot] && arr[right] < arr[pevot]) {
				swap(arr, left, right);
				left++;
				right--;
			} else if (arr[left] < arr[pevot])
				left++;
			else
				right--;
		}
		swap(arr, right, pevot);
		pevot = right;

		quickSort(arr, 0, pevot - 1);
		quickSort(arr, pevot + 1, arr.length - 1);

	}

	public static void mergSort(int[] arr, int low, int high) {
		if (high - low >= 1) {
			int mid1 = (low + high) / 2;
			int mid2 = mid1 + 1;

			mergSort(arr, low, mid1);
			mergSort(arr, mid2, high);
			merg(arr, low, mid1, mid2, high);

		}
	}

	private static boolean merg(int[] arr, int low, int mid1, int mid2, int high) {
		// TODO Auto-generated method stub
		int i = low;
		int j = mid2;
		int z = low;

		int[] comb = new int[arr.length];
		while (i <= mid1 && j <= high) {
			if (arr[i] <= arr[j])
				comb[z++] = arr[i++];
			else
				comb[z++] = arr[j++];

		}
		if (i == j)
			while (i <= high)
				comb[z++] = arr[j++];
		else
			while (i <= mid1)
				comb[z++] = arr[i++];
		for (int x = low; x <= high; x++)
			arr[x] = comb[x];
	
		return true;

	}

}
