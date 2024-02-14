package org.example.BarkingDog.YouTube_24_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 환승 골드2
public class BJ5214 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken()); // 역의 수 n
        int k = Integer.parseInt(st1.nextToken()); // 서로 연결하는 역의 개수 k
        int m = Integer.parseInt(st1.nextToken()); // 하이퍼튜브의 개수 m
        ArrayList<Integer>[] list = new ArrayList[n+m+1];
        for (int i = 0; i <= n+m ; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = n+1; i <= n + m ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k ; j++) {
                int temp = Integer.parseInt(st.nextToken());
                list[temp].add(i);
                list[i].add(temp);
            }
        }
        boolean [] visited = new boolean[n+m+1];
        visited[1] = true;
        Queue<Move> q = new LinkedList<>();
        q.add(new Move(1, 1));
        int ans = 0;
        while (!q.isEmpty()){
            Move move = q.poll();
            int cur = move.station;
            int depth = move.depth;
            if(cur == n){
                ans = depth;
            }
            int size = list[cur].size();
            for (int i = 0; i < size; i++) {
                int next = list[cur].get(i);
                if(!visited[next]){
                    visited[next] = true;
                    if(next < n + 1)  q.add(new Move(next, depth + 1));
                    else q.add(new Move(next, depth));
                }
            }
        }
        if(n == 1){
            System.out.println(1);
        }
        else if(ans == 0){
            System.out.println(-1);
        }
        else{
            System.out.println(ans);
        }
    }
}
class Move{
    int station;
    int depth;
    public Move(int station, int depth){
        this.station = station;
        this.depth = depth;
    }
}

/*
아주 먼 미래에 사람들이 가장 많이 사용하는 대중교통은 하이퍼튜브이다.
하이퍼튜브 하나는 역 K개를 서로 연결한다. 1번역에서 N번역으로 가는데 방문하는 최소 역의 수는 몇 개일까?

첫째 줄에 1번역에서 N번역으로 가는데 방문하는 역의 개수의 최솟값을 출력한다. 만약, 갈 수 없다면 -1을 출력한다.

 */