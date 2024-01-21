package org.example.BarkingDog.YouTube_13_Simulation;

import java.io.*;
import java.util.Arrays;

// https://www.acmicpc.net/problem/14499
// 주사위 굴리기 골드4
public class BJ14499 {

    static int N;
    static int M;
    static int T;
    static int [][] map ;
    static int [] dice = new int[6];

    static int sx;
    static int sy;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        sx = 0; // 시작 좌표
        sy = 0;
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        sx = Integer.parseInt(split[2]);
        sy = Integer.parseInt(split[3]);
        T = Integer.parseInt(split[4]);

        map = new int[N][M];

        for (int i = 0; i < N ; i++) {
            String[] split2 = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(split2[j]);
            }
        }
        // System.out.println(Arrays.deepToString(map));

        String[] split3 = br.readLine().split(" ");
        for (int i = 0; i < T; i++) {
            func(Integer.parseInt(split3[i]));
        }
        bw.flush();
        bw.close();
        br.close();
    }
    // 동쪽 : 1 서쪽 : 2 북쪽 : 3 남쪽 : 4
    // [동 서 남 북 밑 위] dice[] 6
    public static void func(int direction) throws IOException{
        int nx = sx;
        int ny = sy;
        if(direction == 1){ // 동쪽
             ny += 1;
        }
        else if(direction == 2){ // 서쪽
             ny -= 1;
        }
        else if(direction == 3){ // 북쪽
             nx -= 1;
        }
        else if(direction == 4){ // 남쪽
             nx += 1;
        }
        if(0 <= nx && 0 <= ny && nx < N && ny < M){
            int[] dice2 = new int[6];
            for (int i = 0; i < 6; i++) {
               dice2[i] = dice[i];
            }
            if( direction == 1 ){  // 오른쪽
               // 왼쪽에서 위
               dice[5] = dice2[1];
               // 위에서 오른쪽
               dice[0] = dice2[5];
               // 오른쪽에서 아래
               dice[4] = dice2[0];
               // 아래에서 왼쪽
               dice[1] = dice2[4];
            }
            if (direction == 3){ // 북쪽으로
                dice[5] = dice2[2];
                dice[3] = dice2[5];
                dice[4] = dice2[3];
                dice[2] = dice2[4];
            }
            if ( direction  == 2){
                dice[5] = dice2[0];
                dice[1] = dice2[5];
                dice[4] = dice2[1];
                dice[0] = dice2[4];
            }
            if ( direction == 4){ // 남쪽
                dice[5] = dice2[3];
                dice[2] = dice2[5];
                dice[4] = dice2[2];
                dice[3] = dice2[4];
            }

            if(map[nx][ny] == 0){
                map[nx][ny] = dice[4];
            }
            else{
                dice[4] = map[nx][ny];
                map[nx][ny] = 0;
            }
            bw.write(dice[5] + "\n");
            sx = nx;
            sy = ny;
        }
    }
}
/* 문제 설명
크기가 N×M인 지도가 존재한다. 지도의 오른쪽은 동쪽, 위쪽은 북쪽이다.
이 지도의 위에 주사위가 하나 놓여져 있으며, 주사위의 전개도는 아래와 같다.
지도의 좌표는 (r, c)로 나타내며, r는 북쪽으로부터 떨어진 칸의 개수, c는 서쪽으로부터 떨어진 칸의 개수이다.

주사위는 지도 위에 윗 면이 1이고, 동쪽을 바라보는 방향이 3인 상태로 놓여져 있으며, 놓여져 있는 곳의 좌표는 (x, y) 이다
가장 처음에 주사위에는 모든 면에 0이 적혀져 있다.

지도의 각 칸에는 정수가 하나씩 쓰여져 있다.
주사위를 굴렸을 때, 이동한 칸에 쓰여 있는 수가 0이면, 주사위의 바닥면에 쓰여 있는 수가 칸에 복사된다.
0이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여 있는 수는 0이 된다.

주사위를 놓은 곳의 좌표와 이동시키는 명령이 주어졌을 때, 주사위가 이동했을 때 마다 상단에 쓰여 있는 값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 지도의 세로 크기 N, 가로 크기 M (1 ≤ N, M ≤ 20),
주사위를 놓은 곳의 좌표 x, y(0 ≤ x ≤ N-1, 0 ≤ y ≤ M-1), 그리고 명령의 개수 K (1 ≤ K ≤ 1,000)가 주어진다.

마지막 줄에는 이동하는 명령이 순서대로 주어진다. 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4로 주어진다.

이동할 때마다 주사위의 윗 면에 쓰여 있는 수를 출력한다. 만약 바깥으로 이동시키려고 하는 경우에는 해당 명령을 무시해야 하며, 출력도 하면 안 된다.

 */

/*

[동 서 남 북 위 밑]

오른쪽으로 간다면 ?
왼쪽 -> 위
위 - > 오른쪽
오른쪽 -> 아래
아래 -> 왼쪽
왼쪽으로 간다면 ?   <-
오른쪽 -> 위
위 -> 왼쪽
왼쪽 -> 아래
아래 -> 오른쪽
위로 간다면?
남 -> 위
위 -> 북
북 -> 아래
아래 -> 남
아래로 간다면?
북 -> 위
위 -> 남
남 -> 밑
밑 -> 북
 */