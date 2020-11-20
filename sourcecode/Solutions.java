import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;



public class Solution {
	static int T, N, Q, treeSize, mid;
	static int[] tree;
	static int[][] arr, question;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			Q = Integer.parseInt(st.nextToken());
			
			arr = new int[N+1][2];
			question = new int[Q][5];
			
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 1; i <= N ; i++) {
				arr[i][0] = i;
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr, 0, N+1, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o2[1] - o1[1];
				}
			});
			
			
			for (int i = 0; i < Q; i++) {
				st = new StringTokenizer(br.readLine().trim());
				question[i][0] = i;
				question[i][1] = Integer.parseInt(st.nextToken());
				question[i][2] = Integer.parseInt(st.nextToken());
				question[i][3] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(question, 0, Q, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o2[3] - o1[3];
				}
			});
			
			treeSize = 1;
			while (treeSize<N) {
				treeSize *=2;
			}
			
			tree = new int[treeSize+1];
			
			int height = 0;
			int preHeight = 0;
			int point = 0;
			for (int i = 0; i < Q; i++) {
				height = question[i][3];
				if (height != preHeight) {
					while (arr[point][1] > height) {
						update(arr[point][0]+mid);
						point++;
					}
					question[i][4] = get(question[i][1] +mid, question[i][2]+mid);
				} else {
					question[i][4] = get(question[i][1] +mid, question[i][2]+mid);
				}
			}
			
			Arrays.sort(question, 0, Q, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
			});
			
			bw.append("#"+tc);
			for (int i = 0; i < Q; i++) {
				bw.append(" "+question[i][4]);
			}
			bw.append("\n");
			bw.flush();
		}
		bw.close();

	}//main
	
	private static int get(int left, int right) {
		int ans = 0;
		while (left <= right) {
			if (left == right) {
				ans += tree[left];
				return ans;
			}
			if (left%2 == 1) {
				ans += tree[left];
				left++;
			}
			if (left%2 == 0) {
				ans += tree[right];
				right--;
			}
			left /= 2;
			right /= 2;
		}
		return ans; 
	} //get
	
	private static void update(int index) {
		while (index >= 1) {
			tree[index]++;
			index /=2;
		}
	}

}//Solution
