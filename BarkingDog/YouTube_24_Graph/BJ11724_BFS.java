package BarkingDog.YouTube_24_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 연결 요소의 개수 실버2
public class BJ11724_BFS {
    static boolean[] visited;
    static  ArrayList<ArrayList<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]); // 정점의 개수
        int m = Integer.parseInt(split[1]); // 간선의 개수
        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        while (m-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.get(start).add(end);
            list.get(end).add(start); // 무방향 그래프
        }
        visited = new boolean[n+1];
        int ans = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if(!visited[i]){
                ans++;
                q.add(i);
                visited[i] = true;
                while (!q.isEmpty()){
                    int x = q.poll();
                    int size = list.get(x).size();
                    for (int j = 0; j < size; j++) {
                        int next = list.get(x).get(j);
                        if(!visited[next]){
                            visited[next] = true;
                            q.offer(next);
                        }
                    }

                }
            }
        }
        System.out.println(ans);
    }
}
/*
방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다.
둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.
 */