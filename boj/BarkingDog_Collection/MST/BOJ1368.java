package boj.BarkingDog_Collection.MST;

/**
 * 물대기 골드2
 * MST
 * 13% -> 틀렸습니다
 */
import java.util.*;
import java.io.*;
public class BOJ1368 {
    static int sum = 0;
    static int [] cost;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 논의 수

        cost = new int[n+1];
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int c = Integer.parseInt(br.readLine());
            list.add(new int[]{i, c});
            cost[i] = c;
        }

        ArrayList<int[]>[] graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int c = Integer.parseInt(st.nextToken());
                if(i == j) continue;
                graph[i].add(new int[]{j, c});
            }
        }

        Collections.sort(list, (o1,o2)->{
            return o1[1] - o2[1];
        });

        sum = list.get(0)[1];
        int root = list.get(0)[0];

        boolean [] visited = new boolean[n+1];
        visited[root] = true;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (int[] ints : graph[root]) {
            pq.add(ints);
        }

        int cnt = 0;
        while (cnt < n - 1){
            int [] temp = pq.poll();
            if(visited[temp[0]]) continue;
            visited[temp[0]] = true;
            cnt++;
            // 연결 vs 현재 논 우물
            if(temp[1] <= cost[temp[0]]){
                sum += temp[1];
            }
            else sum += cost[temp[0]];
            for (int i = 0; i < graph[temp[0]].size(); i++) {
                int [] next = graph[temp[0]].get(i);
                if(visited[next[0]]) continue;
                pq.add(next);
            }
        }
        System.out.println(sum);
    }
}
