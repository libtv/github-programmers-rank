package BarkingDog.YouTube_25_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 트리의 부모 찾기 실버2
public class BJ11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 노드의 개수
        ArrayList<Integer> [] list = new ArrayList[n+1];
        for (int i = 0; i <= n ; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        int [] parent = new int[n+1];
        boolean [] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()){
            int start = q.poll();
            int size = list[start].size();
            for (int i = 0; i < size; i++) {
                int next = list[start].get(i);
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                    parent[next] = start;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
