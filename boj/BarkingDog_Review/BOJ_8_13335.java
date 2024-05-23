package boj.BarkingDog_Review;

// 트럭                        시작 10:50 am ~ 11:04 am  14분
import java.util.*;
import java.io.*;
public class BOJ_8_13335 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 트럭의 수
        int w = Integer.parseInt(st.nextToken()); // 다리의 길이
        int l = Integer.parseInt(st.nextToken()); // 다리의 최대 하중
        int [] truck = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            truck[i] = Integer.parseInt(st.nextToken());
        }
        int cur_time = 1;
        int cur_capacity = 0;
        int cnt = 0;
        Queue<int []> q = new LinkedList<>();
        while (!q.isEmpty() || cnt < n){
            if(!q.isEmpty() && q.peek()[1] == cur_time){
                cur_capacity -= q.poll()[0];
            }
            if(cnt < n && truck[cnt] + cur_capacity <= l && q.size() + 1 <= w){
                q.add(new int[]{truck[cnt], cur_time + w});
                cur_capacity += truck[cnt];
                cnt++;
            }
            cur_time++;
        }
        System.out.println(cur_time - 1);
    }
}
/*

다리 길이 w : 2
최대 하중 l : 10
[7, 4, 5, 6]
최단시간 8

--7 4 5 6


1초





 */