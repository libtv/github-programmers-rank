package boj.BarkingDog_Collection.Simulation;

// 테트로미노 골드4
import java.io.*;
import java.util.*;
public class BOJ14500 {
    static int n, m; static int [][] score; static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        score = new int[n][m];
        for (int i = 0; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        make();
        System.out.println(answer);
    }
    public static void make(){
        check(new int[][]{{1,1},{1,1}});        // 2 * 2 정사각형
        check(new int[][]{{1,1,1,1}});          // 가로 4개 길게
        check(new int[][]{{1},{1},{1},{1}});    // 세로 4개 길게

        check(new int[][]{{0,1,0},{1,1,1}});
        check(new int[][]{{1,1,1},{0,1,0}});
        check(new int[][]{{0,1},{1,1},{0,1}});
        check(new int[][]{{1,0},{1,1},{1,0}});

        check(new int[][]{{1,0},{1,0},{1,1}});
        check(new int[][]{{0,1},{0,1},{1,1}});
        check(new int[][]{{1,1},{0,1},{0,1}});
        check(new int[][]{{1,1},{1,0},{1,0}});
        check(new int[][]{{0,0,1},{1,1,1}});
        check(new int[][]{{1,0,0},{1,1,1}});
        check(new int[][]{{1,1,1},{1,0,0}});
        check(new int[][]{{1,1,1},{0,0,1}});

        check(new int[][]{{1,0},{1,1},{0,1}});
        check(new int[][]{{0,1},{1,1},{1,0}});
        check(new int[][]{{0,1,1},{1,1,0}});
        check(new int[][]{{1,1,0},{0,1,1}});
    }
    public static void check(int [][] arr){
        ArrayList<int []> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 1){
                    list.add(new int[]{i,j});
                }
            }
        }
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m; j++) {
                boolean flag = true;
                int sum = 0;
                for (int [] temp : list) {
                    int nx = i + temp[0];
                    int ny = j + temp[1];
                    if(0 > nx || 0 > ny || nx >= n || ny >= m){
                        flag = false; break;
                    }
                    sum += score[nx][ny];
                }
                if(!flag) continue;
                answer = Math.max(answer, sum);
            }
        }
    }
}
/* CASE

1   1 1 1 1
1
1
1

1 1
1 1

                      1    1
  1      1 1 1      1 1    1 1
1 1 1      1          1    1

1        1      1 1   1 1
1        1        1   1           1   1
1 1    1 1        1   1       1 1 1   1 1 1

1 1 1  1 1 1
1          1


1           1        1 1   1 1
1 1       1 1      1 1       1 1
  1       1

 */

