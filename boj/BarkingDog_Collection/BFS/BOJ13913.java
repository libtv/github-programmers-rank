package boj.BarkingDog_Collection.BFS;

// 숨바꼭질4 골드4
import java.io.*;
import java.util.*;
public class BOJ13913 {
    static final int INF = 100000 + 1;
    static class node{
        int v; int move;
        public node(int v, int move){
            this.v = v; this.move = move;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end   = Integer.parseInt(st.nextToken());
        int [] memo = new int[100000 * 2 + 1];
        int [] visited = new int[100000 * 2 + 1];
        Arrays.fill(memo, INF);
        memo[start] = 0;
        PriorityQueue<node> pq = new PriorityQueue<>((o1,o2)->o1.move-o2.move);
        pq.add(new node(start,0));
        while (!pq.isEmpty()){
            node node = pq.poll();
            if(memo[node.v]!=node.move) continue;
            for (int i = 0; i < 3 ; i++) {
                int nx = 0;
                switch(i){
                    case 0 :{
                        nx = node.v + 1;
                        break;
                    }
                    case 1 :{
                        nx = node.v - 1;
                        break;
                    }
                    case 2 :{
                        nx = node.v * 2;
                        break;

                    }
                }
                if(0 <= nx && nx < 100000 * 2 + 1){
                    if(memo[nx] > memo[node.v] + 1){
                        memo[nx] = memo[node.v] + 1;
                        visited[nx] = node.v;
                        pq.add(new node(nx, memo[nx]));
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int temp = end;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(temp);
        while (temp!=start){
            list.add(visited[temp]);
            temp = visited[temp];
        }
        for (int i = list.size()-1; i >=0 ; i--) {
            sb.append(list.get(i)).append(" ");
        }
        sb.insert(0, memo[end] + "\n");
        System.out.println(sb);
    }
}
