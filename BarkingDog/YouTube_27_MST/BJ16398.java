package org.example.BarkingDog.YouTube_27_MST;

import java.io.*;
import java.util.*;
// 행성 연결 골드4
public class BJ16398 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<empire>[] graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = 1;
            while (cnt <= n){
                long cost = Long.parseLong(st.nextToken());
                if(cost == 0){
                    cnt++;
                    continue;
                }
                graph[i].add(new empire(cnt, cost));
                graph[cnt].add(new empire(i, cost));
                cnt++;
            }
        }
        boolean [] check = new boolean[n+1];
        check[1] = true;
        PriorityQueue<empire> pq = new PriorityQueue<>((o1, o2)-> (int)(o1.cost - o2.cost));
        for (empire next: graph[1]) {
            pq.add(new empire(next.end, next.cost));
        }
        int cnt = 0;
        long cost = 0;
        while (cnt < n - 1){
            empire empire = pq.poll();
            if(check[empire.end]) continue;
            check[empire.end] = true;
            cost += empire.cost;
            cnt ++;
            for (empire next: graph[empire.end]) {
                if(!check[next.end]){
                    pq.add(new empire(next.end, next.cost));
                }
            }
        }
        System.out.println(cost);
    }
}
class empire{
    int end;
    long cost;
    public empire(int end, long cost){
        this.end = end;
        this.cost = cost;
    }
}
/*
홍익 제국의 중심은 행성 T이다. 제국의 황제 윤석이는 행성 T에서 제국을 효과적으로 통치하기 위해서, N개의 행성 간에 플로우를 설치하려고 한다.
두 행성 간에 플로우를 설치하면 제국의 함선과 무역선들은 한 행성에서 다른 행성으로 무시할 수 있을 만큼 짧은 시간만에 이동할 수 있다. 하지만, 치안을 유지하기 위해서 플로우 내에 제국군을 주둔시켜야 한다.
 제국의 모든 행성을 연결하면서 플로우 관리 비용을 최소한으로 하려 한다.

 */