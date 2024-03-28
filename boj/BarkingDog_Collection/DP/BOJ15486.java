package boj.BarkingDog_Collection.DP;

// 퇴사2 골드5
import java.io.*;
public class BOJ15486 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] data = new int[n+1][2];
        for (int i = 1; i <= n ; i++) {
            String[] split = br.readLine().split(" ");
            data[i][0] = Integer.parseInt(split[0]); // 상담 기간
            data[i][1] = Integer.parseInt(split[1]); // 액수
        }
        int [][] DP = new int[n+1][2];
        for (int i = 1; i <= n; i++) {
            int day    = data[i][0];
            int money  = data[i][1];
            if(day == 1){
                DP[i][0] = Math.max(DP[i-1][0] + money, DP[i][1]);
            }
            else{
                if(day + i - 1 <= n && DP[day + i - 1][1] < DP[i-1][0] + money){
                    DP[day + i - 1][1] = DP[i-1][0] + money;
                }
                DP[i][0] = Math.max(DP[i][1], DP[i-1][0]);
            }
        }
        System.out.println(DP[n][0]);
    }
}
