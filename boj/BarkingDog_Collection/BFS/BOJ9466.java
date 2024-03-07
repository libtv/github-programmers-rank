package org.example.boj.BarkingDog_Collection.BFS;

// 텀 프로젝트 골드3
import java.io.*;
import java.util.*;
public class BOJ9466 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (t-->0){
            int n = Integer.parseInt(br.readLine());
            int[] list = new int[n+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }
            boolean [] visited = new boolean[n+1];
            Queue<Integer> q = new LinkedList<>();
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if(visited[i]) continue;
                visited[i] = true;
                q.add(i);
                HashMap<Integer, Integer> map = new HashMap<>();
                int cnt = 1;
                map.put(i, cnt);
                cnt++;
                while (!q.isEmpty()){
                    int cur = q.poll();
                    int next = list[cur];
                    if(map.containsKey(next)){
                        count += map.size() - map.get(next) + 1;
                        break;
                    }
                    else if(!visited[next]){
                        map.put(next, cnt);
                        cnt++;
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
            sb.append(n - count).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
