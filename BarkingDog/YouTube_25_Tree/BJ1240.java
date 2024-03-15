package BarkingDog.YouTube_25_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 노드사이의 거리 골드5
public class BJ1240 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]); // 노드의 개수
        int m = Integer.parseInt(split[1]); // 거리를 알고 싶은 노드 쌍의 개수
        ArrayList<Integer>[] list = new ArrayList[n+1]; // 그래프
        int [][] memo = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) { // 트리에서의 간선의 개수는 노드의 개수 - 1
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken()); // 거리
            list[a].add(b);
            list[b].add(a);
            memo[a][b] = len;
            memo[b][a] = len;
        }
        StringBuilder sb = new StringBuilder();
        while (m-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == b){
                sb.append(0).append("\n");
                continue;
            }
            int [] visited = new int[n+1];
            int sum = 0;
            Queue<Integer> q = new LinkedList<>();
            q.add(a);
            while (!q.isEmpty()){
                int cur = q.poll();
                for (int next : list[cur]) {
                    if(next == b){
                        sum = visited[cur] + memo[cur][b];
                        q.clear();
                        break;
                    }
                    else if(visited[next] == 0 && next!=a){
                        visited[next] = visited[cur] + memo[cur][next];
                        q.add(next);
                    }
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
/*
N 개의 노드로 이루어진 트리가 주어지고 M개의 두 노드 쌍을 입력받을 때 두 노드 사이의 거리를 출력하라.

 */