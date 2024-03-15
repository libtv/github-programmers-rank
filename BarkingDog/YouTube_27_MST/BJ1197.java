package BarkingDog.YouTube_27_MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 최소 스패닝 트리 골드4
public class BJ1197 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] split = br.readLine().split(" ");
        int v = Integer.parseInt(split[0]); // 정점의 개수
        int e = Integer.parseInt(split[1]); // 간선의 개수
        StringTokenizer st;
        ArrayList<MST>[] graph = new ArrayList[v+1]; // 그래프
        for (int i = 0; i <= v; i++) { // 그래프 초기화
            graph[i] = new ArrayList<>();
        }
        // a b c 정점 a와 정점 b가 가중치 c인 간선으로 연결을 의미
        while (e-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new MST(b, c));
            graph[b].add(new MST(a, c));
        }
        boolean [] check = new boolean[v+1];
        PriorityQueue<MST2> pq = new PriorityQueue<>();
        check[1] = true;
        int ans = 0; // 모든 간선 가중치
        int cnt = 0;
        for (MST mst : graph[1]) {
            pq.add(new MST2(1, mst.v, mst.cost));
        }
        while (cnt < v - 1){
            MST2 temp = pq.poll();
            if(check[temp.end]) continue;
            ans += temp.cost;
            check[temp.end] = true;
            cnt++;
            for (MST mst :graph[temp.end]) {
                if(!check[mst.v])
                pq.add(new MST2(temp.start, mst.v, mst.cost));
            }
        }
        System.out.println(ans);
    }
}
class MST {
    int v, cost;
    public MST(int v, int cost){
        this.v = v;
        this.cost = cost;
    }
}

class MST2 implements Comparable<MST2>{
    int start, end, cost;
    public MST2(int start, int end, int cost){
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
    public int compareTo(MST2 o){
        return this.cost - o.cost;
    }
}


/*
최소 스패닝 트리는, 주어진 그래프의 모든 정점들을 연결하는 부분 그래프 중에서 그 가중치의 합이 최소인 트리를 말한다.


 */