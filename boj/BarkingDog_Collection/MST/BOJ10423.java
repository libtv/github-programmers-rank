package boj.BarkingDog_Collection.MST;

/**
 *  전기가 부족해 골드3
 *  MST
 *  프림 알고리즘
 */
import java.util.*;
import java.io.*;
public class BOJ10423 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 도시의 개수
        int m = Integer.parseInt(st.nextToken()); // 케이블의 개수
        int k = Integer.parseInt(st.nextToken()); // 발전소의 개수
        int [] energy = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            energy[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<int[]>[] graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[v1].add(new int[]{v2, w});
            graph[v2].add(new int[]{v1, w});
        }


        boolean [] visited = new boolean[n+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o->o[1]));

        for (int i = 0; i < k; i++) {
            int target = energy[i];
            for (int[] ints : graph[target]) {
                pq.add(ints);
            }
            visited[target] = true;
        }

        int cnt = 0;
        int ans = 0;
        while (cnt < n - k){
            int [] temp = pq.poll();
            if(visited[temp[0]]) continue;
            visited[temp[0]] = true;
            cnt++;
            ans += temp[1];
            for (int i = 0; i < graph[temp[0]].size(); i++) {
                int [] next = graph[temp[0]].get(i);
                if(visited[next[0]]) continue;
                pq.add(next);
            }
        }
        System.out.println(ans);
    }
}
