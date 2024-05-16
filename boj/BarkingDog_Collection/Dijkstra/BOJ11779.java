package boj.BarkingDog_Collection.Dijkstra;

/**
 * 최소비용 구하기 2 골드3
 * 다익스트라 + 경로복원
 */
import java.io.*;
import java.util.*;
public class BOJ11779 {
    static final int INF = 1000 * 100000; // 1000개의 정점 * 버스 최대 비용 100000
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int m = Integer.parseInt(br.readLine()); // 버스의 개수

        // 그래프 초기화
        ArrayList<int []> [] graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 input 무방향? 방향?
        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[s].add(new int[]{e,c});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); // 시작 정점
        int end   = Integer.parseInt(st.nextToken()); // 도착 정점

        int [] min  = new int[n+1]; // 최단 거리 테이블
        int [] next = new int[n+1]; // 경로 복원용

        Arrays.fill(min, INF);
        min[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{start, 0});
        while (!pq.isEmpty()){
            int [] temp = pq.poll();
            if(min[temp[0]] != temp[1]) continue; // 확정된 정점의 거리와 다른 경우
            for (int i = 0; i < graph[temp[0]].size(); i++) {
                int [] nx = graph[temp[0]].get(i);
                if(min[nx[0]] <= min[temp[0]] + nx[1]) continue;
                min[nx[0]] = min[temp[0]] + nx[1];
                next[nx[0]] = temp[0];
                pq.add(new int[]{nx[0], min[nx[0]]});
            }
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        int s = start;
        int e = end;
        while (s != e){
            e = next[e];
            stack.push(e);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(min[end]).append("\n");
        sb.append(stack.size()).append("\n");
        while (!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }
}
