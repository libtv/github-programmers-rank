package boj.BarkingDog_Collection.MST;

/**
 * 학교 탐방하기 골드3
 * MST
 * 프림
 */
import java.io.*;
import java.util.*;
public class BOJ13418 {
    public static  ArrayList<int []>[] graph;
    public static int n;
    public static int worst, best;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 건물의 개수
        int m = Integer.parseInt(st.nextToken()) + 1; // 간선의 개수

        graph = new ArrayList[n+1];
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
        check();
        check2();
        System.out.println((int)(Math.pow(worst, 2) - Math.pow(best, 2)));
    }
    public static void check(){
        boolean [] visited = new boolean[n+1];
        visited[0] = true;
        int cnt = 0;
        int check = 0;
        PriorityQueue<int []> pq = new PriorityQueue<>((o1,o2)->{
            return o1[1] - o2[1]; // 0 오르막길이 우선
        });
        for (int[] ints : graph[0]) {
            pq.add(ints);
        }
        while (cnt < n){
            int [] temp = pq.poll();
            if(visited[temp[0]]) continue;
            visited[temp[0]] = true;
            cnt++;
            if(temp[1] == 0) check++;
            for (int i = 0; i < graph[temp[0]].size(); i++) {
                int [] next = graph[temp[0]].get(i);
                if(visited[next[0]]) continue;
                pq.add(next);
            }

        }
        worst = check;
    }
    public static void check2(){
        boolean [] visited = new boolean[n+1];
        visited[0] = true;
        PriorityQueue<int []> pq = new PriorityQueue<>((o1,o2)->{
            return -(o1[1] - o2[1]);  // 1 내리막길이 우선
        });
        int cnt = 0;
        int check = 0;
        for (int[] ints : graph[0]) {
            pq.add(ints);
        }
        while (cnt < n){
            int [] temp = pq.poll();
            if(visited[temp[0]]) continue;
            visited[temp[0]] = true;
            cnt++;
            if(temp[1] == 0) check++;
            for (int i = 0; i < graph[temp[0]].size(); i++) {
                int [] next = graph[temp[0]].get(i);
                if(visited[next[0]]) continue;
                pq.add(next);
            }
        }
        best = check;
    }
}
