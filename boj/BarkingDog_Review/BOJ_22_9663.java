package boj.BarkingDog_Review;

import java.util.Scanner;

// N-Queen
public class BOJ_22_9663 {
    static int n; static boolean [] col, visited1, visited2;
    static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        col = new boolean[n];
        visited1 = new boolean[n*2-1]; // x + y 대각선
        visited2 = new boolean[n*2-1]; // x - y 대각선  값을 넣을 때는 x - y + (n - 1)

        BackTracing(0, 0);

        System.out.println(answer);
    }
    public static void BackTracing(int depth, int count){ // depth = 행
        if(depth == n){
            if(count == n) answer++;
            return;
        }
        for (int i = 0; i < n; i++) {
            int up = depth + i;
            int down = depth - i + (n - 1);
            if(col[i] || visited1[up] || visited2[down]) continue;
            col[i] = true;
            visited1[up] = true;
            visited2[down] = true;
            BackTracing(depth + 1, count + 1);
            col[i] = false;
            visited1[up] = false;
            visited2[down] = false;
        }
    }
}
/*

N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.  (1 ≤ N < 15)

N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.


3 * 3

0,0  0,1  0,2

1,0  1,1, 1,2

2,0  2,1  2,2

x + y = 0 ~ 4
x - y = 2 ~ -2

4 * 4

0,0 0,1 0,2 0,3

1,0 1,1 1,2 1,3

2,0 2,1 2,2 2,3

3,0 3,1 3,2 3,3

x + y = 0 ~ 6
x - y = 3 ~ -3



 */
