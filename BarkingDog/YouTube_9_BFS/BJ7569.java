package org.example.BarkingDog.YouTube_9_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/7569
// 토마토 골드5
public class BJ7569 {
    static int[]arx = {-1,1,0,0,0,0}; // 왼쪽 오른쪽 남 북 위 아래
    static int[]ary = {0,0,-1,1,0,0};
    static int[]arz ={0,0,0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 보관 후 하루가 지나면
        // 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
        // 하나의 토마토에 인접한 곳은 위, 아래, 왼쪽, 오른쪽, 앞, 뒤 여섯 방향에 있는 토마토를 의미한다.
        // 토마토들이 며칠이 지나면 다 익게 되는지 그 최소 일수를 알고 싶어 한다.
        // 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고
        // 정수 1은 익은 토마토, 정수 0 은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
        String[] split = br.readLine().split(" ");
        int A = Integer.parseInt(split[1]);
        int B = Integer.parseInt(split[0]);
        int H = Integer.parseInt(split[2]);


        int[][][] box = new int[A][B][H];

        // 익은 토마토 1 익지 않은 토마토 0 -1은 토마토 X

        int cnt = 0;
        int cnt2 = 0;
        Queue<Tomato> q = new LinkedList<>();

        for (int i = 0; i < H; i++) { // 상자의 개수
            for (int j = 0; j < A ; j++) {
                String [] split2 = br.readLine().split(" ");
                for (int k = 0; k < B ; k++) {
                    String temp = split2[k];
                    if(temp.equals("1")){ // 익은 토마토
                        box[j][k][i] = 1;
                        q.offer(new Tomato(j, k, i, 0)); // 0일부터 시작
                        cnt2++;
                    }
                    else if(temp.equals("-1")){ // 빈 상자
                        box[j][k][i] = -1;
                    }
                    else{ // 익지 않은 토마토
                        box[j][k][i] = 0;
                        cnt++;
                    }
                }
            }
        }
        // System.out.println(box[1][2][1]);

        boolean lucky = false;
        if(cnt == 0 && cnt2 > 0){ // 익은 토마토는 있는데 익지 않은 토마토가 없는 경우
            lucky = true;
        }

        boolean lucky2 = false;
        if(cnt > 0 && cnt2 == 0){ // 익지 않은 토마토는 있는데 익은 토마토가 없는 경우
            lucky2 = true;
        }

        int answer = 0;
        while (!q.isEmpty()){
            Tomato tomato = q.poll();
            int x = tomato.x;
            int y = tomato.y;
            int z = tomato.z;
            int day = tomato.day;

            for (int i = 0; i < 6 ; i++) {
                int temp_x = x + arx[i];
                int temp_y = y + ary[i];
                int temp_z = z + arz[i];
                if(0<=temp_x&&0<=temp_y&&0<=temp_z&&temp_x<A&&temp_y<B&&temp_z<H){
                    if(box[temp_x][temp_y][temp_z] == 0){
                        box[temp_x][temp_y][temp_z] = 1;
                        q.offer(new Tomato(temp_x,temp_y,temp_z,day+1));
                    }
                }
            }
            if(q.size() == 0){
                boolean check = false;
                for (int i = 0; i < H; i++) {
                    for (int j = 0; j < A; j++) {
                        for (int k = 0; k < B; k++) {
                            if(box[j][k][i] == 0){
                                check = true;
                                break;
                            }
                        }
                    }
                }
                if(check){
                    answer = -1;
                }
                else{
                    answer = day;
                }
            }
        }
        if(lucky){
            System.out.println(0);
        }
        else if(lucky2){
            System.out.println(-1);
        }
        else{
            System.out.println(answer);
        }
    }
}

class Tomato{
    int x;
    int y;
    int z;
    int day;

    public Tomato(int x, int y, int z, int day){
        this.x = x;
        this.y = y;
        this.z = z;
        this.day = day;
    }

}