package BarkingDog.YouTube_16_DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 스티커 실버1
public class BJ9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T ; i++) {
            int n = Integer.parseInt(br.readLine());
            int [][] map = new int[3][n+1];
            for (int j = 1; j <= 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= n; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            // System.out.println(Arrays.deepToString(map));
            int [][] DP = new int[3][n+1];
            DP[1][1] = map[1][1];
            DP[2][1] = map[2][1];
            for (int j = 2; j <= n; j++) {
                // 위
                int max = 0;
                max = Math.max(DP[2][j-1], DP[1][j-2]);
                max = Math.max(max, DP[2][j-2]);
                DP[1][j] = max + map[1][j];
                // 아래
                max = 0;
                max = Math.max(DP[1][j-1], DP[1][j-2]);
                max = Math.max(max, DP[2][j-2]);
                DP[2][j] = max + map[2][j];
            }
            int max = Math.max(DP[1][n], DP[2][n]);
            bw.write(Integer.toString(max));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
상근이의 여동생 상냥이는 문방구에서 스티커 2n개를 구매했다.
스티커는 그림 (a)와 같이 2행 n열로 배치되어 있다. 상냥이는 스티커를 이용해 책상을 꾸미려고 한다.

스티커 한 장을 떼면, 그 스티커와 변을 공유하는 스티커는 모두 찢어져서 사용할 수 없게 된다.
즉, 뗀 스티커의 왼쪽, 오른쪽, 위, 아래에 있는 스티커는 사용할 수 없게 된다.

모든 스티커를 붙일 수 없게된 상냥이는 각 스티커에 점수를 매기고, 점수의 합이 최대가 되게 스티커를 떼어내려고 한다.
먼저, 그림 (b)와 같이 각 스티커에 점수를 매겼다. 상냥이가 뗄 수 있는 스티커의 점수의 최댓값을 구하는 프로그램을 작성하시오.
 */


/* 퇴사처럼 접근해보는건 어떤가
DP[1][1] = 1열에서 1행 1열을 선택했을 때 최대값 = map[1][1]
DP[2][1] = 1열에서 2행 1열을 선택했을 때 최대값 = map[2][1]


DP[1][2] = 2열에서 1행 2열을 선택했을 때 최대값 = DP[2][1] + map[1][2]
DP[2][1] = 2열에서 2행 2열을 선택했을 때 최대값 = DP[1][1] + map[2][2]





 */
