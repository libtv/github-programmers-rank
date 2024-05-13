package boj.BarkingDog_Collection.Tree;

// 트리의 부모 찾기 실버2
import java.io.*;
import java.util.*;
public class BOJ11725 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        int [] parent = new int[n+1]; // 각 정점의 부모 기록
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while (!q.isEmpty()){
            int cur = q.poll();
            for (int i = 0; i < graph[cur].size(); i++) {
                int next = graph[cur].get(i);
                if(next == 1 || parent[next] != 0) continue;
                parent[next] = cur;
                q.add(next);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);

    }
}
/*

루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.

 */