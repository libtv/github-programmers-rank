package boj.BarkingDog_Collection.MST;

/**
 * 우주신과의 교감 골드3
 * MST
 * 크루스칼 알고리즘
 */
import java.io.*;
import java.util.*;
public class BOJ1774 {
    static int [] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 우주신들의 개수
        int m = Integer.parseInt(st.nextToken()); // 이미 연결된 신들과의 통로 개수
        parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        int [][] memo = new int[n+1][2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            memo[i][0] = Integer.parseInt(st.nextToken());
            memo[i][1] = Integer.parseInt(st.nextToken());
        }
        List<double[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            list.add(new double[]{v1,v2,0});
            list.add(new double[]{v2,v1,0});
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j) continue;
                double distance = calculate(memo[i][0], memo[i][1], memo[j][0], memo[j][1]);
                list.add(new double[]{i,j,distance});
            }
        }
        Collections.sort(list, (o1,o2)->{
            if(o1[2] < o2[2]) return -1;
            else if(o1[2] == o2[2]) return 0;
            else return 1;
        });
        int cnt = 0;
        double ans = 0;
        for (double[] doubles : list) {
            if(cnt == n - 1) break;
            int x = (int)doubles[0];
            int y = (int)doubles[1];
            if(isSameGroup(x, y)) continue;
            cnt++;
            ans += doubles[2];
            union(x, y);
        }
        System.out.printf("%.2f", ans);
    }
    public static int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y) return;

        if(x > y){
            parent[x] = y;
        }
        else parent[y] = x;
    }
    public static boolean isSameGroup(int x, int y){
        if(find(x) == find(y)) return  true;
        return false;
    }
    public static double calculate(int x1, int y1, int x2, int y2){
       return Math.sqrt(Math.pow(x2-x1 , 2) + Math.pow(y2-y1, 2));
    }
}
