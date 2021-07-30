//LIS , BinarySearch 로 풀기
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LIS_BinarySearch {
	static int T, N, idx;
	static int[] A, lis;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			//초기화
			A = new int[N];
			//입력
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
			
			// 구현 
			lis = new int[N];
			lis[0] = A[0];
			idx = 1;
			int tmp = 0;
			for (int i = 1; i < N; i++) {
				if (lis[idx-1] < A[i]) lis[idx++] = A[i];
				else {
					tmp = Arrays.binarySearch(lis, 0, idx, A[i]);
					lis[tmp < 0 ? -tmp -1 : tmp] = A[i];
				}
			}
			//출력
			System.out.println("#"+tc+" "+idx);
		}//test case
	}//main()

}//Solution

/*
2
15
4 1 7 12 9 8 15 6 11 3 5 14 10 17 8
9
3 4 1 4 7 2 5 8 6
(출력)
#1 6
#2 4
*/
