package org.example.BarkingDog.YouTube_18_Math;

import java.io.*;
import java.util.StringTokenizer;

/*
M = 10 N = 12의 최대해는? 60 = 최소공배수
10 * 12 = 최소공배수 * BCD(12, 10) 즉 최소공배수는 120 / 2 = 60 이다.
BCD(12 , 10) = BCD(10, 2) = BCD(2, 0) 최소공약수는 = 2
 */
// 카잉 달력 실버1
public class BJ6064 {
    static int gcd;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // (M : N)의 최대해는 LCM(M , N) 이다. 즉 최소공배수
            // M * N = GCD * LCM 이다.

            // 1. GCD 최대 공약수 구하기
            gcd = 0;
            if(M >= N){
                find(M, N);
            }
            else{
                find(N, M);
            }
            int max = (M * N) / gcd;
            // System.out.println(max);
            if(a == M){
                a = 0;
            }
            if(b == N){
                b = 0;
            }
            int answer = -1;
            for (int j = a; j <= max; j+= M) {
                if(j == 0){
                    continue;
                }
                if(j % N == b){
                    answer = j;
                    break;
                }
            }
            sb.append(answer).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    // 최대 공약수를 구하는 메서드
    public static void find(int a, int b){
        if(b == 0){
            gcd = a;
            return;
        }
        find(b, a % b);
    }

}
/*
M, N 보다 작거나 같은 두 개의 자연수 X,Y 를 가지고 각 년도를 표현

1:1
2:2
x:y

만일 x < M 이면 x = x + 1 그렇지 않으면 x = 1
같은 방식으로 y < N 이면 y = y + 1 그렇지 않으면 y = 1

M: N 은 그들 달력의 마지막 해로서 종말을 도래한다. ㅋㅋ

EX)
M = 10 N = 12
<1:1> 첫 번째 해 <1,11> 11번째 해  <3:1>은 13번째 해
<2:2> 2
<3:3> 3
<4:4> 4
<5:5> 5
<6:6> 6
<7:7> 7
<8:8> 8
<9:9> 9
<10,10> 10
<1, 11> 11
<2, 12> 12
<3, 1>  13

10으로 나눴을 때 나머지가 3 12로 나눴을 때 나머지가 1

10 : 12
10으로 나눴을때 나머지가 0
12로 나눴을 때 나머지가 0

 */