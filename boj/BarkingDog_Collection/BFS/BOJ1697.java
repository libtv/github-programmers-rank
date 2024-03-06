package org.example.boj.BarkingDog_Collection.BFS;

// 숨바꼭질 실버1
import java.util.*;
import java.io.*;
public class BOJ1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end   = Integer.parseInt(st.nextToken());
        int [] memo = new int[200001];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        memo[start] = 1;
        while (!q.isEmpty()){
            int cur = q.poll();
            for (int i = 0; i < 3; i++) {
                int nx = cur;
                if( i == 0 ) nx++;
                else if( i == 1) nx--;
                else if( i == 2) nx *= 2;
                if(0 <= nx && nx < 200001){
                    if(memo[nx] == 0){
                        memo[nx] = memo[cur] + 1;
                        q.add(nx);
                    }
                    if(nx == end){
                        q.clear();
                        break;
                    }
                }
            }
        }
        System.out.println(memo[end] - 1);
    }
}
