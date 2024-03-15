package BarkingDog.YouTube_24_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 케빈 베이컨의 6단계 법칙 실버1
public class BJ1389 {
    static  ArrayList<ArrayList<Integer>> list;
    static  boolean [] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        list  = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        while (m-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.get(start).add(end);
            list.get(end).add(start); // 양방향
        }
        visited = new boolean[n+1];
        int [] sum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j){
                    continue;
                }
                Arrays.fill(visited, false);
                visited[i] = true;
                Queue<Node> q = new LinkedList<>();
                q.add(new Node(i, 0));
                int length = 0;
                while (!q.isEmpty()){
                    Node node = q.poll();
                    int cur = node.cur;
                    int depth = node.depth;
                    int size = list.get(cur).size();
                    for (int k = 0; k < size; k++) {
                        int next = list.get(cur).get(k);
                        if(next == j){
                            length = depth + 1;
                            q.clear();
                            break;
                        }
                        if(!visited[next]){
                            visited[next] = true;
                            q.add(new Node(next, depth+1));
                        }
                    }
                }
                sum[i] += length;
            }
        }
        int min = Integer.MAX_VALUE;
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            if(min > sum[i]){
                min = sum[i];
                idx = i;
            }
        }
        System.out.println(idx);
    }
}
class Node{
    int cur;
    int depth;
    public Node(int cur, int depth){
        this.cur = cur;
        this.depth = depth;
    }
}

/*
케빈 베이컨의 6단계 법칙에 의하면 지구에 있는 모든 사람들은 최대 6단계 이내에서 서로 아는 사람으로 연결될 수 있다.
케빈 베이컨 게임은 임의의 두 사람이 최소 몇 단계 만에 이어질 수 있는지 계산하는 게임이다.

 */