package programmers.HighScoreKit.Greedy;

/**
 * 섬 연결하기
 * greedy ? mst - minimum spanning tree
 * level 3
 */
import java.util.*;
public class ConnectingTheIslands {
    static int num;
    static int [] parent;
    public int solution(int n, int[][] costs) {

        int answer = 0;
        num = n;

        parent = new int [n+1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }

        ArrayList<int[]> list = new ArrayList<>();
        int size = costs.length;
        for(int i = 0; i < size; i++){
            list.add(new int [] {costs[i][0],costs[i][1],costs[i][2]});
            list.add(new int [] {costs[i][1],costs[i][0],costs[i][2]});
        }
        Collections.sort(list,(o1,o2)->{
            return o1[2] - o2[2];
        });

        int cnt = 0;
        for(int [] ints: list){
            if(cnt == n - 1) break;
            if(find(ints[0]) == find(ints[1])) continue;
            union(ints[0], ints[1]);
            answer += ints[2];
            cnt++;
        }
        return answer;
    }

    public static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x > y) parent[x] = y;
        else parent[y] = x;
    }
}
