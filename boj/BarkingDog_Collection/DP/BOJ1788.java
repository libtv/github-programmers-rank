package boj.BarkingDog_Collection.DP;

import java.util.Scanner;

// 피보나치 수의 확장 실버3
public class BOJ1788 {
    static final long INF = 1000000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        if(input == 0){
            sb.append(0).append("\n");
            sb.append(0);
        }
        else if(input >= 1){ // 양수
            long [] DP = new long[input+1];
            DP[1] = 1;
            for (int i = 2; i <= input; i++) {
                DP[i] = (DP[i-2] + DP[i-1]) % INF;
            }
            sb.append(1).append("\n");
            sb.append(DP[input]);
        }
        else{ // 음수
            long [] DP = new long[-input + 1];
            DP[1] = 1;
            for (int i = 2; i <= -input; i++) {
                DP[i] = ( DP[i-2] - DP[i-1] ) % INF;
            }
            if(DP[-input] < 0){
                sb.append(-1).append("\n");
            }
            else if(DP[-input] == 0){
                sb.append(0).append("\n");
            }
            else sb.append(1).append("\n");
            sb.append(Math.abs(DP[-input]));
        }
        System.out.println(sb);
    }
}
/*
F(1)  = F(0)  + F(-1)
F(-1) = 1

F(0) = F(-1) + F(-2)
F(-2) = F(0) - F(-1)

F(-1) = F(-2) + F(-3)
F(-3) = F(-1) - F(-2)


 */
