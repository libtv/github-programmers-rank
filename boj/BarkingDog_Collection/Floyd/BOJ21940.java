package boj.BarkingDog_Collection.Floyd;

/**
 * 가운데에서 만나기 골드4
 * Floyd
 */
import java.io.*;
import java.util.*;
public class BOJ21940 {
    static final int INF = 1000 * 200;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 도시의 개수
        int m = Integer.parseInt(st.nextToken()); // 도로의 개수
        int [][] map = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j) continue;
                map[i][j] = INF;
            }
        }

        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(map[s][e] > c) map[s][e] = c;
        }

        int f = Integer.parseInt(br.readLine());
        int [] city = new int[f];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < f ; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(map[i][j] > map[i][k] + map[k][j]){
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        TreeMap<Integer, TreeSet<Integer>> memo = new TreeMap<>();
        for (int i = 1; i <= n; i++) {
            boolean flag = true;
            int max = 0;
            for (int j = 0; j < f; j++) {
                if(map[i][city[j]] == INF || map[city[j]][i] == INF){
                    flag = false;
                    break;
                }
                max = Math.max(max, map[i][city[j]] + map[city[j]][i]);
            }

            if(!flag) continue;

            if(memo.containsKey(max)){
                memo.get(max).add(i);
            }
            else{
                TreeSet<Integer> set = new TreeSet<>();
                set.add(i);
                memo.put(max, set);
            }
        }
        StringBuilder sb = new StringBuilder();
        TreeSet<Integer> set = memo.get(memo.firstKey());
        for (Integer integer : set) {
            sb.append(integer).append(" ");
        }
        System.out.println(sb);
    }
}
