package BarkingDog.YouTube_25_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 사회망 서비스(SNS) 골드3
public class BJ2533_TimeOut {
    static ArrayList<Integer>[] graph;
    static Set<Integer> delete;
    static boolean [] list;
    static boolean [] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  // 노드의 개수 n
        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n - 1 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 0; i <= n; i++) {
            Collections.sort(graph[i]); // 오름차순 정렬
        }

        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        list = new boolean[n+1]; // 없어진 노드들
        while (true){
            int start = 0;
            for (int i = 1; i <= n; i++) { // 연결되어 있는 남은 간선 찾기
                if(list[i]) continue;
                for (int next :graph[i]) {
                    if(!list[next]){
                        start = i;
                        break;
                    }
                }
                if(start > 0){
                    break;
                }
            }
            if(start == 0){
                break;
            }
            q.add(start);
            delete = new HashSet<>();
            visited = new boolean[n+1];
            visited[start] = true;
            BFS(start);
            count += delete.size();
            Iterator<Integer> iterator = delete.iterator();
            while (iterator.hasNext()){
                int target = iterator.next();
                list[target] = true;
            }
        }
        System.out.println(count);
    }
    public static void BFS(int cur){
        boolean flag = false;
        for (int next : graph[cur]) {
            if(!visited[next] && !list[next]){
                visited[next] = true;
                flag = true;
                BFS(next);
            }
        }
        if(!flag){
            for (int next: graph[cur]) { // 부모 노드 찾기
                if(!list[next]){
                    delete.add(next);
                    break;
                }
            }
        }
    }
}

/*
얼리 아답터가 아닌 사람들은 자신의 모든 친구들이 얼리 아답터일 때만 이 아이디어를 받아들인다.


 */