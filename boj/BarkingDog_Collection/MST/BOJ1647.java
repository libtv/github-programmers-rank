package boj.BarkingDog_Collection.MST;

/**
 * 도시 분할 계획 골드4
 * MST
 * 크림
 * 2240ms
 */
import java.util.*;
import java.io.*;
public class BOJ1647 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 집의 개수 n
        int m = Integer.parseInt(st.nextToken()); // 길의 개수 m
        ArrayList<int []>[] graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[v1].add(new int[]{v2, c});
            graph[v2].add(new int[]{v1, c});
        }

        boolean [] visited = new boolean[n+1];
        visited[1] = true;

        PriorityQueue<int []> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (int[] ints : graph[1]) {
            pq.add(ints);
        }

        int  cnt = 0;
        long ans = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (cnt < n - 1){
            int [] temp = pq.poll();
            if(visited[temp[0]]) continue;
            visited[temp[0]] = true;
            cnt++;
            list.add(temp[1]);
            for (int i = 0; i < graph[temp[0]].size(); i++) {
                int [] next = graph[temp[0]].get(i);
                if(visited[next[0]]) continue;
                pq.add(next);
            }
        }
        Collections.sort(list);
        for (int i = 0; i < n - 2; i++) {
            ans += list.get(i);
        }
        System.out.println(ans);
    }
}
