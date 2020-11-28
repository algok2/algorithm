
public class SizeKSubset {

	public static void main(String[] args) {
		int[] array = {1,2,3,4};
		int K = 2;
		boolean[] used = new boolean[array.length];
		PrintAllSizeKSubset(array, used, 0, 0, 3);
	}
	static void PrintAllSizeKSubset(int[] array, boolean[] used, int startIndex, int currentSize, int K) {
		if(currentSize == K) {
			for(int i=0; i<array.length; i++) {
				if(used[i]) 
					System.out.print(array[i]+" ");
			}
			System.out.println();
			return;
		}
		if(startIndex == array.length)
			return;
		used[startIndex] = true;
		PrintAllSizeKSubset(array, used, startIndex+1, currentSize+1, K);
		
		used[startIndex] = false;
		PrintAllSizeKSubset(array, used, startIndex+1, currentSize, K);
		
	}
}
