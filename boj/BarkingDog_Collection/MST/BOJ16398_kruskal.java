package boj.BarkingDog_Collection.MST;

/**
 * 행성 연결 골드4
 * MST - 크루스칼
 * 1636ms
 */
import java.io.*;
import java.util.*;
public class BOJ16398_kruskal {
    static int [] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        parent = new int[n+1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        ArrayList<int []> edges = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int c = Integer.parseInt(st.nextToken());
                if(i == j) continue;
                edges.add(new int[]{i, j, c});
                edges.add(new int[]{j, i, c});
            }
        }
        Collections.sort(edges, Comparator.comparingInt(o -> o[2]));
        int cnt = 0;
        long ans = 0;
        for (int[] edge : edges) {
            if(cnt == n - 1) break;
            if(same(edge[0], edge[1])) continue;
            union(edge[0], edge[1]);
            cnt++;
            ans += edge[2];
        }
        System.out.println(ans);
    }
    public static int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x > y) parent[x] = y;
        else parent[y] = x;
    }
    public static boolean same(int x, int y){
        if(find(x) == find(y)) return  true;
        return false;
    }
}
