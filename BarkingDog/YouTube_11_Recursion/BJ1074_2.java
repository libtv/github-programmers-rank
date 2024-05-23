package BarkingDog.YouTube_11_Recursion;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1074
// Z 실버1 다시 풀기
public class BJ1074_2 {
    static int N;
    static int R;
    static int C;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1 ≤ N ≤ 15
        // 0 ≤ r, c < 2N
        N = sc.nextInt();
        R = sc.nextInt();
        C = sc.nextInt();
        int size = (int) Math.pow(2, N); // 이건 길이 2 , 4,  8 ....
        conquer(size, R, C);
        System.out.println(count);
    }

    // 8 * 8 배열  (6,6) - >  4 * 4 배열  (2,2)
    // 4 * 4 배열  (3,1) - >  2 * 2 배열  (1,1)
    // 4 -> 4 같은분면인 경우 그냥 새로운 사이즈 만큼 빼주면 끝? ((6-4), (6-4))
    // (7,7)-> (3,3) 그렇네
    // 4 -> 3인 경우  (3,2) -> (1,0) 4에서 2로 2씩 빼주네?
    // (3,0) -> (1,0) 빼면 0보다 크거나 같으면 빼주네
    // (2,2) -> (0,0)
    // (1,3) -> (1,1)
    // (2,3) -> (0,1)
    // 원래 들어온 SIZE만큼 빼준다가 DEFAULT인데 만약 빼면 음수가 되면 그대로 유지?
    // (3,4) -> (3, 0)
    // (3,3) -> (3, 3) 유지 ㅋㅋ ㅇㅋ
    // 들어온 R C가 이게 몇 사분면인지 확인해서 count에 더하기 해주면 끝

    public static void conquer(int size, int R, int C){
         int temp = size;
         int sum = size * size; // 총 크기

        // 어디인지? 1, 2, 3, 4?
         if(R < temp/2 && C < temp/2){         // (0,0)
             count += 0;
         }
         else if(R < temp/2 && C >= temp/2){   // (0,1)
             count += sum/4;
         }
         else if(R >= temp/2 && C < temp/2){   // (1,0)
             count += sum/2;
         }
         else if(R >= temp/2 && C >= temp/2){  // (1,1)
             count += (sum/4 * 3);
         }

         int newR;
         int newC;
         if( R - (size/2) >= 0){
             newR = R - (size/2);
         }
         else{
             newR = R;
         }
         if (C - (size/2) >= 0){
             newC = C - (size/2);
         }
         else{
             newC = C;
         }
         if(size > 2){
            conquer(size/2 , newR, newC);
         }
    }
}
/*
문제 접근 방식
만약 총 16의 크기의 배열이 있다.
방문 순서는 만약 내가 12의 위치 즉 (2,2)에 있다고 가정을 해본다.
0  1  4  5
2  3  6  7
8  9  12 13
10 11 14 15

지금 16의 크기니까
1사분면 + 0
2사분면 + 4
3사분면 + 8
4사분면 + 12

4 * 4의 배열이니까

분할하면

2 * 2가 4개 나온다.

(2,2)의 위치는 4사분면 전체 COUNT에 12를 더해준다.

2 * 2 크기까지 오면 재귀는 STOP
12의 위치는 1사분면이다. 그럼 COUNT + 0 이니까 총 12번째 방문이라는 사실을 알 수 있다.

각 크기 마다 4분면에서 더해주는 값은 SIZE = 배열의 크기 2 * 2면 4

1 : 0
2 : SIZE - (SIZE/4 * 3)  == SIZE의 1/4
3 : SIZE - (SIZE/4 * 2)  == SIZE의 2/4
4 : SIZE - (SIZE/4 * 1)  == SIZE의 3/4

현재 위치가 어디 4분면인지는 어떻게 알지?

 */