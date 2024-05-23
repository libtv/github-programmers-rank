package BarkingDog.YouTube_29_Dijkstra;

import java.util.*;
import java.io.*;
// 최단경로 골드4
public class BJ1753 {
    static final int INF = 300000 * 10 + 1;

    static class node {
        int vertex, cost;  // 정점, 가중치

        public node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());    // 정점의 개수 v
        int e = Integer.parseInt(st.nextToken());    // 간선의 개수 e
        int start = Integer.parseInt(br.readLine()); // 시작 정점
        ArrayList<node>[] graph = new ArrayList[v + 1];
        for (int i = 0; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }
        while (e-- > 0) { // u v w
            st = new StringTokenizer(br.readLine());
            graph[Integer.parseInt(st.nextToken())].add(new node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int[] min = new int[v + 1];
        Arrays.fill(min, INF);
        min[start] = 0;
        PriorityQueue<node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new node(start, 0));
        while (!pq.isEmpty()) {
            node node = pq.poll();
            if (min[node.vertex] != node.cost) continue;
            for (node next : graph[node.vertex]) {
                if (min[next.vertex] <= min[node.vertex] + next.cost) continue;
                min[next.vertex] = min[node.vertex] + next.cost;
                pq.add(new node(next.vertex, min[next.vertex]));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            if (min[i] == INF) {
                sb.append("INF").append("\n");
                continue;
            }
            sb.append(min[i]).append("\n");
        }
        System.out.println(sb);
    }
}
/*
방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성하시오.
단, 모든 간선의 가중치는 10 이하의 자연수이다.
첫째 줄에 정점의 개수 V와 간선의 개수 E가 주어진다.
(1 ≤ V ≤ 20,000, 1 ≤ E ≤ 300,000) 모든 정점에는 1부터 V까지 번호가 매겨져 있다고 가정한다.
둘째 줄에는 시작 정점의 번호 K(1 ≤ K ≤ V)가 주어진다.
셋째 줄부터 E개의 줄에 걸쳐 각 간선을 나타내는 세 개의 정수 (u, v, w)가 순서대로 주어진다.
이는 u에서 v로 가는 가중치 w인 간선이 존재한다는 뜻이다. u와 v는 서로 다르며 w는 10 이하의 자연수이다.
서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있음에 유의한다.
 */