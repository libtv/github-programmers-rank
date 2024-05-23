package boj.BarkingDog_Collection.Tree;

// 트리의 높이와 너비 골드2
import java.util.*;
import java.io.*;
public class BOJ2250 {
    static int [][] tree;
    static int [] level;
    static ArrayList<Integer>[] memo;
    static int cnt = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        tree = new int[n+1][2];
        boolean [] visited = new boolean[n+1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            if(left != -1){
                tree[parent][0] = left;
                visited[left] = true;
            }
            if(right != -1){
                tree[parent][1] = right;
                visited[right] = true;
            }
        }
        int root = 0;
        for (int i = 1; i <= n; i++) {
            if(!visited[i]){
                root = i;
                break;
            }
        }
        // System.out.println("root= " + root);
        level = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        level[root] = 1;
        q.add(root);
        int max = 1;
        while (!q.isEmpty()){
            int cur = q.poll();
            if(tree[cur][0] != 0){
                int left = tree[cur][0];
                level[left] = level[cur] + 1;
                q.add(left);
                if(level[left] > max){
                    max = level[left];
                }
            }
            if(tree[cur][1] != 0){
                int right = tree[cur][1];
                level[right] = level[cur] + 1;
                q.add(right);
                if(level[right] > max){
                    max = level[right];
                }
            }
        }
        memo = new ArrayList[max+1];
        for (int i = 0; i <= max; i++) {
            memo[i] = new ArrayList<>();
        }
        Order(root);

        ArrayList<int []> list = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            if(memo[i].size() == 0) continue;
            Collections.sort(memo[i]);
            int check = memo[i].get(memo[i].size() - 1) - memo[i].get(0) + 1;
            list.add(new int[]{i, check});
        }
        int [] answer = list.stream().max((o1,o2)->{
            if(o1[1] != o2[1]) return o1[1] - o2[1];
            return o2[0] - o1[0];
        }).get();
        System.out.printf("%d %d", answer[0], answer[1]);

    }
    public static void Order(int v){
        if(tree[v][0] != 0) Order(tree[v][0]);
        int lev = level[v];
        memo[lev].add(cnt++);
        if(tree[v][1] != 0) Order(tree[v][1]);
    }
}
