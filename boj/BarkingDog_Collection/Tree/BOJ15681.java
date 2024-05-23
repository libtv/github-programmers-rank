package boj.BarkingDog_Collection.Tree;

// 트리와 쿼리 골드5
import java.util.*;
import java.io.*;
public class BOJ15681 {
    static ArrayList<Integer>[] tree;
    static int [] level;
    static int [] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점의 수
        int r = Integer.parseInt(st.nextToken()); // 루트 번호
        int q = Integer.parseInt(st.nextToken()); // 쿼리의 수
        tree = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        level = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(r);
        level[r] = 1;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            for (int i = 0; i < tree[cur].size(); i++) {
                int next = tree[cur].get(i);
                if(level[next] != 0) continue;
                level[next] = level[cur] + 1;
                queue.add(next);
            }
        }
        memo = new int[n+1];
        DFS(r);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q ; i++) {
            int root = Integer.parseInt(br.readLine());
            sb.append(memo[root]).append("\n");
        }
        System.out.println(sb);

    }
    public static int DFS(int v){
        int size = tree[v].size();
        if(size == 0){
            memo[v] = 1;
            return 1;
        }

        for (int i = 0; i < size; i++) {
            int next = tree[v].get(i);
            if(level[next] > level[v]){
                if(memo[next] == 0){
                    memo[v] += DFS(next);
                }
                else memo[v] += memo[next];
            }
        }
        memo[v]++;
        return memo[v];
    }
}
