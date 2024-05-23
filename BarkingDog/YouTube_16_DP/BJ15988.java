package BarkingDog.YouTube_16_DP;

import java.io.*;

// https://www.acmicpc.net/problem/15988
// 1,2,3 더하기 3 실버2
public class BJ15988 {

    static final int plz = 1000000009;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        long [] DP = new long[1000001];
        DP[1] = 1;
        DP[2] = 2;
        DP[3] = 4;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            if(DP[num] > 0){
                sb.append(DP[num]);
                sb.append("\n");
            }
            else{
                for (int j = 4; j <= num; j++) {
                    DP[j] = (DP[j-1] + DP[j-2] + DP[j-3]) % plz;
                }
                sb.append(DP[num]);
                sb.append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
/* 문제 설명
정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.
1+1+1+1
1+1+2
1+2+1
2+1+1
2+2
1+3
3+1

정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 1,000,000,009로 나눈 나머지를 출력한다.
 */

/* 문제 접근
DP[1] = 1
1

DP[2] = 2
1+1
2

DP[3] = 4
1+1+1
2+1
1+2
3

DP[4] = 7
1+1+1+1
1+1+2
1+2+1
2+1+1
2+2
1+3
3+1

..

DP[7] = 44

if ?
DP[K] = DP[K-1] + DP[K-2] + DP[K-3];
DP[5] = 7 + 4 + 2 = 13;
DP[6] = 13 + 7 + 4 = 24
DP[7] = 24 + 13 + 7 = 44;
 */