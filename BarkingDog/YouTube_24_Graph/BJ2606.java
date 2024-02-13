package org.example.BarkingDog.YouTube_24_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 바이러스 실버3
public class BJ2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  // 컴퓨터의 수
        int m = Integer.parseInt(br.readLine());  // 간선
        boolean [] visited = new boolean[n+1];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <=n; i++) {
            list.add(new ArrayList<>());
        }
        while (m-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end   = Integer.parseInt(st.nextToken());
            list.get(start).add(end);
            list.get(end).add(start); // 양방향
        }
        visited[1] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()){
            int x = q.poll();
            int size = list.get(x).size();
            for (int i = 0; i < size; i++) {
                int next = list.get(x).get(i);
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            if(visited[i]){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
/*
어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다.
컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.
 */