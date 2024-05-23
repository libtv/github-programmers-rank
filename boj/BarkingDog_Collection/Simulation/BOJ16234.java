package boj.BarkingDog_Collection.Simulation;

// 인구 이동 골드4
import java.io.*;
import java.util.*;
public class BOJ16234 {
    static int n,l,r; static int [][] map; static int day;
    static int [] arx ={-1,1,0,0};
    static int [] ary ={0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        BFS();
        System.out.println(day);
    }
    public static void BFS(){
        Queue<int [] > q = new LinkedList<>();
        Queue<int [] > memo = new LinkedList<>();
        while (true){
            boolean [][] visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n ; j++) {
                    if(!visited[i][j]){
                        visited[i][j] = true;
                        ArrayList<int []> list = new ArrayList<>();
                        list.add(new int[]{i, j});
                        q.add(new int[]{i , j});
                        while (!q.isEmpty()){
                            int [] temp = q.poll();
                            for (int k = 0; k < 4 ; k++) {
                                int nx = arx[k] + temp[0];
                                int ny = ary[k] + temp[1];
                                if(0 <= nx && 0 <= ny && nx < n && ny < n){
                                    if(!visited[nx][ny]){
                                        int check = Math.abs(map[temp[0]][temp[1]] - map[nx][ny]);
                                        if(l <= check && check <= r){
                                            visited[nx][ny] = true;
                                            q.add(new int[]{nx, ny});
                                            list.add(new int[]{nx, ny});
                                        }
                                    }
                                }
                            }
                        }
                        if(list.size() > 1){
                            int sum = 0;
                            for (int k = 0; k < list.size(); k++) {
                                int [] out = list.get(k);
                                sum += map[out[0]][out[1]];
                            }
                            sum /= list.size();
                            for (int k = 0; k < list.size(); k++) {
                                int [] out = list.get(k);
                                memo.add(new int[]{out[0], out[1], sum});
                            }
                        }
                    }
                }
            }
            if(memo.isEmpty()){
                return;
            }
            day++;
            while (!memo.isEmpty()){
                int [] temp = memo.poll();
                map[temp[0]][temp[1]] = temp[2];
            }
        }
    }
}
