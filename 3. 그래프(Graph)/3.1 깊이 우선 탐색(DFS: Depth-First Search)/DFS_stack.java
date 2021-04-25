import java.awt.Desktop.Action;
import java.awt.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/*
1
7 8
1 2
1 3
2 4
5 2
5 3
5 7
4 7
6 7

*/
public class DFS_stack {
	static int T, N, M;
	static ArrayList<Integer>[] nodeArr;
	static Stack<Integer> stack;
	static boolean[] visited;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine().trim());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			visited = new boolean[N+1];
			Arrays.fill(visited, false);
			nodeArr = new ArrayList[N+1];
			for (int i = 1; i <= N; i++) {
				nodeArr[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				nodeArr[a].add(b);
				nodeArr[b].add(a);
				
			}// ют╥б
			dfs(1);
		} // test case
	}// main

	private static void dfs(int i) {
		stack = new Stack<Integer>();
	
		stack.push(i);
		while (!stack.isEmpty()) {
			int curr = stack.pop();
			if (visited[curr]) continue;
			visited[curr] = true;
			action(curr);
			for (int j = 0; j < nodeArr[curr].size(); j++) {
				if (!visited[nodeArr[curr].get(j)]) {
					stack.push(nodeArr[curr].get(j));
				}
			}
		}
		
	}//dfs

	private static void action(int curr) {
		System.out.print(curr+" ");
		
	}//action

}// Solution
