package boj.BarkingDog_Collection.Floyd;

/**
 * 플로이드 2 골드2
 * Floyd + 경로 복원
 */
import java.util.*;
import java.io.*;
public class BOJ11780_2 {
    static final int INF = 99 * 100000; // 최대 비용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int m = Integer.parseInt(br.readLine()); // 버스의 개수

        int [][] map = new int[n+1][n+1];
        int [][] next = new int[n+1][n+1]; // 경로 복원용

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j){
                    map[i][j] = 0;
                    continue;
                }
                map[i][j] = INF;
            }
        }
        StringTokenizer st;
        // 간선 정보
        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if(map[v1][v2] > cost){
                map[v1][v2] = cost;
                next[v1][v2] = v2;
            }
        }


        // 플로이드 알고리즘
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(map[i][j] > map[i][k] + map[k][j]){
                        map[i][j] = map[i][k] + map[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        // 비용
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(map[i][j] == INF) map[i][j] = 0;
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        // 비용에 포함되어 있는 도시의 개수 k
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(map[i][j] == 0){
                    sb.append(0).append("\n");
                    continue;
                }
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                int cur = i;
                while (cur != j){
                    cur = next[cur][j];
                    q.add(cur);
                }
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
