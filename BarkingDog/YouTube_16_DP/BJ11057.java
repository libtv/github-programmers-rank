package BarkingDog.YouTube_16_DP;

import java.util.Scanner;

// 오르막 수 실버1
public class BJ11057 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long DP [][] = new long[N+1][10]; // 0 ~ 9
        for (int i = 0; i < 10; i++) {
            DP[1][i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                long temp = DP[i-1][j];
                for (int k = j; k < 10; k++) {
                    DP[i][k] = (DP[i][k] + temp);
                    DP[i][k] %= 10007;
                }
            }
        }
        long sum = 0;
        for (int i = 0; i < 10 ; i++) {
            sum = sum + DP[N][i];
            sum %= 10007;
        }
        System.out.println(sum);
    }
}
/*
오르막 수는 수의 자리가 오름차순을 이루는 수를 말한다. 이때, 인접한 수가 같아도 오름차순으로 친다.
예를 들어, 2234와 3678, 11119는 오르막 수이지만, 2232, 3676, 91111은 오르막 수가 아니다.
오르막 수의 개수를 구하는 프로그램을 작성하시오. 수는 0으로 시작할 수 있다.

입력
첫째 줄에 N (1 ≤ N ≤ 1,000)이 주어진다.

출력
첫째 줄에 길이가 N인 오르막 수의 개수를 10,007로 나눈 나머지를 출력한다.
 */

/*
계속 오버플로우 발생으로 틀렸지만 2부분에서 10007로 나누니까 해결
1. DP 배열의 값을 갱신할 때
2. 최종 결과값 출력 계산 값에서
 */