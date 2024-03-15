package BarkingDog.YouTube_13_Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/14888
// 연산자 끼워넣기
public class BJ14888 {
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int [] arr; // 덧셈 뺄셈 곱셈 곱셈 나눗셈 조합
    static int [] number; // 숫자들
    static int N; // 수의 개수

    static int plus;
    static int minus;
    static int multiplication;
    static int division;

    static int size;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        number = new int[N];
        for (int i = 0; i < N ; i++) {
            number[i] = Integer.parseInt(split[i]);
        }
        String[] split2 = br.readLine().split(" ");
        plus = Integer.parseInt(split2[0]);
        minus = Integer.parseInt(split2[1]);
        multiplication = Integer.parseInt(split2[2]);
        division = Integer.parseInt(split2[3]);

        size = plus + minus + multiplication + division; // 1 2 3 4
        arr = new int[size];
        func(0,0,0,0,0);
        System.out.println(max);
        System.out.println(min);

    }
    public static void func(int depth, int c1, int c2, int c3, int c4){ // 덧셈 뺄셈 곱셈 나눗셈
        if( size == depth ){
            // System.out.println(Arrays.toString(arr)); 조합 확인 완료
            int temp = calculate(arr);
            if( max < temp){
                max = temp;
            }
            if( min > temp){
                min = temp;
            }
            return;
        }
        if(c1 < plus){
            arr[depth] = 1;
            func(depth + 1 , c1 + 1, c2, c3, c4);
        }

        if(c2 < minus){
            arr[depth] = 2;
            func(depth + 1, c1, c2 +1, c3 ,c4);
        }

        if(c3 <  multiplication){
            arr[depth] = 3;
            func(depth + 1, c1, c2 , c3 + 1 ,c4);
        }

        if(c4 < division){
            arr[depth] = 4;
            func(depth + 1, c1, c2 , c3 ,c4 + 1);
        }
    }
    public static int calculate(int[] arr){
        // System.out.println(Arrays.toString(arr));
        // System.out.println(Arrays.toString(number));
        // 최대 최소 순서대로
        int sum = number[0];
        int cnt = 0;
        for (int i = 1; i < N; i++) {
            int temp = arr[cnt];
            cnt ++;
            if(temp == 1){
                sum += number[i];
            }
            else if(temp == 2){
                sum -= number[i];
            }
            else if(temp == 3){
                sum *= number[i];
            }
            else if(temp == 4){
                sum /= number[i];
            }
        }

        return sum;
    }
}
/*
입력
첫째 줄에 수의 개수 N(2 ≤ N ≤ 11)가 주어진다. 둘째 줄에는 A1, A2, ..., AN이 주어진다.
셋째 줄에는 합이 N-1인 4개의 정수가 주어지는데, 차례대로 덧셈(+)의 개수, 뺄셈(-)의 개수, 곱셈(×)의 개수, 나눗셈(÷)의 개수이다.

출력
최댓값
최솟값

 */

/*
문제 접근
덧셈 뺄셈 곱셈 나눗셈의 개수로 순서를 조합한다. (백트래킹)
그리고 계산해서 min과 max를 갱신한다.

 */