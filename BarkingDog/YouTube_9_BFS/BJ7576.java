package BarkingDog.YouTube_9_BFS;

// https://www.acmicpc.net/problem/7576
// 토마토 골드5

import java.util.*;
import java.io.*;
public class BJ7576 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
        // 하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다.
        // 철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.
        // 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
        // 여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다.
        // 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.

        String[] split = br.readLine().split(" ");

        int b = Integer.parseInt(split[0]);
        int a = Integer.parseInt(split[1]);

        int[][] box = new int[a][b];

        Queue<ArrayList<Integer>> q = new LinkedList<>();

        for (int i = 0; i < a; i++) {
            String[] split2 = br.readLine().split(" ");
            for (int j = 0; j < b; j++) {
                box[i][j] = Integer.parseInt(split2[j]);
                if(box[i][j] == 1){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    q.offer(temp);
                }
            }
        }

        int[] x = {-1,1,0,0}; // 위 아래
        int[] y = {0,0,-1,1}; // 좌 우

        int day = 0; // 최소 날짜

        int before = q.size();
        int cnt = 0;

        while(!q.isEmpty()){
            ArrayList<Integer> list = q.poll();
            cnt++;
            int startX = list.get(0);
            int startY = list.get(1);
            for (int i = 0; i < 4 ; i++) {
                startX += x[i];
                startY += y[i];
                if(0 <= startX && 0 <= startY && startX < a && startY < b){
                    if(box[startX][startY] == 0){
                        box[startX][startY] = 1;
                        ArrayList<Integer> list2 = new ArrayList<>();
                        list2.add(startX);
                        list2.add(startY);
                        q.offer(list2);
                    }
                }
                startX -= x[i];
                startY -= y[i];
            }
            if(cnt == before){
                day++;
                before = q.size();
                cnt = 0;
            }
        }
        boolean flags = false;
        for (int i = 0; i < a ; i++) {
            boolean flag = false;
            for (int j = 0; j <b; j++) {
                if(box[i][j] == 0){
                    flag = true;
                    break;
                }
            }
            if(flag){
                flags = true;
                break;
            }
        }

        if(flags){
            System.out.println(-1);
        }
        else{
            System.out.println(day-1);
        }


    }
}
