package org.example.BarkingDog.YouTube_29_Dijkstra;

import java.io.*; import java.util.*;
// 골목 대장 호석 - 효율성 2
public class BJ20183 {
    static final long INF = ((long)1000000000 * 500000) + 1;
    static ArrayList<Edge>[] graph;
    static class Edge{
        int v; long cost;
        public Edge(int v, long cost){
            this.v = v; this.cost = cost;
        }
    }
    static class Node{
        int v; long max_cost; long cost;
        public Node(int v, long max_cost, long cost){
            this.v = v;
            this.max_cost = max_cost;
            this.cost = cost;
        }
    }
    static boolean [] visited;
    static long min = INF;
    static int n; static int a; static int b; static long c;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 교차로 개수 n
        int m = Integer.parseInt(st.nextToken()); // 골목 개수 m
        a = Integer.parseInt(st.nextToken()); // 시작 교차로 a
        b = Integer.parseInt(st.nextToken()); // 도착 교차로 b
        c = Long.parseLong(st.nextToken()); // 가진 돈 c
        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());
            graph[s].add(new Edge(e, cost)); // 양방향
            graph[e].add(new Edge(s, cost));
        }
        // 최단 경로 구하기 만약 c가 최단 경로값보다 작으면 -1 출력
        long [] D = new long[n+1];
        Arrays.fill(D, INF);
        D[a] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2)-> (int)(o1.cost - o2.cost));
        pq.add(new Edge(a, 0));
        while (!pq.isEmpty()){
            Edge edge = pq.poll();
            if(D[edge.v] != edge.cost) continue;
            for (Edge next: graph[edge.v]) {
                if(D[next.v] <= D[edge.v] + next.cost) continue;
                D[next.v] = D[edge.v] + next.cost;
                pq.add(new Edge(next.v, D[next.v]));
            }
        }
        if(D[b] > c){
            System.out.println(-1);
            return;
        }
        long [] memo = new long[n+1];
        PriorityQueue<Node> pq2 = new PriorityQueue<>((o1, o2)-> (int)(o1.cost - o2.cost));
        pq2.add(new Node(a, 0, 0));
        Arrays.fill(memo, INF);
        memo[a] = 0;
        while (!pq2.isEmpty()){
            Node node = pq2.poll();
            if(memo[node.v] < node.max_cost) continue;
            for (Edge next :graph[node.v]) {
                if(memo[next.v] <= Math.max(node.max_cost, next.cost) || next.cost + node.cost > c) continue;
                memo[next.v] = Math.max(node.max_cost, next.cost);
                pq2.add(new Node(next.v, memo[next.v], next.cost + node.cost));
            }
        }
        System.out.println(memo[b]);
    }
}
/*
소싯적 호석이는 골목 대장의 삶을 살았다.
호석이가 살던 마을은 N 개의 교차로와 M 개의 골목이 있었다.
교차로의 번호는 1번부터 N 번까지로 표현한다.
골목은 서로 다른 두 교차로를 양방향으로 이어주며 임의의 두 교차로를 잇는 골목은 최대 한 개만 존재한다.
분신술을 쓰는 호석이는 모든 골목에 자신의 분신을 두었고, 골목마다 통과하는 사람에게 수금할 것이다. 수금하는 요금은 골목마다 다를 수 있다.
당신은 A 번 교차로에서 B 번 교차로까지 C 원을 가지고 가려고 한다.
호석이의 횡포를 보며 짜증은 나지만, 분신술을 이겨낼 방법이 없어서 돈을 내고 가려고 한다.
하지만 이왕 지나갈 거면, 최소한의 수치심을 받고 싶다.
당신이 받는 수치심은 경로 상에서 가장 많이 낸 돈에 비례하기 때문에,
결국 갈 수 있는 다양한 방법들 중에서 최소한의 수치심을 받으려고 한다.
즉, 한 골목에서 내야 하는 최대 요금을 최소화하는 것이다.
 */
