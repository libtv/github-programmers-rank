package BarkingDog.YouTube_9_BFS;

import java.util.*;
import java.io.*;
public class BJ2583 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        int A = Integer.parseInt(split[0]);
        int B = Integer.parseInt(split[1]);
        int T = Integer.parseInt(split[2]);

        boolean[][] visited = new boolean[B][A];
        for (int i = 0; i < T; i++) {
            String[] split2 = br.readLine().split(" ");
            int sx = Integer.parseInt(split2[0]);
            int sy = Integer.parseInt(split2[1]);
            int ex = Integer.parseInt(split2[2]);
            int ey = Integer.parseInt(split2[3]);
            for (int j = sx; j < ex ; j++) {
                for (int k = sy; k < ey; k++) {
                    visited[j][k] = true;
                }
            }
        }

        int[]arx = {-1,1,0,0};
        int[]ary = {0,0,-1,1};

        int cnt = 0;
        int answer = 0;
        ArrayList<Integer>list = new ArrayList<>();
        Queue<BFS> q = new LinkedList<>();
        for (int i = 0; i < B ; i++) {
            for (int j = 0; j < A ; j++) {
                if(!visited[i][j]){
                    visited[i][j] = true;
                    cnt++;
                    answer++;
                    q.offer(new BFS(i, j, 1));
                    while (!q.isEmpty()){
                        BFS bfs = q.poll();
                        int x = bfs.x;
                        int y = bfs.y;
                        int count = bfs.cnt;
                        for (int k = 0; k < 4 ; k++) {
                            int temp_x = x + arx[k];
                            int temp_y = y + ary[k];
                            if(0<=temp_x&&0<=temp_y&&temp_x<B&&temp_y<A){
                                if(!visited[temp_x][temp_y]){
                                    visited[temp_x][temp_y] = true;
                                    q.offer(new BFS(temp_x,temp_y, count+1));
                                    answer++;
                                }

                            }
                        }
                        if(q.size()==0){
                            list.add(answer);
                            answer = 0;
                        }
                    }
                }
            }
        }

        System.out.println(cnt);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

    }
}
class BFS{
    int x;
    int y;
    int cnt; // 넓이
    public BFS(int x,int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
/*
[0, 0, 1, 1, 0]
[0, 1, 1, 1, 1]
[0, 0, 1, 1, 0]
[0, 0, 1, 1, 0]
[1, 1, 0, 0, 0]
[1, 1, 0, 0, 0]
[0, 0, 0, 0, 0]
 */

/*
[1, 2, -1, -1, 1]
[2, -1, -1, -1, -1]
[3, 4, -1, -1, 1]
[4, 5, -1, -1, 2]
[-1, -1, 5, 4, 3]
[-1, -1, 6, 5, 4]
[9, 8, 7, 6, 5]
 */