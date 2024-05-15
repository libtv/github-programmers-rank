package boj.BarkingDog_Collection.MST;

/**
 *  물대기 골드2
 *  MST
 *  Kruskal(Union - Find) Algorithm
 *  Kruskal - 492ms Prim - 344ms 항상 Prim 알고리즘이 더 빠르다
 */
import java.io.*;
import java.util.*;
public class BOJ1368_Kruskal {
    static int [] parent;
    static int [] well;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        parent = new int[n+1];
        well = new int[n+1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;  // 크루스칼 부모 노드 초기화
            well[i] = Integer.parseInt(br.readLine()); // 우물 비용
        }

        List<int[]> edges = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if(i == j){
                    edges.add(new int[]{0, i, well[i]});
                    continue;
                }
                edges.add(new int[]{i, j, cost});
            }
        }

        Collections.sort(edges, Comparator.comparingInt(o -> o[2]));
        int cnt = 0;
        int ans = 0;
        for (int[] edge : edges) {
            if(cnt == n) break;
            if(find(edge[0]) == find(edge[1])) continue; // 이미 같은 그룹
            union(edge[0], edge[1]);
            cnt++;
            ans += edge[2];
        }
        System.out.println(ans);

    }
    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x > y) parent[x] = y;
        else parent[y] = x;
    }
    public static int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
}
