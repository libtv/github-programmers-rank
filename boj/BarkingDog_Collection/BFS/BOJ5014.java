package org.example.boj.BarkingDog_Collection.BFS;

// 스타트링크 실버1
import java.io.*;
import java.util.*;
public class BOJ5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken()); // 총 f층 건물
        int s = Integer.parseInt(st.nextToken()); // 강호의 현재 위치
        int g = Integer.parseInt(st.nextToken()); // 스타트 링크 위치
        int u = Integer.parseInt(st.nextToken()); // up
        int d = Integer.parseInt(st.nextToken()); // down
        int [] map = new int[f+1];
        Arrays.fill(map, -1 );
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        map[s] = 0;
        while (!q.isEmpty()){
            int cur = q.poll();
            for (int i = 0; i < 2 ; i++) {
                int nx = cur;
                if(i == 0 ){
                    nx += u;
                }
                else if(i == 1){
                    nx -= d;
                }
                if(0 < nx && nx < f + 1){
                    if(map[nx] == -1){
                        map[nx] = map[cur] + 1;
                        q.add(nx);
                    }
                }
            }
        }
        System.out.println(map[g] == -1 ? "use the stairs" : map[g]);
    }
}
