package org.example.BarkingDog.YouTube_24_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// DFS와 BFS 실버2
public class BJ1260 {
    static StringBuilder sb;
    static ArrayList<ArrayList<Integer>> list;
    static boolean [] visited;
    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점의 개수
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수
        int v = Integer.parseInt(st.nextToken()); // 시작 정점의 번호
        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        while (m-->0){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st2.nextToken());
            list.get(start).add(end);
            list.get(end).add(start); // 양방향
        }

        // 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고
        for (int i = 1; i <= n; i++) {
            Collections.sort(list.get(i));
        }
        visited = new boolean[n+1];
        DFS(v);
        // DFS 부터
        sb.append("\n");
        // BFS
        Arrays.fill(visited, false);
        visited[v] = true;
        sb.append(v).append(" ");
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        while (!q.isEmpty()){
            int x = q.poll();
            int size = list.get(x).size();
            for (int i = 0; i < size; i++) {
                int next = list.get(x).get(i);
                if(!visited[next]){
                    visited[next] = true;
                    sb.append(next).append(" ");
                    q.add(next);
                }
            }
        }
        System.out.println(sb);
    }
    public static void DFS(int x){
        visited[x] = true;
        sb.append(x).append(" ");
        int size = list.get(x).size();
        for (int i = 0; i < size ; i++) {
            int next = list.get(x).get(i);
            if(!visited[next]){
                DFS(next);
            }
        }
    }
}
/*
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다.
정점 번호는 1번부터 N번까지이다.

 */