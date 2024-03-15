package BarkingDog.YouTube_28_Floyd;

import java.io.*;
import java.util.*;
// 플로이드 골드4
public class BJ11404 {

    static final int max = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int [][] info = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j){
                    info[i][j] = 0;
                }
                else{
                    info[i][j] = max;
                }
            }
        }
        for (int i = 0; i < m ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end   = Integer.parseInt(st.nextToken());
            int cost  = Integer.parseInt(st.nextToken());
            info[start][end] = Math.min(info[start][end], cost);
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    info[i][j] = Math.min(info[i][j], info[i][k] + info[k][j]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(info[i][j] == max){
                    info[i][j] = 0;
                }
                sb.append(info[i][j]).append(" ");

            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
/*
n(2 ≤ n ≤ 100)개의 도시가 있다. 그리고 한 도시에서 출발하여 다른 도시에 도착하는 m(1 ≤ m ≤ 100,000)개의 버스가 있다.
각 버스는 한 번 사용할 때 필요한 비용이 있다.
모든 도시의 쌍 (A, B)에 대해서 도시 A에서 B로 가는데 필요한 비용의 최솟값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 도시의 개수 n이 주어지고 둘째 줄에는 버스의 개수 m이 주어진다. 그리고 셋째 줄부터 m+2줄까지 다음과 같은 버스의 정보가 주어진다. 먼저 처음에는 그 버스의 출발 도시의 번호가 주어진다.
버스의 정보는 버스의 시작 도시 a, 도착 도시 b, 한 번 타는데 필요한 비용 c로 이루어져 있다.
시작 도시와 도착 도시가 같은 경우는 없다. 비용은 100,000보다 작거나 같은 자연수이다.
시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있다.
 */
/*
   꿀팁 1
   info[i][j] = Math.min(info[i][j], info[i][k] + info[k][j]);
   이렇게 하는것보다
   if(info[i][j] > info[i][k] + info[k][j]) 일때만 대입을 하는게 연산적으로 빠르다

   꿀팁 2
   플로이드 알고리즘은 정점이 1000개까지만 가능한 경우가 많다.
   1000 * 1000 * 1000 은 10억이라는 숫자지만 단순 대입 연산이기 때문에 통과할 가능성이 있다.

 */