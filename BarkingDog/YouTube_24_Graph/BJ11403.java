package org.example.BarkingDog.YouTube_24_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 경로 찾기 실버1
public class BJ11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1){
                    list.get(i).add(j);
                }
            }
        }
        int [][] answer = new int[n][n];
        boolean [] visited = new boolean[n+1];
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                int start = i;
                Arrays.fill(visited, false);
                visited[start] = true;
                Queue<Integer> q = new LinkedList<>();
                q.add(start);
                boolean flag = false;
                while (!q.isEmpty()){
                    int x = q.poll();
                    int size = list.get(x).size();
                    for (int k = 0; k < size; k++) {
                        int next = list.get(x).get(k);
                        if(next == j){
                            flag = true;
                            q.clear();
                            break;
                        }
                        if(!visited[next]){
                            visited[next] = true;
                            q.add(next);
                        }
                    }
                }
                if(flag){
                    answer[i][j] = 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
/*
가중치 없는 방향 그래프 G가 주어졌을 때, 모든 정점 (i, j)에 대해서, i에서 j로 가는 길이가 양수인 경로가 있는지 없는지 구하는 프로그램을 작성하시오.

첫째 줄에 정점의 개수 N (1 ≤ N ≤ 100)이 주어진다.
둘째 줄부터 N개 줄에는 그래프의 인접 행렬이 주어진다.
i번째 줄의 j번째 숫자가 1인 경우에는 i에서 j로 가는 간선이 존재한다는 뜻이고, 0인 경우는 없다는 뜻이다. i번째 줄의 i번째 숫자는 항상 0이다.


 */
