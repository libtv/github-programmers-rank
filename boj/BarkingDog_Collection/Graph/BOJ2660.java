package boj.BarkingDog_Collection.Graph;

// 회장뽑기 골드5
import java.util.*;
import java.io.*;
public class BOJ2660 {
    static final int INF = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        while (true){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if(u == v && v == - 1) break;
            graph[u].add(v);
            graph[v].add(u);
        }

        TreeMap<Integer, ArrayList<Integer>> treeMap = new TreeMap<>();

        int [] check;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            check = new int[n+1];
            Arrays.fill(check, INF);
            q.add(i);
            check[i] = 0;
            while (!q.isEmpty()){
                int cur = q.poll();
                for (int j = 0; j < graph[cur].size(); j++) {
                    int next = graph[cur].get(j);
                    if(check[next] > check[cur] + 1){
                        check[next] = check[cur] + 1;
                        q.add(next);
                    }
                }
            }

            int max = 0;
            for (int j = 1; j <= n; j++) {
                max = Math.max(check[j], max);
            }
            if(treeMap.containsKey(max)){
                treeMap.get(max).add(i);
            }
            else{
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                treeMap.put(max, temp);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(treeMap.firstKey()).append(" ").append(treeMap.get(treeMap.firstKey()).size()).append("\n");
        ArrayList<Integer> temp = treeMap.get(treeMap.firstKey());
        Collections.sort(temp);
        for (Integer integer : temp) {
            sb.append(integer).append(" ");
        }
        System.out.println(sb);
    }
}
