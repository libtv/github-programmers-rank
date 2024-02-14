package org.example.BarkingDog.YouTube_24_Graph;

import java.io.*;
import java.util.*;

// 회장뽑기 골드5
public class BJ2660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] list = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if( a == -1 && b == -1)
                break;
            list[a].add(b); // 양방향
            list[b].add(a);
        }
        int [] visited = new int[n+1];
        int [] memo = new int[n+1];
        for (int i = 1; i <=n; i++) {
            Arrays.fill(visited , 0);
            Queue<Friend> q = new LinkedList<>();
            q.add(new Friend(i, 0));
            int max = 0;
            while (!q.isEmpty()){
                Friend friend = q.poll();
                int cur = friend.cur;
                int depth = friend.depth;
                int size = list[cur].size();
                for (int j = 0; j < size; j++) {
                    int next = list[cur].get(j);
                    if(visited[next] == 0 && next !=i){
                        visited[next] = depth + 1;
                        q.add(new Friend(next, depth + 1));
                    }
                }
            }
            for (int j = 1; j <=n; j++) {
                max = Math.max(visited[j], max);
            }
            memo[i] = max;
        }
        // System.out.println(Arrays.toString(memo));
        StringBuilder sb = new StringBuilder();
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            min = Math.min(min, memo[i]);
        }
        sb.append(min).append(" ");
        ArrayList<Integer> targets = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if(memo[i] == min){
                targets.add(i);
            }
        }
        int size = targets.size();
        sb.append(size).append("\n");
        for (int i = 0; i < size; i++) {
            sb.append(targets.get(i)).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
class Friend{
    int cur, depth;
    public Friend(int cur, int depth){
        this.cur = cur;
        this.depth = depth;
    }
}
/*
월드컵 축구의 응원을 위한 모임에서 회장을 선출하려고 한다.
회원 사이에 서로 모르는 사람도 있지만, 몇 사람을 통하면 모두가 서로 알 수 있다. 각 회원은 다른 회원들과 가까운 정도에 따라 점수를 받게 된다.
어느 회원이 다른 모든 회원과 친구이면, 이 회원의 점수는 1점이다.
어느 회원의 점수가 2점이면, 다른 모든 회원이 친구이거나 친구의 친구임을 말한다
회장은 회원들 중에서 점수가 가장 작은 사람이 된다. 회장의 점수와 회장이 될 수 있는 모든 사람을 찾는 프로그램을 작성하시오.

 */
