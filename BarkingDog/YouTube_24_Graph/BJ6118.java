package BarkingDog.YouTube_24_Graph;

import java.io.*;
import java.util.*;

// 숨바꼭질 실버1
public class BJ6118 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String [] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        ArrayList<Integer>[] list = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        while (m-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        int [] memo = new int[n+1];
        Queue<Play> q = new LinkedList<>();
        q.add(new Play(1, 0));
        while (!q.isEmpty()){
            Play play = q.poll();
            int cur = play.cur;
            int depth = play.depth;
            int size = list[cur].size();
            for (int i = 0; i < size; i++) {
                int next = list[cur].get(i);
                if(memo[next] == 0 && next !=1){
                    memo[next] = depth + 1;
                    q.add(new Play(next, depth + 1));
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, memo[i]);
        }
        int count = 0;
        boolean first = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
             if(max == memo[i]){
                 if(first){
                     sb.append(i).append(" ").append(max).append(" ");
                     first = false;
                 }
                 count++;
             }
        }
        sb.append(count);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
class Play {
    int cur, depth;
    public Play(int cur, int depth){
        this.cur = cur;
        this.depth = depth;
    }
}
/*
헛간의 개수는 N(2 <= N <= 20,000)개이며, 1 부터 샌다고 하자.
재서기는 수혀니가 1번 헛간부터 찾을 것을 알고 있다. 모든 헛간은 M(1<= M <= 50,000)개의 양방향 길로 이어져 있고
재서기는 발냄새가 지독하기 때문에 최대한 냄새가 안나게 숨을 장소를 찾고자 한다. 냄새는 1번 헛간에서의 거리(여기서 거리라 함은 지나야 하는 길의 최소 개수이다)가 멀어질수록 감소한다고 한다.
재서기의 발냄새를 최대한 숨길 수 있는 헛간을 찾을 수 있게 도와주자!
 */