package programmers.level3;

/**
 * 여행경로
 * DFS/BFS + BackTracking
 * level3
 */
import java.util.*;
public class TravelRoute {
    static  HashMap<String, Integer> map;
    static  ArrayList<String>[] graph;
    static  int [][] visited;
    static  String [] memo;
    static  String [] answer;
    static  int size;
    public  String[] solution(String[][] tickets) {
        map = new HashMap<>();
        size = tickets.length;
        int cnt = 0;
        for(int i = 0; i < tickets.length; i++){
            for(int j = 0; j < 2; j++){
                String target = tickets[i][j];
                if(map.containsKey(target)) continue;
                map.put(target, cnt++);
            }
        }
        cnt--;
        graph = new ArrayList[cnt+1];
        for(int i = 0; i <= cnt; i++){
            graph[i] = new ArrayList<>();
        }
        visited = new int [cnt+1][cnt+1];

        for(int i = 0; i < tickets.length; i++){
            String start = tickets[i][0];
            String end = tickets[i][1];
            graph[map.get(start)].add(end);
            visited[map.get(start)][map.get(end)]++;
        }

        for(int i = 0; i <= cnt; i++){
            Collections.sort(graph[i]);
        }
        memo = new String[size+1];
        answer = new String[size+1];
        memo[0] = "ICN";
        BackTracking(1, "ICN");

        return answer;

    }
    public static void BackTracking(int depth, String cur){
        if(depth == size + 1){
            if(answer[0] == null){
                for(int i = 0; i <= size; i++){
                    answer[i] = memo[i];
                }
            }
            else{ // 알파벳 순서 로직
                boolean flag = false;
                for(int i = 0; i <= size; i++){
                    if(answer[i].equals(memo[i])) continue;
                    if(answer[i].compareTo(memo[i]) > 0){
                        flag = true;
                    }
                    break;
                }
                if(flag){
                    for(int i = 0; i <= size; i++){
                        answer[i] = memo[i];
                    }
                }
            }
            return;
        }
        int idx = map.get(cur);
        for(int i = 0; i < graph[idx].size(); i++){
            String next = graph[idx].get(i);
            if(visited[idx][map.get(next)] == 0) continue;
            visited[idx][map.get(next)]--;
            memo[depth] = next;
            BackTracking(depth + 1, next);
            visited[idx][map.get(next)]++;
        }
    }
}
