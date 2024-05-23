package BarkingDog.YouTube_29_Dijkstra;

import java.io.*; import java.util.*;
// 파티 골드3
public class BJ1238 {
    static final int INF = 10000 * 100 + 1;
    static class node{
        int v, cost;
        public node(int v, int cost){
            this.v = v; this.cost = cost;
        }
    }
    static ArrayList<node>[] graph;
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());  // n명의 학생
        int m = Integer.parseInt(st.nextToken());  // m개의 단방향 도로
        int x = Integer.parseInt(st.nextToken());  // 모이는 마을
        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        while (m-->0){ // 단방향
            st = new StringTokenizer(br.readLine());
            graph[Integer.parseInt(st.nextToken())].add(new node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if(i == x) continue;
            max = Math.max(max, (dijkstra(i, x) + dijkstra(x, i)));
        }
        System.out.println(max);

    }
    public static int dijkstra(int start, int end){
        int [] D = new int[n+1];
        Arrays.fill(D, INF);
        D[start] = 0;
        PriorityQueue<node> pq = new PriorityQueue<>((o1, o2)->o1.cost-o2.cost);
        pq.add(new node(start,0));
        while (!pq.isEmpty()){
            node node = pq.poll();
            if(D[node.v] != node.cost) continue;
            for (node next :graph[node.v]) {
                if(D[next.v] <= next.cost + D[node.v]) continue;
                D[next.v] = next.cost + D[node.v];
                pq.add(new node(next.v, D[next.v]));
            }
        }
        return D[end];
    }
}
/*
N개의 숫자로 구분된 각각의 마을에 한 명의 학생이 살고 있다.
모든 학생들은 집에서 X에 갈수 있고, X에서 집으로 돌아올 수 있는 데이터만 입력으로 주어진다.

플로이드로도 충분히 시간 복잡도 통과 가능하지만 PASS

 */