package boj.BarkingDog_Collection.MST;

/**
 * 최소 스패닝 트리 골드4
 * 크루스칼 알고리즘
 * 2024년 05월 14일
 */
import java.io.*;
import java.util.*;
public class BOJ1197_Kruskal {
    static int [] parent = new int[10001]; // 정점의 최대 개수 10000
    static int n, e; // 정점, 간선의 개수
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        List<int []> edges = new ArrayList<>();
        for (int i = 0; i < e ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 정점
            int b = Integer.parseInt(st.nextToken()); // 정점
            int c = Integer.parseInt(st.nextToken()); // 가중치  // -1000000 ~ 1000000
            edges.add(new int[]{a,b,c});
        }
        // Collections.sort(edges, Comparator.comparingInt(o -> o[2]));
        Collections.sort(edges, (o1, o2)->{
            return o1[2] - o2[2];
        });

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int cnt = 0;
        int ans = 0;
        for (int[] edge : edges) {
            if(cnt == n - 1) break;
            if(isSameGroup(edge[0], edge[1])) continue;
            ans += edge[2];
            cnt++;
            union(edge[0], edge[1]);
        }
        System.out.println(ans);

    }
    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x < y){
            parent[y] = x;
        }
        else{
            parent[x] = y;
        }
    }
    public static int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    public static boolean isSameGroup(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y) return true;
        return false;
    }
}
