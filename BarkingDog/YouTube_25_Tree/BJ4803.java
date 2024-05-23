package BarkingDog.YouTube_25_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 트리 골드4
public class BJ4803 {
    static ArrayList<Integer>[] graph;
    static int[] depth;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0; // case count
        StringBuilder sb = new StringBuilder();
        while (true){
            String[] split = br.readLine().split(" ");
            cnt++;
            int n = Integer.parseInt(split[0]);
            int m = Integer.parseInt(split[1]);
            if(n == 0 && m == 0){
                break;
            }
            graph = new ArrayList[n+1];
            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            while (m-->0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }
            for (int i = 0; i <= n; i++) {
                Collections.sort(graph[i]);
            }
            depth = new int[n+1];
            int count = 0;  // 그래프에서 트리 개수

            for (int i = 1; i <= n; i++) {
                 if(depth[i] == 0){
                     int check1 = 0;  // 간선의 개수
                     depth[i] = 1;
                     Set<Integer> set = new HashSet<>();
                     set.add(i);
                     Queue<Integer> q = new LinkedList<>();
                     q.add(i);
                     while (!q.isEmpty()){
                        int cur = q.poll();
                        int size = graph[cur].size();
                        check1 += size;
                        for (int j = 0; j < size; j++) {
                            int next = graph[cur].get(j);
                            if(depth[next] == 0){
                                depth[next] = depth[cur] + 1;
                                set.add(next);
                                q.add(next);
                            }
                        }
                    }
                    if(check1/2 == set.size()-1){
                        count++;
                    }
                 }
            }
            sb.append("Case").append(" ").append(cnt).append(":").append(" ");
            if(count == 0){
                sb.append("No trees.");
            }
            else if(count == 1){
                sb.append("There is one tree.");
            }
            else{
                sb.append("A forest of ").append(count).append(" trees.");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
/*

트리는 사이클이 없는 연결 요소이다. 트리에는 여러 성질이 있다. 예를 들어, 트리는 정점이 n개, 간선이 n-1개 있다. 또, 임의의 두 정점에 대해서 경로가 유일하다.
그래프가 주어졌을 때, 트리의 개수를 세는 프로그램을 작성하시오.

 */

/*
 1    depth = 0
  2   depth = 1
   3  depth = 2
 */