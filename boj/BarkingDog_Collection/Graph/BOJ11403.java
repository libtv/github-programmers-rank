package boj.BarkingDog_Collection.Graph;

// 경로 찾기 실버1
import java.io.*;
import java.util.*;
public class BOJ11403 {
    static ArrayList<Integer>[] graph;
    static int [][] answer;
    static boolean [] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n];
        for (int i = 0; i < n ; i++) {
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if(Integer.parseInt(st.nextToken()) == 0) continue;
                graph[i].add(j);
            }
        }
        answer = new int[n][n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            q.add(i);
            while (!q.isEmpty()){
                int cur = q.poll();
                for (int j = 0; j < graph[cur].size(); j++) {
                    int next = graph[cur].get(j);
                    if(visited[next]) continue;
                    visited[next] = true;
                    answer[i][next] = 1;
                    q.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
/*
0 -> 3
1 -> 6
3 -> 4
3 -> 5
4 -> 0
5 -> 6
6 -> 2
 */