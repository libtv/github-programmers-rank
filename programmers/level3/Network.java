package programmers.level3;

/**
 * 네트워크
 * BFS/DFS
 * level3
 */
import java.util.*;
public class Network {
    public int solution(int n, int[][] computers) {

        // 그래프 초기화
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j || computers[i][j] == 0) continue;
                graph[i].add(j);
            }
        }
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean [] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            answer++;
            visited[i] = true;
            q.add(i);
            while(!q.isEmpty()){
                int cur = q.poll();
                for(int j = 0; j < graph[cur].size(); j++){
                    int next = graph[cur].get(j);
                    if(visited[next]) continue;
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
        return answer;
    }
}
