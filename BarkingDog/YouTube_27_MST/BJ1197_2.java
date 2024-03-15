package BarkingDog.YouTube_27_MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 최소 스패닝 트리 골드4
public class BJ1197_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] split = br.readLine().split(" ");
        int v = Integer.parseInt(split[0]); // 정점의 개수
        int e = Integer.parseInt(split[1]); // 간선의 개수
        ArrayList<Node>[] graph = new ArrayList[v+1];
        for (int i = 0; i <= v ; i++) {
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st;
        while (e-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(a, b, c));
            graph[b].add(new Node(b, a, c));
        }
        boolean [] check = new boolean[v+1];
        check[1] = true;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (o1.cost - o2.cost));
        for (Node next : graph[1]) {
             pq.add( new Node(1, next.end, next.cost));
        }
        int cnt = 0;
        int ans = 0;
        while (cnt < v - 1){
            Node node = pq.poll();
            if(check[node.end]) continue;
            check[node.end] = true;
            ans += node.cost;
            cnt++;
            for (Node next : graph[node.end]) {
                if(!check[next.end]){
                    pq.add(new Node(node.end, next.end, next.cost));
                }
            }
        }
        System.out.println(ans);
    }
}
class Node {
    int start, end, cost;
    public Node(int start, int end, int cost){
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}