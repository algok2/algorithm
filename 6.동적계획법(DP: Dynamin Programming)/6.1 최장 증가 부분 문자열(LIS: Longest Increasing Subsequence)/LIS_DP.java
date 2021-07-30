//시간복잡도 = N^2
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class LIS_DP {
	
	static int[] A = {3,4,1,4,7,2,5,8,6};
	static int[] D;
	static int ans;
	static ArrayList<Integer>[] list;
	
	public static void main(String[] args) throws Exception{
		D = new int[A.length];
		ans = 1;
		for (int i = 0; i < 9; i++) {
			D[i] = 1;
			
			for (int j = 1; j < i; j++) {
				if (A[j] < A[i]) {
					D[i] = Math.max(D[i], D[j]+1);
				}
			}
			ans = Math.max(ans, D[i]);
		}
		
		print(D);
		System.out.println();
		System.out.println(ans);
		
//		System.out.println(min);

	}//main()

	private static void print(int[] arr) {
		for (int i : arr) System.out.print(i+" ");
		
	}

	private static void print(ArrayList<Pair> li) {
		for (Pair pair : li) {
			System.out.println(pair.toString());
		}
		
	}

}//Solution
