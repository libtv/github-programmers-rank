package boj.BarkingDog_Collection.Graph;

// 거짓말 골드4
import java.util.*;
import java.io.*;
public class BOJ1043 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken()); // 진실을 아는 사람
        ArrayList<Integer> know = new ArrayList<>();
        while (k-->0){
            know.add(Integer.parseInt(st.nextToken()));
        }
        ArrayList<Integer>[] party = new ArrayList[m]; // 파티
        for (int i = 0; i < m; i++) {
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            while (j-->0){
                 party[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        ArrayList<Integer> [] graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
            if(i == 0) continue;
            for (int j = 0; j < m; j++) {
                ArrayList<Integer> temp = party[j];
                if(!temp.contains(Integer.valueOf(i))) continue;
                for (int l = 0; l < temp.size(); l++) {
                    int check = temp.get(l);
                    if(check != i && !graph[i].contains(check)){
                        graph[i].add(check);
                    }
                }
            }
        }
        boolean [] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        int size = know.size();
        for (int i = 0; i < size; i++) {
            int target = know.get(i);
            if(visited[target]) continue;
            visited[target] = true;
            q.add(target);
            while (!q.isEmpty()){
                int cur = q.poll();
                for (int j = 0; j < graph[cur].size(); j++) {
                    int next = graph[cur].get(j);
                    if(visited[next]) continue;
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
        ArrayList<Integer> black_list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if(visited[i]) black_list.add(i);
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> temp = party[i];
            boolean flag = true;
            for (int target : temp) {
                if(black_list.contains(target)){
                    flag = false;
                    break;
                }
            }
            if(flag) cnt++;
        }
        System.out.println(cnt);
    }
}
