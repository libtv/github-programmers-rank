package BarkingDog.YouTube_16_DP;

import java.io.*;
import java.util.StringTokenizer;

// 카드 구매하기 실버1
public class BJ11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int [] card = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N ; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        // DP[N] = N개를 골랐을 때 최대값
        int [] DP = new int[N+1];
        DP[1] = card[1];
        for (int i = 2; i <= N; i++) {
            int max = card[i];
            int start = 1;
            int end = i-1;
            while (true){
                max = Math.max(DP[start] + DP[end], max);
                if(start >= end){
                    break;
                }
                start++;
                end--;
            }
            DP[i] = max;
        }
        bw.write(Integer.toString(DP[N]));
        bw.flush();
        bw.close();
        br.close();
    }
}
/* 문제 설명

전설카드
레드카드
오렌지카드
퍼플카드
블루카드
청록카드
그린카드
그레이카드

카드는 카드팩의 형태로만 구매할 수 있고, 카드팩의 종류는 카드 1개가 포함된 카드팩, ... 카드 N개가 포함된 카드팩과 같이 총 N가지가 존재한다.
민규는 카드의 개수가 적은 팩이더라도 가격이 비싸면 높은 등급의 카드가 많이 들어있을 것이라는 미신을 믿고 있다.
따라서, 민규는 돈을 최대한 많이 지불해서 카드 N개 구매하려고 한다. 카드가 i개 포함된 카드팩의 가격은 Pi원이다.

카드팩이 총 4가지 종류가 있고, P1 = 1, P2 = 5, P3 = 6, P4 = 7인 경우에 민규가 카드 4개를 갖기 위해 지불해야 하는 금액의 최댓값은 10원이다.

입력
첫째 줄에 민규가 구매하려고 하는 카드의 개수 N이 주어진다. (1 ≤ N ≤ 1,000)
둘째 줄에는 Pi가 P1부터 PN까지 순서대로 주어진다. (1 ≤ Pi ≤ 10,000)
 */
/*
반례
12
1 1 6 8 11 1 1 1 1 1 1 1
ans : 25

card[3] + card[4] + card[5] = 25

 */

