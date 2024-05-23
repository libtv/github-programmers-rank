package boj.BarkingDog_Collection.Graph;

// 구슬 찾기 골드4
import java.io.*;
import java.util.*;
public class BOJ2617 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 구슬의 개수
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수
        ArrayList<Integer> [] low = new ArrayList[n+1];
        ArrayList<Integer> [] high = new ArrayList[n+1];
        for (int i = 0; i <= n ; i++) {
            low[i] = new ArrayList<>();
            high[i] = new ArrayList<>();
        }

        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());  // b > s
            int s = Integer.parseInt(st.nextToken());
            low[b].add(s);  //  b -> s 더 작은 방향
            high[s].add(b); //  s -> b 더 큰 방향
        }
        int [] lower  = new int[n+1];
        int [] higher = new int[n+1];

        Queue<Integer> q = new LinkedList<>();
        boolean [] visited;
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n+1];
            visited[i] = true;
            q.add(i);
            while (!q.isEmpty()){
                int cur = q.poll();
                for (int j = 0; j < high[cur].size(); j++) {
                    int next = high[cur].get(j);
                    if(visited[next]) continue;
                    visited[next] = true;
                    higher[next]++;
                    q.add(next);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n+1];
            visited[i] = true;
            q.add(i);
            while (!q.isEmpty()){
                int cur = q.poll();
                for (int j = 0; j < low[cur].size(); j++) {
                    int next = low[cur].get(j);
                    if(visited[next]) continue;
                    lower[next]++;
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
        int cnt = 0;
        int check = n / 2;
        for (int i = 1; i <= n; i++) {
            if(lower[i] > check || higher[i] > check) cnt++;
        }
        System.out.println(cnt);
    }
}
