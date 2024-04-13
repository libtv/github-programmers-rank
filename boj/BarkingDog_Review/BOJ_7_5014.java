package boj.BarkingDog_Review;

// 스타트링크        11:46 시작  11:57 종료
import java.io.*;
import java.util.*;
public class BOJ_7_5014 {
    static final int INF = Integer.MAX_VALUE / 2;
    static int f;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken()); // 스타트링크 건물의 총 높이
        int s = Integer.parseInt(st.nextToken()); // 강호의 위치 == 시작 위치
        int g = Integer.parseInt(st.nextToken()); // 스타트 링크 위치 == 목적지
        int u = Integer.parseInt(st.nextToken()); // + u
        int d = Integer.parseInt(st.nextToken()); // + d
        if(g == s){
            System.out.println(0);
            return;
        }
        int [] memo = new int[f+1];
        Arrays.fill(memo, INF);
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{s, 0});
        while (!q.isEmpty()){
            int [] temp = q.poll();
            // case1 up
            int next_up = temp[0] + u;
            // case2 down
            int next_down = temp[0] - d;
            if(next_up == g || next_down == g){
                System.out.println(temp[1] + 1);
                return;
            }
            if(validation(next_up) && temp[1] + 1 < memo[next_up]){
                memo[next_up] = temp[1] + 1;
                q.add(new int[]{next_up, temp[1] + 1});
            }
            if(validation(next_down) && temp[1] + 1 < memo[next_down]){
                memo[next_down] = temp[1] + 1;
                q.add(new int[]{next_down, temp[1] + 1});
            }
        }
        System.out.println("use the stairs");
    }
    public static boolean validation(int nx){
        if(1 <= nx && nx <= f) return true;
        else return false;
    }
}
