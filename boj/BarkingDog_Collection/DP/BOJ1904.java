package boj.BarkingDog_Collection.DP;

import java.util.Scanner;

// 01타일 실버3
public class BOJ1904 {
    static final int INF = 15746;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 1 <= n <= 1000000
        if(n == 1){
            System.out.println(1);
            return;
        }
        long [] DP = new long[n+1];
        DP[1] = 1;
        DP[2] = 2;
        for (int i = 3; i <= n; i++) {
            DP[i] = DP[i-2] + DP[i-1];
            DP[i] %= INF;
        }
        System.out.println(DP[n]);
    }
}
/*

DP[1][0] = 길이가 1이고 마지막이 0
DP[1][1] = 길이가 1이고 마지막이 1

1
1

2
00
11

3
001 /
111 /
100 /

4
0000 /
0011 /
1100 /
1111
1001

5
00001 0000 -> 1
10000 100 -> 00
00100 001 -> 00
00111 0001 -> 1
10011
11001 1100 -> 1
11100 111 -> 00
111111

 */