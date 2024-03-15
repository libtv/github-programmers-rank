package boj.BarkingDog_Collection.BFS;

// 열쇠 골드1
import java.io.*;
import java.util.*;
public class BOJ9328 {
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (t-->0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
            char [][] map = new char[n][m];
            for (int i = 0; i < n ; i++) {
                String input = br.readLine();
                for (int j = 0; j < m ; j++) {
                    map[i][j] = input.charAt(j);
                }
            }
            Set<Integer> key = new HashSet<>();
            String input = br.readLine();
            for (int i = 0; i < input.length(); i++) {
                key.add((int)input.charAt(i));
            }
            key.remove("0");
            // 알파벳 대문자는 문 소문자는 열쇠
            int count = 0; // 문서의 개수
            boolean [][] visited = new boolean[n][m];
            Deque<int []> dq = new LinkedList<>();
            for (int i = 0; i < n ; i++) {
                for (int j = 0; j < m; j++) {
                    if(i == 0 || j == 0 || i == n - 1 || j == m - 1){
                        int temp = (int) map[i][j];
                        if(97 <= temp && temp <= 122){
                            key.add(temp);
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(i == 0 || j == 0 || i == n - 1 || j == m - 1){
                        if(map[i][j] == '*') continue;
                        if(map[i][j] == '.'){
                            dq.add(new int []{i,j});
                            visited[i][j] = true;
                        }
                        else if(map[i][j] == '$'){
                            dq.add(new int[]{i,j});
                            visited[i][j] = true;
                            count++;
                        }
                        else{
                            int temp = (int)map[i][j];
                            if(97 <= temp && temp <= 122){ // key
                                dq.add(new int[]{i,j});
                                visited[i][j] = true;
                                key.add(temp);
                            }
                            else if(65 <= temp && temp <= 90){
                                if(key.contains(Integer.valueOf(temp+32))){
                                    visited[i][j] = true;
                                }
                                dq.add(new int[]{i,j});
                            }
                        }
                    }
                }
            }
            int cnt = 0;
            while (!dq.isEmpty()){
                int [] temp = dq.pollFirst();
                int check = (int) map[temp[0]][temp[1]];
                if(65 <= check && check <= 90){ // 문이라면?
                    if(!key.contains(Integer.valueOf(check+ 32))){
                        cnt++;
                        dq.addLast(temp);
                        if(cnt == dq.size()) break;
                        continue;
                    }
                    else{
                        visited[temp[0]][temp[1]] = true;
                    }
                }
                cnt = 0;
                for (int i = 0; i < 4 ; i++) {
                    int nx = temp[0] + arx[i];
                    int ny = temp[1] + ary[i];
                    if(0 <= nx && 0 <= ny && nx < n && ny < m){
                        if(!visited[nx][ny]){
                            if(map[nx][ny] == '*') continue;
                            int ch = (int) map[nx][ny];
                            if(map[nx][ny] == '$'){
                                count++;
                                dq.add(new int[]{nx,ny});
                                visited[nx][ny] = true;
                            }
                            else if(97 <= ch && ch <= 122){ // key라면
                                key.add(ch);
                                dq.add(new int[]{nx,ny});
                                visited[nx][ny] = true;
                            }
                            else if(map[nx][ny] == '.'){
                                dq.add(new int[]{nx,ny});
                                visited[nx][ny] = true;
                            }
                            else{
                                dq.add(new int[]{nx,ny});
                            }
                        }
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}


/*
            System.out.println((int)'a'); // 97
            System.out.println((int)'z'); // 122
            System.out.println((int)'A'); // 65
            System.out.println((int)'Z'); // 90
*/

