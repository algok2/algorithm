import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
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
public class BFS_queue {
	static int T, N, M;
	static ArrayList<Integer>[] adjList;
	static Queue<Integer> q;
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
			adjList = new ArrayList[N+1];
			for (int i = 1; i <= N; i++) {
				adjList[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adjList[a].add(b);
//				adjList[b].add(a);
				
			}// ют╥б
			bfs(1);
		} // test case
	}// main

	private static void bfs(int a) {
		q = new ArrayDeque<Integer>();
		q.offer(a);
		visited[a] = true;
		while (!q.isEmpty()) {
			int temp = q.poll();
			action(temp);;
			for (int next: adjList[temp]) {
				if (visited[next] == false) {
					q.offer(next);
					visited[next] = true;
				}
			}
		}
		
	}//bfs

	private static void action(int curr) {
		System.out.print(curr+" ");
		
	}//action

}// Solution