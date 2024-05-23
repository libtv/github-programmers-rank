package boj.BarkingDog_Collection.DP;
// 1로 만들기 2 실버1
import java.util.Scanner;
public class BOJ12852 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] DP = new int[n+1];
        DP[1] = 0;
        int [] memo = new int[n+1];
        for (int i = 2; i <= n; i++) {
            DP[i] = DP[i-1] + 1;
            memo[i] = i - 1;
            if(i % 2 == 0 && DP[i] > DP[i/2] + 1){
                DP[i] = DP[i/2] + 1;
                memo[i] = i/2;
            }
            if(i % 3 == 0 && DP[i] > DP[i/3] + 1){
                DP[i] = DP[i/3] + 1;
                memo[i] = i/3;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(DP[n]).append("\n");
        int start = n;
        sb.append(n).append(" ");
        while (start != 1){
            sb.append(memo[start]).append(" ");
            start = memo[start];
        }
        System.out.println(sb);
    }
}
