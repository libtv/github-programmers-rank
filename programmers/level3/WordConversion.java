package programmers.level3;

/**
 * 단어 변환
 * BFS/DFS
 * level3
 */
import java.util.*;
public class WordConversion {
    static final int INF = 100000;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int t_idx = -1;
        int b_idx = -1;
        int n = words.length;

        int size = begin.length(); // 모든 단어의 길이는 같다.

        // 그래프 초기화 만약 begin이 words 안에 없다면? -> 1개 더 정점
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        // 그래프 연결을 빠르게 하기 위한 boolean [][] check
        boolean [][] check = new boolean [n][n];

        for(int i = 0; i < n; i++){
            if(t_idx == -1 && target.equals(words[i])){
                t_idx = i;
            }
            if(b_idx == -1 && begin.equals(words[i])){
                b_idx = i;
            }
            for(int j = 0; j < n; j++){
                if(i == j || check[i][j] || check[j][i]) continue;

                int cnt = 0;
                for(int k = 0; k < size; k++){
                    if(words[i].charAt(k) != words[j].charAt(k)){
                        cnt++;
                    }
                    if(cnt == 2) break;
                }
                if(cnt != 1) continue;
                graph[i].add(j);
                graph[j].add(i);
                check[i][j] = true;
                check[j][i] = true;
            }
        }
        if(t_idx == -1) return 0; // <- words 안에 target이 없다면

        if(b_idx == -1){ // <- words 안에 begin이 없다면
            for(int i = 0; i < n; i++){
                int cnt = 0;
                for(int j = 0; j < size; j++){
                    if(begin.charAt(j) != words[i].charAt(j)) cnt++;
                    if(cnt == 2) break;
                }
                if(cnt != 1) continue;
                graph[n].add(i);
                graph[i].add(n);
            }
            b_idx = n;
        }

        int [] visited = new int [n+1];
        Arrays.fill(visited, INF);
        visited[b_idx] = 0;
        Queue<int []> q = new LinkedList<>();
        q.add(new int []{b_idx, 0});
        while(!q.isEmpty()){
            int [] temp = q.poll();
            int cur = temp[0];
            for(int i = 0; i < graph[cur].size(); i++){
                int next = graph[cur].get(i);
                if(visited[next] <= temp[1] + 1) continue;
                visited[next] = temp[1] + 1;
                q.add(new int []{next, visited[next]});
            }
        }

        if(visited[t_idx] == INF) return 0;
        else return visited[t_idx];
    }
}
