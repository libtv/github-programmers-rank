package BarkingDog.YouTube_28_Floyd;

import java.io.*;
import java.util.*;
// 궁금한 민호 골드2
public class BJ1507 {
    static final int max = 9999999;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int [][] map = new int[n+1][n+1];
        int [][] map2 = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {  // 플로이드를 끝낸 map 입력 받기
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                map2[i][j] = map[i][j];
            }
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(i == j || i == k || j == k) continue;
                    if(map[i][j] > map[i][k] + map[k][j]){
                        System.out.println(-1);
                        return;
                    }
                    if(map[i][j] == map[i][k] + map[k][j]){
                        map2[i][j] = max;
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(map2[i][j] == max || i == j) continue;
                sum += map2[i][j];
            }
        }
        System.out.println(sum / 2);
    }
}
/*
강호는 N개의 도시로 이루어진 나라에 살고 있다. 각 도시는 M개의 도로로 연결되어 있으며,
각 도로를 지날 때 필요한 시간이 존재한다. 도로는 잘 연결되어 있기 때문에, 도시 A에서 B로 이동할 수 없는 경우는 존재하지 않는다.
도시 A에서 도시 B로 바로 갈 수 있는 도로가 있거나, 다른 도시를 거쳐서 갈 수 있을 때, 도시 A에서 B를 갈 수 있다고 한다.
강호는 모든 쌍의 도시에 대해서 최소 이동 시간을 구해놓았다. 민호는 이 표를 보고 원래 도로가 몇 개 있는지를 구해보려고 한다.

예를 들어, 예제의 경우에 모든 도시 사이에 강호가 구한 값을 가지는 도로가 존재한다고 해도 된다.
하지만, 이 도로의 개수는 최솟값이 아니다.
예를 들어, 도시 1-2, 2-3, 1-4, 3-4, 4-5, 3-5를 연결하는 도로만 있다고 가정해도, 강호가 구한 모든 쌍의 최솟값을 구할 수 있다.
이 경우 도로의 개수는 6개이고, 모든 도로의 시간의 합은 55이다.

모든 쌍의 도시 사이의 최소 이동 시간이 주어졌을 때, 이 나라에 존재할 수 있는 도로의 개수의 최솟값일 때, 모든 도로의 시간의 합을 구하는 프로그램을 작성하시오.

첫째 줄에 도로 개수가 최소일 때, 모든 도로의 시간의 합을 출력한다. 불가능한 경우에는 -1을 출력한다.

 */
/*

i = 1 , j = 2, k = 1

i = 1,  j = 2, k = 2

map[1][2] > map[1][1] + map[1][2]

map[1][2] > map[1][2] + map[2][2]

 */