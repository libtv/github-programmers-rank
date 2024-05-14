package boj.BarkingDog_Collection.MST;

/**
 * 최소 스패닝 트리 골드4
 * 프림 알고리즘
 * 2024년 05월 14일
 */
import java.io.*;
import java.util.*;
public class BOJ1197_Prim {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점의 개수
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수
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

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1])); // o[2]가 낮은 순서대로
        boolean [] visited = new boolean[n+1];
        visited[1] = true;
        int cnt = 0;
        int ans = 0;

        for (int[] ints : graph[1]) {
            pq.add(ints);
        }

        while (cnt < n - 1){
            int [] temp = pq.poll();
            if(visited[temp[0]]) continue; // 방문한 정점과 방문하지 않은 정점
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
