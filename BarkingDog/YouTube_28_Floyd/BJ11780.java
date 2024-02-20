package org.example.BarkingDog.YouTube_28_Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 플로이드 2 골드2
public class BJ11780 {
    static final int max = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int m = Integer.parseInt(br.readLine()); // 버스의 개수
        int [][] map = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j){
                    map[i][j] = 0;
                    continue;
                }
                map[i][j] = max;
            }
        }
        int [][] nx = new int[n+1][n+1];
        StringTokenizer st;
        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end   = Integer.parseInt(st.nextToken());
            int cost  = Integer.parseInt(st.nextToken());
            if(map[start][end] > cost){
                map[start][end] = cost;
                nx[start][end] = end;
            }
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(map[i][j] > map[i][k] + map[k][j]){
                        map[i][j] = map[i][k] + map[k][j];
                        nx[i][j] = nx[i][k];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(map[i][j] == max){
                    map[i][j] = 0;
                }
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int start = i;
                int end   = j;
                boolean flag = false;
                while (start != end){
                    q.add(start);
                    start = nx[start][end];
                    if(start == 0){
                        sb.append(0).append("\n");
                        q.clear();
                        flag = true;
                        break;
                    }
                    if(start == end){
                        q.add(end);
                    }
                }
                if(flag) continue;
                sb.append(q.size()).append(" ");
                while (!q.isEmpty()){
                    sb.append(q.poll()).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
