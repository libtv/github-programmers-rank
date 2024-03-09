package org.example.boj.BarkingDog_Collection.BFS;

// 확장 게임 골드2
import java.io.*;
import java.util.*;
public class BOJ16920_TimeOut {
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st; st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long [] limit = new long[p+1];
        for (int i = 1; i <= p; i++) {
            limit[i] = Long.parseLong(st.nextToken());
        }
        int [][] map = new int[n][m];
        Deque<int[]>[] q = new LinkedList[p];
        for (int i = 0; i < n ; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                char target = input.charAt(j);
                if(target == '.') continue;
                if(target == '#') map[i][j] = -1;
                else{
                    map[i][j] = target - '0';
                }
            }
        }
        for (int i = 0; i < p ; i++) {
            q[i] = new LinkedList<>();
        }
        int [] answer = new int[p+1];
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                if(map[i][j] == -1) continue;
                if(map[i][j] == 0){
                    for (int k = 0; k < p ; k++) {
                        q[k].add(new int[] {i,j});
                    }
                }
                else{
                    answer[map[i][j]]++;
                }
            }
        }
        while (true){
            int count = 0;
            for (int i = 0; i < p ; i++) {
                Deque<int []> temp = q[i];
                boolean[][] visited2 = new boolean[n][m];
                if(limit[i+1] == 0) continue;               // 확장 불가
                ArrayList<int []> list = new ArrayList<>();
                while (!temp.isEmpty()){
                    int [] check = temp.pollFirst();
                    if(visited2[check[0]][check[1]]){
                        temp.addLast(check);
                        break;
                    }
                    if(map[check[0]][check[1]]!= 0) continue; // 이미 확장
                    visited2[check[0]][check[1]] = true;


                    boolean can = false;
                    boolean [][] visited3 = new boolean[n][m];
                    Queue<int[]> test = new LinkedList<>();
                    test.add( new int[]{check[0], check[1], 0});
                    visited3[check[0]][check[1]] = true;
                    boolean flag = false;
                    while (!test.isEmpty()){
                        int [] out = test.poll();
                        for (int j = 0; j < 4; j++) {
                            int nx = out[0] + arx[j];
                            int ny = out[1] + ary[j];
                            if(0 <= nx && 0 <= ny && nx < n && ny < m){
                                if(!visited3[nx][ny]){
                                    visited3[nx][ny] = true;
                                    if(map[nx][ny] == i + 1){
                                        can = true;
                                        test.clear();
                                        if(out[2] <= limit[i+1]){
                                            flag = true;
                                        }
                                        break;
                                    }
                                    else if(map[nx][ny] == 0){
                                        test.add(new int[]{nx,ny,out[2] + 1});
                                    }
                                }
                            }
                        }
                    }
                    if(!can) continue;
                    if(flag){
                        list.add(new int[]{check[0], check[1]});
                        count++;
                    }
                    else temp.addLast(check);
                }
                for(int [] out : list){
                    map[out[0]][out[1]] = i + 1;
                    answer[i+1]++;
                }
            }
            if(count == 0) break;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= p ; i++) {
            sb.append(answer[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
거리는 충분한데 다음 진행할곳이 없다면 이 친구는 평생 도달 x

 */