import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BfsExample {
	static int number;
	static boolean visit[];
	static ArrayList<Integer>[] Node;
	
	

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{
		number = 7;
		visit = new boolean[number+1];
		Node  = new ArrayList[number+1];
		for (int i = 1; i <= number; i++) {
			Node[i] = new ArrayList<Integer>();
		}
		
		Node[1].add(2);
		Node[2].add(1);
		
		Node[1].add(3);
		Node[3].add(1);
		
		Node[2].add(4);
		Node[4].add(2);
		
		Node[2].add(5);
		Node[5].add(2);
		
		Node[3].add(6);
		Node[6].add(3);
		
		Node[3].add(7);
		Node[7].add(3);
		
		bfs(1);

	}//main


	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		visit[start] = true;
		
		while (!q.isEmpty()) {
			int x = q.poll();
			System.out.print(x+" ");
			for (int i = 0; i < Node[x].size(); i++) {
				int y = Node[x].get(i);
				if (!visit[y]) {
					q.add(y);
					visit[y] = true;
				}
			}
		}
	}//bfs
}//BfsExam
