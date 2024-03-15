package BarkingDog.YouTube_16_DP;

import java.io.*;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2302
// 극장 좌석 실버1
public class BJ2302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int [] DP = new int[n+1];
        int num = Integer.parseInt(br.readLine());
        int [] vip = new int[num];

        for (int i = 0; i < num; i++) {
            vip[i] = Integer.parseInt(br.readLine());
        }
        DP[0] = 1;
        DP[1] = 1;
        for (int i = 2; i <= n; i++) {
            DP[i] = DP[i-1] + DP[i-2];
        }
        // System.out.println(Arrays.toString(DP));
        int start = 0;
        int answer = 1;
        for (int i = 0; i < num; i++) {
            int end = vip[i];
            answer *= DP[end - start - 1];
            start = end;
        }
        // 마지막  고정된 좌석 이후 계산
        answer *= DP[n-start];
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
어떤 극장의 좌석은 한 줄로 되어 있으며 왼쪽부터 차례대로 1번부터 N번까지 번호가 매겨져 있다.
입장권에 5번이 쓰여 있으면 5번 좌석에 앉아야 한다. 단, 자기의 바로 왼쪽 좌석 또는 바로 오른쪽 좌석으로는 자리를 옮길 수 있다.
“VIP 회원”들이 있다. 이 사람들은 반드시 자기 좌석에만 앉아야 하며 옆 좌석으로 자리를 옮길 수 없다.
오늘 공연은 입장권이 매진되어 1번 좌석부터 N번 좌석까지 모든 좌석이 다 팔렸다.
VIP 회원들의 좌석 번호들이 주어졌을 때, 사람들이 좌석에 앉는 서로 다른 방법의 가짓수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에는 좌석의 개수 N이 입력된다.
N은 1 이상 40 이하이다.
둘째 줄에는 고정석의 개수 M이 입력된다. M은 0 이상 N 이하이다.
다음 M 개의 줄에는 고정석의 번호가 작은 수부터 큰 수의 순서로 한 줄에 하나씩 입력된다.

방법의 가짓수는 2,000,000,000을 넘지 않는다.
 */

/* 문제 접근
예제 입력을 분석하자.
9
2
4
7

1 2 3 vip4 5 6 vip7 8 9

DP[1] = 2  1 or 2
DP[2] = 3  1 or 2 or 3
DP[3] = 2  2 or 3
DP[4] = 1
DP[5] = 2  5 or 6
DP[6] = 2  5 or 6
DP[7] = 1
DP[8] = 2  8 or 9
DP[9] = 2  8 or 9

if(2)
조합관점으로 보면 DP[2] = 3   3 * 2 * 1  나머지는 경우의 수가 2니까 3 * 2 * 1 * 2 = 12

VIP석 없이 배치할 경우의 수는?
D[K] = D[K-1] + D[K-2]

그렇다면

1  2  3  4가 vip 5  6  7vip 8  9
그럼 정답은 DP[3] ( 1, 2, 3)  * DP[2] ( 5, 6 ) * DP[2] ( 8, 9 ) = 12

 */