package boj.BarkingDog_Collection.Hash;

// 문자열 지옥에 빠진 호석 골드4
import java.io.*;
import java.util.*;
public class BOJ20166 {
    static int [] arx = {-1,1,0,0,-1,1,-1,1};
    static int [] ary = {0,0,-1,1,-1,-1,1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String [][] map = new String[n][m];
        for (int i = 0; i < n ; i++) {
            String input = br.readLine()
;            for (int j = 0; j < m; j++) {
                map[i][j] = Character.toString(input.charAt(j));
            }
        }
        HashMap<String, Integer> memo = new HashMap<>();
        Queue<Object [] > q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                String cur = map[i][j];
                q.add(new Object[]{i, j, cur});
                while (!q.isEmpty()){
                    Object [] temp = q.poll();
                    System.out.println(Arrays.toString(temp));
                    String check = (String) temp[2];
                    memo.put(check, memo.getOrDefault(check, 0) + 1);
                    if(check.length() == 5) continue;
                    for (int l = 0; l < 8; l++) {
                        int nx = (int)temp[0] + arx[l];
                        int ny = (int)temp[1] + ary[l];
                        if(0 <= nx && 0 <= ny && nx < n && ny < m){
                            q.add(new Object[]{nx,ny, check + map[nx][ny]});
                        }
                        else{
                            // 대각선 4개
                            if(nx == -1 && ny == -1){
                                nx = n - 1;
                                ny = m - 1;
                            }
                            else if(nx == n && ny == m){
                                nx = 0;
                                ny = 0;
                            }
                            else if(nx == -1 && ny == m){
                                nx = n - 1;
                                ny = 0;
                            }
                            else if(nx == n && ny == -1){
                                nx = 0;
                                ny = m - 1;
                            }
                            else{
                                if(nx == -1){
                                    nx = n - 1;
                                }
                                else if(nx == n){
                                    nx = 0;
                                }
                                else if(ny == -1){
                                    ny = m - 1;
                                }
                                else if(ny == m){
                                    ny = 0;
                                }
                            }
                            q.add(new Object[]{nx,ny, check + map[nx][ny]});
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (k-->0){
            String input = br.readLine();
            sb.append(memo.getOrDefault(input, 0)).append("\n");
        }
        System.out.println(sb);
    }
}
