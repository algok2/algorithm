import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class IndexTree {
	private static long[] tree;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int S = 1;
		while(S < N) S <<= 1;
		
		tree = new long[S*2];
		for (int i = S; i <= S+N-1; i++) tree[i] = Long.parseLong(br.readLine().trim());
		for (int i = S; i <= S+N-1; i++) {
			int P = i/2;
			while (P!=0) {
				tree[P] = tree[P] + tree[i];
				P /= 2;
			}
		}
		
		for (int i = 1; i <= M+K; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a ==1) {
				update(S+b-1, c);
			}else {
				System.out.println(sum(S+b-1, S+c-1));
			}
		}
	}// main

	private static void update(int idx, int val) {
		long minus = tree[idx];
		int P = idx;
		while (P!=0) {
			tree[P] = tree[P] - minus + val;
			P /= 2;
		}
	}//update

	private static long sum(int b, int c) {
		long sum = 0l;
		
		while (b < c) {
			//시작이 홀수 인가?
			if((b & 1) == 1) {
				sum += tree[b];
				b++;
			}
			//끝이 짝수인가?
			if((c & 1) == 0) {
				sum += tree[c];
				c++;
			}
			
			b /= 2;
			c /= 2;
			
		}//while
		
		if(b ==c) sum += tree[b];
		
		return sum;
	}//sum

}// Temp
