package BarkingDog.YouTube_28_Floyd;

import java.util.*;
import java.io.*;
// 서강 그라운드 골드4
public class BJ14938 {
    static final int MAX = 999999;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]); // 지역의 개수
        int m = Integer.parseInt(split[1]); // 수색 범위
        int r = Integer.parseInt(split[2]); // 길의 개수
        int [][] map = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j){
                    map[i][j] = 0;
                    continue;
                }
                map[i][j] = MAX;
            }
        }
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int [] item = new int[n+1];
        for (int i = 1; i <= n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }
        while (r-->0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end   = Integer.parseInt(st.nextToken());
            int cost  = Integer.parseInt(st.nextToken());
            map[start][end] = Math.min(map[start][end], cost);
            map[end][start] = Math.min(map[end][start], cost);
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n ; i++) {
                for (int j = 1; j <= n; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int temp = 0;
            for (int j = 1; j <= n; j++) {
                if(map[i][j] <= m){
                    temp += item[j];
                }
            }
            max = Math.max(max, temp);
        }
        System.out.println(max);
    }
}
/*
1. 플로이드 알고리즘으로 모든 최단 경로 map을 구한다.
2. 거리가 수색 경로보다 작거나 같으면 아이템을 더한다.
 */