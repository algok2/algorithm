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
public class DFS_recursion {
	static int T, N, M;
	static ArrayList<Integer>[] nodeArr;
	static boolean visited[];
	static Stack<Integer> t;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine().trim());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			nodeArr = new ArrayList[N + 1];
			visited = new boolean[N + 1];
			for (int i = 1; i <= N; i++) {
				nodeArr[i] = new ArrayList<Integer>();
			} // 배열 초기화

			for (int i = 1; i <= M; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				nodeArr[a].add(b);
				nodeArr[b].add(a);

			} // 입력
//			printList();
			t = new Stack<Integer>();

			Arrays.fill(visited, false);
			visited[1] = true;
			t.push(1);
			DFS(1);

		} // test case

	}// main

	private static void DFS(int i) {
		if (t.isEmpty()) {
			action(i);
			return;
		}
		action(i);
		for (int j = 0; j < nodeArr[i].size(); j++) {
			if (visited[nodeArr[i].get(j)] == false) {
				visited[nodeArr[i].get(j)] = true;
				DFS(nodeArr[i].get(j));
			}
		}
		/*
		 * for (int j = 0; j < nodeArr[i].size(); j++) { if (visited[nodeArr[i].get(j)]
		 * == false) { visited[nodeArr[i].get(j)] = true; t.push(nodeArr[i].get(j));
		 * DFS(t.pop()); } }
		 */
	}

	private static void action(int i) {
		System.out.println(i);

	}

	private static void printList() {
		for (int i = 1; i <= N; i++) {
			System.out.print("node[" + i + "] = ");
			for (int j = 0; j < nodeArr[i].size(); j++) {
				System.out.print(nodeArr[i].get(j) + " ");
			}
			System.out.println();
		} // 배열 초기화

	}// print

}// DFS
