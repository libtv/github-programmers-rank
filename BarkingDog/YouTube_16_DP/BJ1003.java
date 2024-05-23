package BarkingDog.YouTube_16_DP;


import java.util.Scanner;

// https://www.acmicpc.net/problem/1003
// 피보나치 함수 실버3
public class BJ1003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] DP = new int[41][2];
        DP[0][0] = 1;
        DP[0][1] = 0;
        DP[1][0] = 0;
        DP[1][1] = 1;
        DP[2][0] = 1;
        DP[2][1] = 1;
        for (int i = 3; i <= 40; i++) {
            DP[i][0] = DP[i-2][0] + DP[i-1][0];
            DP[i][1] = DP[i-2][1] + DP[i-1][1];
        }
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            System.out.println(DP[temp][0] + " " + DP[temp][1]);
        }
    }
}
/*
DP[K][0] = K번째에 0이 출력되는 횟수
DP[K][1] = K번째에 1이 출력되는 함수

fibo(2)는
return fibo(1) + fibo(0)

fibo(3)
return fibo(2) + fibo(1)

점화식을 세우면
DP[K][0] = DP[

 */