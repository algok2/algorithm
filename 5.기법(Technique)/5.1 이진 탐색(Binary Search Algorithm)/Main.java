import java.util.Arrays;

public class Main {
//	static int[] arr = {4, 1, 7, 12, 9, 8, 15, 6, 11, 3, 5, 14, 10, 17, 8};
	static int[] arr = { 4, 1, 7, 7, 7, 12, 9, 8, 15, 6, 11, 3, 5, 14, 10, 17, 8 };

	public static void main(String[] args) throws Exception {

		int n = 13;
		Arrays.parallelSort(arr);
		print(arr);
		int tmp = Arrays.binarySearch(arr, n);
		System.out.println("Arrays.binarySearch : " + (-tmp - 1));
		System.out.println("binarySearch : " + binarySearch(arr, n));
		System.out.println("정답: " + f_binarySearch(n));
	}// main()

	private static void print(int[] arr) {
		System.out.println(Arrays.toString(arr));

	}// print()

	private static int f_binarySearch(int n) {
		int s = 0;
		int e = arr.length - 1;
		int mid = 0;

		while (s < e) {
			System.out.println(mid);
			mid = (s + e) / 2;
			if (arr[mid] < n)
				s = mid + 1;
			else
				e = mid;
		}
		return s;
	}// f_binarySearch

	public static int binarySearch(int[] a, int key) {
		return binarySearch(a, 0, a.length, key);
	}

	private static int binarySearch(int[] a, int fromIndex, int toIndex, int key) {
		int low = fromIndex;
		int high = toIndex - 1;
		int found = -1;

		while (low <= high) {
			int mid = (low + high) >>> 1;
			int midVal = a[mid];

			if (midVal < key) {
				low = mid + 1;
			} else if (midVal > key) {
				high = mid - 1;
			} else {
				found = mid;
//				For last occurrence:
//				low = mid + 1;
//				For first occurrence:
				high = mid - 1;
			}
		}
		return found;
	}

}// Main
