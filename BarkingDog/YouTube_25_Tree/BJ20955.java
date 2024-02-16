package org.example.BarkingDog.YouTube_25_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 민서의 응급 수술 골드4
public class BJ20955 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]); // 뉴런의 개수
        int m = Integer.parseInt(split[1]); // 시냅스의 개수 M
        // 트리의 성질 = 간선의 개수는 노드의 개수 - 1 이다. <- 를 이용하자.
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        while (m-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        boolean[] visited = new boolean[n+1];
        int sum = 0;
        int treeCount = 0;
        for (int i = 1; i <= n; i++) {
            if(!visited[i]){
                int count = 0;
                treeCount++;
                Queue<Integer> q = new LinkedList<>();
                Set<Integer> set = new HashSet<>();
                q.add(i);
                set.add(i);
                visited[i] = true;
                while (!q.isEmpty()){
                    int cur = q.poll();
                    count += graph[cur].size();
                    for (int next: graph[cur]) {
                        if(!visited[next]){
                            visited[next] = true;
                            q.add(next);
                            set.add(next);
                        }
                    }
                }
                sum += Math.abs((count / 2) - (set.size() - 1)); // 트리로 만들기 위한 연산 횟수
            }
        }
        sum += treeCount - 1; // 각 트리를 연결하는 연산 횟수
        System.out.println(sum);
    }
}
/*
뉴런의 연결 정보가 주어졌을 때, 모든 뉴런을 하나의 트리 형태로 연결하기 위하여 필요한 최소 연산 횟수를 구하는 프로그램을 작성하시오.
 */
/*
반례
5 4
1 2
3 4
3 5
4 5
 */