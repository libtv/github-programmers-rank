package org.example.BarkingDog.YouTube_26_TopologicalSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// ACM Craft 골드3
public class BJ1005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        StringBuilder sb = new StringBuilder();
        while (t-->0){
            String [] split = br.readLine().split(" ");
            int n = Integer.parseInt(split[0]); // 건물의 개수 n
            int k = Integer.parseInt(split[1]); // 건설순서 규칙 k
            int [] times = new int[n+1];
            StringTokenizer st;
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                times[i] = Integer.parseInt(st.nextToken());
            }
            ArrayList<Integer>[] graph = new ArrayList[n+1];
            int [] InDegree = new int[n+1];
            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            while (k-->0){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                InDegree[b]++;
                graph[a].add(b);
            }
            int target = Integer.parseInt(br.readLine());
            int [] max_time = new int[n+1];
            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if(InDegree[i] == 0){
                    q.add(i);
                }
            }
            while (!q.isEmpty()){
                int cur = q.poll();
                if(cur == target){
                    sb.append(max_time[cur] + times[cur]).append("\n");
                    break;
                }
                for (int next: graph[cur]) {
                    InDegree[next]--;
                    max_time[next] = Math.max(max_time[next], max_time[cur] + times[cur]);
                    if(InDegree[next] == 0) q.add(next);
                }
            }
        }
        System.out.println(sb);
    }
}
