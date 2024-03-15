package BarkingDog.YouTube_9_BFS;

// https://www.acmicpc.net/problem/2573
// 2573 빙산 골드4
import java.util.*;
import java.io.*;
public class BJ2573 {
    static int[] arx = {-1,1,0,0};
    static int[] ary = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 한 덩어리의 빙산이 주어질 때, 이 빙산이 두 덩어리 이상으로 분리되는 최초의 시간(년)을 구하는 프로그램을 작성하시오.
        // 만일 전부 다 녹을 때까지 두 덩어리 이상으로 분리되지 않으면 프로그램은 0을 출력한다.

        // 빙산 녹이는 큐 1개 // 1년이 지나면 검사 한번 <- 메서드

        String[] split1 = br.readLine().split(" ");
        int A = Integer.parseInt(split1[0]);
        int B = Integer.parseInt(split1[1]);

        int[][] iceberg = new int[A][B]; // 빙산
        boolean[][] check = new boolean[A][B]; // 들렸던 곳인지?
        int[][] check2 = new int[A][B]; // 주변 바다의 숫자
        Queue<Next> q = new LinkedList<>();

        boolean one = false;

        for (int i = 0; i < A ; i++) {
            String[] split2 = br.readLine().split(" ");
            for (int j = 0; j < B ; j++) {
                int temp = Integer.parseInt(split2[j]);
                iceberg[i][j] = temp;
                if(!one && temp >= 1){
                    q.offer(new Next(i,j));
                    one = true;
                    check[i][j] = true;
                }
                if(temp == 0){
                    check[i][j] = true;
                }
            }
        }
        // System.out.println(Arrays.deepToString(iceberg));

        int cnt = 1;
        boolean end = false;

        while (!end){
            // 주변 빙산 찾는 bfs
            while (!q.isEmpty()){
                Next next = q.poll();
                int x = next.x;
                int y = next.y;
                for (int i = 0; i < 4 ; i++) {
                    int temp_x = x + arx[i];
                    int temp_y = y + ary[i];
                    if(0 <= temp_x && 0 <= temp_y && temp_x < A && temp_y < B){
                        if(iceberg[temp_x][temp_y] == 0){
                            check2[x][y]++;
                        }
                        else if(iceberg[temp_x][temp_y]!=0 && !check[temp_x][temp_y]){
                            check[temp_x][temp_y] = true;
                            q.offer(new Next(temp_x,temp_y));
                        }
                    }
                }
            }

            // 빙산 빼주기
            for (int i = 0; i < A; i++) {
                for (int j = 0; j < B; j++) {
                    iceberg[i][j] = iceberg[i][j] - check2[i][j];
                    if(iceberg[i][j] < 0){
                        iceberg[i][j] = 0;
                    }

                }
            }
            System.out.println(Arrays.deepToString(iceberg));

            int plz = find(iceberg);
            if(plz == 0){ // 다 녹았다.
                System.out.println(0);
                break;
            }
            else if(plz == 2){ // 빙산이 2개 이상
                System.out.println(cnt);
                break;
            }
            else{ // 빙산이 1개 다시

                cnt = cnt + 1; // 1년 추가

                boolean once = false;

                for (int i = 0; i < A; i++) {
                    for (int j = 0; j <B ; j++) {
                         int temp = iceberg[i][j];
                         if(!once && temp >= 1){
                            q.offer(new Next(i,j));
                            once = true;
                            check[i][j] = true;
                         }
                         else if(temp >= 1){
                             check[i][j] = false;
                         }

                         if(temp == 0){
                             check[i][j] = true;
                         }
                         check2[i][j] = 0;
                    }
                }
                once = false;

            }
        }

    }
    public static int find(int[][]iceberg){
        int count = 0;
        Queue<Next> next = new LinkedList<>();

        int A = iceberg.length;
        int B = iceberg[0].length;

        int[][] icebergCopy = new int[A][B]; // 원본 배열의 복사본 생성
        for (int i = 0; i < A; i++) {
            icebergCopy[i] = Arrays.copyOf(iceberg[i], B); // 배열의 각 행 복사
        }

        // System.out.println(Arrays.deepToString(icebergCopy));

        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {
                if(icebergCopy[i][j]!=0){
                    count++;
                    next.offer(new Next(i,j));
                    icebergCopy[i][j] = 0;
                    while (!next.isEmpty()){
                        Next next1 = next.poll();
                        int x = next1.x;
                        int y = next1.y;
                        for (int k = 0; k < 4 ; k++) {
                            int temp_x = x + arx[k];
                            int temp_y = y + ary[k];
                            if(0 <= temp_x && 0 <= temp_y && temp_x < A && temp_y < B){
                                if(icebergCopy[temp_x][temp_y]!=0){
                                    icebergCopy[temp_x][temp_y] = 0;
                                    next.offer(new Next(temp_x, temp_y));
                                }
                            }
                        }
                    }
                }
            }
        }
        if(count == 1){
            return 1;
        }
        else if(count == 0){
            return 0;
        }
        else{
            return 2;
        }
    }

}
class Next{
    int x;
    int y;
    public Next(int x, int y){
        this.x = x;
        this.y = y;
    }
}

