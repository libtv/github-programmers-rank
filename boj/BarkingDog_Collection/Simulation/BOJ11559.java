package boj.BarkingDog_Collection.Simulation;

// Puyo Puyo 골드4
import java.util.*;
import java.io.*;
public class BOJ11559 {
    static int [][] map = new int[12][6]; static int answer;
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 12 ; i++) {
            String [] temp = br.readLine().split("");
            for (int j = 0; j < 6 ; j++) {
                String input = temp[j];
                if(input.equals("Y")) map[i][j] = 1;
                else if(input.equals("R")) map[i][j] = 2;
                else if(input.equals("G")) map[i][j] = 3;
                else if(input.equals("P")) map[i][j] = 4;
                else if(input.equals("B")) map[i][j] = 5;
            }
        }
        BFS();
        System.out.println(answer);
    }
    public static void BFS(){
        Queue<int []> q = new LinkedList<>();
        while (true){
            boolean [][] visited = new boolean[12][6];
            boolean flag = false;
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if(map[i][j] != 0 && !visited[i][j]){
                        int color = map[i][j];
                        visited[i][j] = true;
                        q.add(new int[]{i,j});
                        ArrayList<int []> list = new ArrayList<>();
                        list.add(new int[]{i,j});
                        while (!q.isEmpty()){
                            int [] temp = q.poll();
                            for (int k = 0; k < 4 ; k++) {
                                int nx = temp[0] + arx[k];
                                int ny = temp[1] + ary[k];
                                if(validation(nx,ny) && !visited[nx][ny] && map[nx][ny] == color){
                                    visited[nx][ny] = true;
                                    q.add(new int[]{nx,ny});
                                    list.add(new int[]{nx,ny});
                                }
                            }
                        }
                        if(list.size() < 4) continue;
                        flag = true;
                        for (int [] target: list) {
                            map[target[0]][target[1]] = 0;
                        }
                    }
                }
            }
            if(!flag) break;
            answer++;
            update();
        }
    }
    public static boolean validation(int nx , int ny){
        if(0 <= nx && 0 <= ny && nx < 12 && ny < 6) return true;
        else return false;
    }
    public static void update(){
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 6; i++) {
            for (int j = 11; j >= 0; j--) {
                if(map[j][i] == 0) continue;
                q.add(map[j][i]);
            }
            int size = q.size();
            int cnt = 11;
            for (int j = 0; j < size; j++) {
                map[cnt][i] = q.poll();
                cnt--;
            }
            for (int j = cnt; j >=0 ; j--) {
                map[j][i] = 0;
            }
        }
    }
}
