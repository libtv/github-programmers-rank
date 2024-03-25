package boj.BarkingDog_Collection.Simulation;

// 낚시왕 골드1
import java.io.*;
import java.util.*;

public class BOJ17143 {
    static int r, c, m; static Queue<int[]>[][] map;

    // shark = x좌표 y좌표 속도 이동방향 크기

    // 1 = 위로 2 = 아래로 3 = 오른쪽 4 = 왼쪽
    static int [] arx = {0,-1,1,0,0};
    static int [] ary = {0,0,0,1,-1};
    static int fishing = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new LinkedList[r][c];
        for (int i = 0; i < r ; i++) {
            for (int j = 0; j < c; j++) {
               map[i][j] = new LinkedList<int[]>();
            }
        }
        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            map[x][y].add(new int[]{x,y,s,d,z});
        }
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                if(map[j][i].isEmpty()) continue;
                int [] temp = map[j][i].poll();
                fishing += temp[4];
                break;
            }
            shark_move();
        }
        System.out.println(fishing);
    }
    public static void shark_move(){
        int [][] memo = new int[r][c];
        for (int i = 0; i < r ; i++) {
            for (int j = 0; j < c; j++) {
                memo[i][j] = map[i][j].size();
            }
        }
        for (int i = 0; i < r ; i++) {
            for (int j = 0; j < c; j++) {
                if(memo[i][j] == 0) continue;
                int [] temp = map[i][j].poll();
                int nx = temp[0]; int ny = temp[1];
                for (int k = 0; k < temp[2]; k++) {
                    nx += arx[temp[3]];
                    ny += ary[temp[3]];
                    if(validation(nx,ny)) continue;
                    nx -= arx[temp[3]];
                    ny -= ary[temp[3]];
                    // 방향 바꾸기
                    if(temp[3] == 1) temp[3] = 2;
                    else if(temp[3] == 2) temp[3] = 1;
                    else if(temp[3] == 3) temp[3] = 4;
                    else if(temp[3] == 4) temp[3] = 3;
                    nx += arx[temp[3]];
                    ny += ary[temp[3]];
                }
                temp[0] = nx; temp[1] = ny;
                map[temp[0]][temp[1]].add(temp);
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(map[i][j].size() < 2) continue;
                ArrayList<int[]> list = new ArrayList<>(map[i][j]);
                map[i][j].clear();
                map[i][j].add(list.stream().min((o1, o2) -> -(o1[4] - o2[4])).get());
            }
        }
    }
    public static boolean validation(int nx ,int ny){
        if(0 <= nx && 0 <= ny && nx < r && ny < c) return true;
        else return false;
    }
}
