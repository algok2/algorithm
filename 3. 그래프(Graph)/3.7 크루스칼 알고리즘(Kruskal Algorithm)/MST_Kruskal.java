import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
public class MST_Kruskal {
    private static class LanCable implements Comparable {
        int start;
        int end;
        int cost;
        public LanCable(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
  @Override
  public int compareTo(LanCable o) {
   return Integer.compare(this.cost, o.cost);
  }
    }
    private static final LanCable[] lanCables = new LanCable[8];
    private static int[] parent = new int[5];
    public static void main(String[] args) {
        // 초기화
        parent = new int[6];
        for (int i = 1; i <= 5; i++) {
            parent[i] = i;
        }
        // start 컴퓨터와 end 컴퓨터를 연결하는 랜케이블
        // 모든 컴퓨터가 연결되도록 랜선을 연결했을때
        // 최소 비용 구하기
        lanCables[0] = new LanCable(1, 2, 10); // 선택
        lanCables[1] = new LanCable(1, 2, 20);
        lanCables[2] = new LanCable(3, 2, 40);
        lanCables[3] = new LanCable(1, 4, 15);
        lanCables[4] = new LanCable(2, 4, 10); // 선택
        lanCables[5] = new LanCable(1, 4, 5);  // 선택
        lanCables[6] = new LanCable(1, 3, 20); // 선택
        lanCables[7] = new LanCable(1, 5, 100); // 선택
        // V : 정점의 수 / E : 간선의 수
        System.out.println(kruskal(5, 8));
    }
    // 정점의 개수 V
    // 간선의 개수 E
    private static int kruskal(int V, int E) {
        int mst_cost = 0; // MST 일때 총 비용
        int selected = 0; // 연결된 간선의 수
        Arrays.sort(lanCables);
        for(int i = 0; i < E; i++) {
            // 서로 다른 트리일 때만 연결
            // A 컴퓨터에서 B 컴퓨터가 연결되어 있니?
            if(find(lanCables[i].start)!=find(lanCables[i].end)) {
                // 총 cost += 연결비용
                mst_cost += lanCables[i].cost;
                // 간선을 하나 선택함
                selected++;
                // A와 B는 연결되었음!
                union(lanCables[i].start, lanCables[i].end);
            }
        }
        // 연결된 간선의 수 = 정점의 수 - 1 이면 모든 정점이 연결됨
        if(selected == V-1)
            return mst_cost;
        else
            return -1; // 연결 불가능한 정점이 있음
    }
    // 아래는 Union-Find
    private static void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        if(x!=y) {
         parent[x]=y;
        }
    }
    private static int find(int a) {
        if (parent[a] == a)
            return a;
        return parent[a] = find(parent[a]);
    }
}
