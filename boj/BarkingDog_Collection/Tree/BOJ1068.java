package boj.BarkingDog_Collection.Tree;

// 트리 골드5
import java.io.*;
import java.util.*;
public class BOJ1068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = 0;
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1){
                root = i;
                continue;
            }
            graph[i].add(parent);
            graph[parent].add(i);
        }
        int remove = Integer.parseInt(br.readLine());
        if(remove == root){
            System.out.println(0);
            return;
        }
        boolean [] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        visited[root] = true;
        int count = 0;
        while (!q.isEmpty()){
            int cur = q.poll();
            int check = 0;
            for (int i = 0; i < graph[cur].size(); i++) {
                int next = graph[cur].get(i);
                if(visited[next] || next == remove) continue;
                visited[next] = true;
                q.add(next);
                check++;
            }
            if(check == 0) count++;
        }
        System.out.println(count);
    }
}
