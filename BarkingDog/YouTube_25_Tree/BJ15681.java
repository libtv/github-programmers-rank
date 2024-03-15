package BarkingDog.YouTube_25_Tree;

import java.io.*;
import java.util.*;
public class BJ15681 {
    static int [] depth;
    static ArrayList<Integer>[] graph;
    static int [] memo;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String [] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]); // 노드 개수
        int r = Integer.parseInt(split[1]); // 루트 번호
        int Q = Integer.parseInt(split[2]); // 쿼리의 수
        graph = new ArrayList[n+1]; // 100000 + 1
        for (int i = 0; i <= n; i++) { // 그래프 초기화
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {  // 그래프
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        // bfs로 depth 기록하기
        depth = new int[n+1]; // 100000 + 1
        Queue<Integer> q = new LinkedList<>();
        q.add(r); // 루트에서 시작
        while (!q.isEmpty()){
            int cur = q.poll();
            for (int next : graph[cur]) {
                if(depth[next] == 0 && next!= r){
                    depth[next] = depth[cur] + 1;
                    q.add(next);
                }
            }
        }
        // System.out.println(Arrays.toString(depth)); 기록 완료
        memo = new int[n+1];
        ArrayList<MEMO> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new MEMO(i, depth[i]));
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            count = 0;
            int target = list.get(i).idx;
            DFS(target);
            memo[target] = count;
        }
        StringBuilder sb = new StringBuilder();
        while (Q-->0){
            int target = Integer.parseInt(br.readLine());
            sb.append(memo[target]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
    public static void DFS(int cur){
        count++;
        for (int next : graph[cur]) {
            if(depth[next] > depth[cur]){
                if(memo[next] != 0){
                    count += memo[next];
                    continue;
                }
                DFS(next);
            }
        }
    }
}
class MEMO implements Comparable<MEMO>{
    int idx;
    int depth;
    public MEMO(int idx, int depth){
        this.idx = idx;
        this.depth = depth;
    }
    public int compareTo(MEMO o){
        return o.depth - this.depth;     // 내림차순 정렬 depth
    }
}
