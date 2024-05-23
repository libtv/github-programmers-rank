package programmers.HighScoreKit.ExhaustiveSearch;

/**
 * 전력망을 둘로 나누기
 * 완탐
 * level2
 */
import java.util.*;
public class SplittingThePowerGridIntwo {
    static int min = Integer.MAX_VALUE;
    static ArrayList<Integer> [] graph;
    public int solution(int n, int[][] wires) {

        // 그래프 초기화
        graph = new ArrayList[n+1];
        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        // 트리의 간선은 정점 - 1
        for(int i = 0; i < n - 1; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        boolean [][] visited = new boolean [n+1][n+1];
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < graph[i].size(); j++){
                int next = graph[i].get(j);
                if(visited[i][next]) continue;

                calculate(n, i, next);

                visited[i][next] = true;
                visited[next][i] = true;
            }

        }
        return min;
    }
    public static void calculate(int n, int v1, int v2){
        int cnt = 1;
        boolean [] visited = new boolean[n+1];
        visited[1] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i = 0; i < graph[cur].size(); i++){
                int next = graph[cur].get(i);
                if(visited[next]) continue;
                if(cur == v1 && next == v2 || cur == v2 && next == v1) continue;
                visited[next] = true;
                cnt++;
                q.add(next);
            }
        }
        int cnt2 = n - cnt;
        min = Math.min(min, Math.abs(cnt2 - cnt));
    }
}
