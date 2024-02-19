package org.example.BarkingDog.YouTube_27_MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 물대기 골드2
public class BJ1368 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 논의 수
        n++; // 가상의 정점을 하나 추가한다. (자신의 논)
        boolean [] check = new boolean[n+1];
        ArrayList<water>[] graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n - 1; i++) {
            int cost = Integer.parseInt(br.readLine());
            graph[i].add(new water(i, n, cost));
            graph[n].add(new water(n, i, cost));
        }
        StringTokenizer st;
        for (int i = 1; i <= n - 1 ; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = 1;
            while (cnt <= n - 1){
                int cost = Integer.parseInt(st.nextToken());
                if(cost == 0){
                    cnt ++;
                    continue;
                }
                graph[cnt].add(new water(cnt, i, cost));
                graph[i].add(new water(i, cnt, cost));
                cnt++;

            }
        }
        PriorityQueue<water> pq = new PriorityQueue<>((o1, o2)-> o1.cost - o2.cost);
        check[1] = true;
        for (water next: graph[1]) {
            pq.add(new water(1, next.end, next.cost));
        }
        int ans = 0;
        int cnt = 0;
        while (cnt < n - 1){
            water water = pq.poll();
            if(check[water.end]) continue;
            check[water.end] = true;
            cnt++;
            ans += water.cost;
            for ( water next : graph[water.end]) {
                if(!check[next.end]){
                    pq.add(new water(water.end, next.end, next.cost));
                }
            }
        }
        System.out.println(ans);
    }
}
class water{
    int start, end, cost;
    public water(int start, int end, int cost){
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}


/*
선주는 자신이 운영하는 N개의 논에 물을 대려고 한다.
물을 대는 방법은 두 가지가 있는데 하나는 직접 논에 우물을 파는 것이고 다른 하나는 이미 물을 대고 있는 다른 논으로부터 물을 끌어오는 법이다.
각각의 논에 대해 우물을 파는 비용과 논들 사이에 물을 끌어오는 비용들이 주어졌을 때 최소의 비용으로 모든 논에 물을 대는 것이 문제이다.
 */

/*
그래프 리모델링을 통해서 자신의 논에 물을 넣는 것을 새로운 정점으로 만들어준다.
그 이후 프림 알고리즘을 통한 최소 신장 트리로 cost를 더한다.
전에 풀었던 하이퍼튜브 또한 그래프 리모델링의 종류
 */