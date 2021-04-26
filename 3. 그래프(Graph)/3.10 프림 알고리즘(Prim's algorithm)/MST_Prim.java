Description:import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
// MST : 프림 알고리즘
// 백준 [1197번] 최소 스패닝 트리
// https://www.acmicpc.net/problem/1197
public class MST_Prim {
    private static class Node implements Comparable {
        int dest;
        int cost;
        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
  @Override
  public int compareTo(Node o) {
   return Integer.compare(this.cost, o.cost);
  }
    }
    private static ArrayList[] adjList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new 
InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); // 정점 수
        int E = Integer.parseInt(st.nextToken()); // 간선의 수
        adjList = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adjList[start].add(new Node(end, cost));
            // 양방향 간선으로 만들어준다.
            adjList[end].add(new Node(start, cost));
        }
        // 1번 정점에서 MST 만들기 시작
        System.out.println(prim(1, V));
    }
    // MST : 프림(Prim) 알고리즘
    // 시작 정점
    // 정점의 개수 V
    private static int prim(int start, int V) {
        // 가중치 기준 오름차순
        PriorityQueue pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V + 1];
        pq.offer(new Node(start, 0));
        int mst_cost = 0; // 간선 가중치 합의 최소 비용을 저장
        int selected = 0; // 사용된 정점의 수
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            // 방문한 정점이면 Skip
            if (visited[now.dest])
                continue;
            // 방문 체크
            visited[now.dest] = true;
            mst_cost += now.cost;
            selected++;
            //종료조건
            if (selected == V)  // 모든 정점이 연결됨
                return mst_cost;
            for (Node next : adjList[now.dest]) {
                if (!visited[next.dest]) {
                    pq.offer(next);
                }
            }
        }
       
        return -1;
    }
}
