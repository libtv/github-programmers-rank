package boj.BarkingDog_Review;

// 퇴사
import java.util.*;
import java.io.*;
public class BOJ_14_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] DP = new int[n+1][2];
        StringTokenizer st;
        int max = 0;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());

            // 오늘 시작해서 오늘 끝나는 상담
            if(day == 1){
               DP[i][0] = Math.max(DP[i-1][0] + money, DP[i][1]);
            }
            else{
                DP[i][0] = Math.max(DP[i-1][0], DP[i][1]);

                int next = i + day - 1;
                // 날짜가 넘어가는 상담은 제외
                if(next <= n){
                    DP[next][1] = Math.max(DP[i-1][0] + money, DP[next][1]);
                }
            }

            if(max < DP[i][0]){
                max = DP[i][0];
            }
        }
        System.out.println(max);
    }
}
/*

DP[n+1][2]

DP[K][0] = K날까지 끝나는 상담의 최대 금액 -> DP[k][0] = Math.max(DP[k-1][0] + 오늘 시작해서 오늘 끝나는 상담 , DP[k][1]) 이다.
DP[K][1] = 만약 k-2에서 k날에 끝나는 상담이 있다? DP[K][1] = Math.max(DP[k][1], DP[k-3][0] + 해당상담)



 */