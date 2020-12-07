package G_TopologySort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

//https://m.blog.naver.com/PostView.nhn?blogId=ndb796&logNo=221236874984&referrerCode=0&searchKeyword=%EC%9C%84%EC%83%81%EC%A0%95%EB%A0%AC
public class TopologySort {
	static int n;
	static int[] inDegree;
	static ArrayList<Integer>[] arrList;
	static Deque<Integer> q;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		n = 7;
		
		inDegree = new int[n+1];
		arrList = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			arrList[i] = new ArrayList<Integer>();
		}
		
		arrList[1].add(2);
		inDegree[2]++;
		arrList[1].add(5);
		inDegree[5]++;
		arrList[2].add(3);
		inDegree[3]++;
		arrList[3].add(4);
		inDegree[4]++;
		arrList[4].add(6);
		inDegree[6]++;
		arrList[5].add(6);
		inDegree[6]++;
		arrList[6].add(7);
		inDegree[7]++;
		
		topologySort();
		

	}//main

	private static void topologySort() {
		int[] result;
		result = new int[n+1];
		
		q = new ArrayDeque<Integer>();
		
		for (int i = 1; i <= n; i++) {
			if (inDegree[i] == 0) { 
				q.add(i);
			}
		}
		
		for (int i = 1; i <= n; i++) {
			if (q.isEmpty()) {
				System.out.println("사이클이 발생 했습니다.");
				return;
			}
			
			int x = q.poll(); //탐색  결과 저장
			result[i] = x; //탐색  결과 저장
			
			for (int index = 0; index < arrList[x].size(); index++) {
				int y = arrList[x].get(index);
				if (--inDegree[y] == 0) {
					q.add(y);
				};
			}
		}
		
		System.out.print("result : ");
		for (int i = 1; i <= n; i++) {
			System.out.print(result[i]+" ");
		}
		
	}//topologySort
	
	

}//Topology Sort
