package BarkingDog.YouTube_9_BFS;

// https://www.acmicpc.net/problem/5014
// 스타트링크 실버1

import java.util.*;
import java.io.*;
public class BJ5014 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 스타트링크는 총 F층으로 이루어진 고층 건물에 사무실이 있고,
        // 스타트링크가 있는 곳의 위치는 G층이다
        // 강호가 지금 있는 곳은 S층이고, 이제 엘리베이터를 타고 G층으로 이동하려고 한다.
        // 강호가 탄 엘리베이터는 버튼이 2개밖에 없다. 왜?
        // U버튼은 위로 U층을 가는 버튼, D버튼은 아래로 D층을 가는 버튼이다.
        // (만약, U층 위, 또는 D층 아래에 해당하는 층이 없을 때는, 엘리베이터는 움직이지 않는다)
        // 강호가 G층에 도착하려면, 버튼을 적어도 몇 번 눌러야 하는지 구하는 프로그램을 작성하시오.
        // 만약, 엘리베이터를 이용해서 G층에 갈 수 없다면, "use the stairs"를 출력한다.

        // 첫째 줄에 F, S, G, U, D가 주어진다.
        // (1 ≤ S, G ≤ F ≤ 1000000, 0 ≤ U, D ≤ 1000000) 건물은 1층부터 시작하고, 가장 높은 층은 F층이다.

        String[] split = br.readLine().split(" ");
        int F = Integer.parseInt(split[0]); // 건물 높이
        int S = Integer.parseInt(split[1]); // 현재 위치
        int G = Integer.parseInt(split[2]); // 스타트링크 위치
        int U = Integer.parseInt(split[3]); // up
        int D = Integer.parseInt(split[4]); // down
        int [] map = new int[F+1]; // 건물은 1층부터 시작한다.

        // 항상 기억
        boolean first = false;
        if(S==G){
            first = true;
        }

        Queue<Integer> q = new LinkedList<>();
        map[S] = 1;
        map[G] = 2;
        q.offer(S);
        int check = 0;
        int update = q.size();
        int cnt = 1;
        boolean end = false;
        while (!q.isEmpty()){
            int x = q.poll();
            check++;
            for (int i = 0; i < 2; i++) {
                if(i==0){ // U
                    x += U;
                    if( 1 <= x && x < F + 1){
                        if(map[x] == 2){
                            end = true;
                            q.clear();
                            break;
                        }
                        else if(map[x] != 1){
                            q.offer(x);
                            map[x] = 1;
                        }
                    }
                    x -= U;
                }
                else if(i==1){ // D
                    x -= D;
                    if( 1 <= x && x < F + 1){
                        if(map[x] == 2){
                            end = true;
                            q.clear();
                            break;
                        }
                        else if(map[x] != 1){
                            q.offer(x);
                            map[x] = 1;
                        }
                    }
                    x += D;
                }
            }
            if(check == update && !end){
                cnt++;
                check = 0;
                update = q.size();
            }
        }

        // 출력
        if(first){
            System.out.println(0);
        }
        else if(end){
            System.out.println(cnt);
        }
        else{
            System.out.println("use the stairs");
        }
    }
}
