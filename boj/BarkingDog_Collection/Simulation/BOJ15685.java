package boj.BarkingDog_Collection.Simulation;

// 드래곤 커브 골드3
import java.util.*;
import java.io.*;
public class BOJ15685 {
    static int [][] map = new int[101][101];
    static int [] arx ={0,-1,0,1};
    static int [] ary ={1,0,-1,0};
    static int [] check_x ={0,1,1};
    static int [] check_y ={1,0,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (n-->0){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            // 0 오른쪽 1: 위로 2 : 왼쪽 3 : 아래로
            map[x][y] = 1;
            Queue<int []> q = new LinkedList<>();    // 좌표를 기억하긴 위한 q
            int cnt = 0;    // 세대를 저장하는 cnt
            Deque<Integer> dq = new LinkedList<>();  // 방향을 저장하는 dq
            q.add(new int[]{x,y});
            dq.add(d);
            while (cnt <= g){
                if(cnt == 0){
                    int [] temp = q.poll();
                    int nx = temp[0] + arx[dq.peek()];
                    int ny = temp[1] + ary[dq.peek()];
                    map[nx][ny] = 1;
                    q.add(new int[]{nx,ny});
                }
                else if(cnt == 1){
                    int [] temp = q.poll();
                    int nx = temp[0];
                    int ny = temp[1];
                    if(dq.peek() == 0){
                        dq.addLast(1);
                    }
                    else if(dq.peek() == 1){
                        dq.addLast(2);
                    }
                    else if(dq.peek() == 2){
                        dq.addLast(3);
                    }
                    else if(dq.peek() == 3){
                        dq.addLast(0);
                    }
                    nx += arx[dq.peekLast()];
                    ny += ary[dq.peekLast()];
                    map[nx][ny] = 1;
                    q.add(new int[]{nx,ny});
                }
                else{
                    int check = dq.size() / 2;
                    Deque<Integer> temp = new LinkedList<>();
                    for (int i = 0; i < check; i++) {
                        int direction = dq.pollFirst();
                        int original = direction;
                        if(direction == 0){
                            direction = 2;
                        }
                        else if(direction == 1){
                            direction = 3;
                        }
                        else if(direction == 2){
                            direction = 0;
                        }
                        else if(direction == 3){
                            direction = 1;
                        }
                        int [] get = q.poll();
                        int nx = get[0] + arx[direction];
                        int ny = get[1] + ary[direction];
                        map[nx][ny] = 1;
                        q.add(new int[]{nx,ny});
                        dq.addLast(original);
                        temp.addLast(direction);
                    }
                    for (int i = 0; i < check; i++) {
                        int direction = dq.pollFirst();
                        int [] get = q.poll();
                        int nx = get[0] + arx[direction];
                        int ny = get[1] + ary[direction];
                        map[nx][ny] = 1;
                        q.add(new int[]{nx,ny});
                        dq.addLast(direction);
                        temp.addLast(direction);
                    }
                    while (!temp.isEmpty()){
                        dq.addLast(temp.pollFirst());
                    }
                }
                cnt++;
            }
        }
        int count = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100 ; j++) {
                if(map[i][j] == 1){
                    boolean flag = true;
                    for (int k = 0; k < 3 ; k++) {
                        int nx = i + check_x[k];
                        int ny = j + check_y[k];
                        if(0 <= nx && 0 <= ny && nx <= 100 && ny <= 100){
                            if(map[nx][ny] == 0){
                                flag = false;
                                break;
                            }
                        }
                        else flag = false;
                    }
                    if(flag) count++;
                }
            }
        }
        System.out.println(count);
    }
}
/*
0      1     2           3
오른쪽  위로   왼쪽 위로    왼쪽 아래로 왼쪽 위로


2 7 3 4  드래곤 커브

시작점 (7, 2) 방향 아래로

0          1           2               3                             4
아래로      오른쪽       위로 오른쪽      위로 왼쪽 위로 오른쪽    위로 왼쪽 아래로 왼쪽 위로 왼쪽 위로 오른쪽



 */