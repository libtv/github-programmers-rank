package boj.BarkingDog_Collection.Math;

// 카잉 달력 실버1
import java.util.*;
import java.io.*;
public class BOJ6064 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while (n-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(N == x) x = 0;
            if(M == y) y = 0;

            int max = 0;
            if(N >= M)  max = LCM(N , M);
            else max = LCM(M , N);

            if(x == 0 && y == 0){
                sb.append(max).append("\n");
                continue;
            }

            boolean flag = true;
            for (int i = x; i <= max; i+= N) {
                if(i % M == y){
                    sb.append(i).append("\n");
                    flag = false;
                    break;
                }
            }

            if(flag) sb.append("-1").append("\n");

        }
        System.out.println(sb);
    }
    public static int GCD(int a, int b){
        if(b == 0) return a;
        return GCD(b, a % b);
    }
    public static int LCM(int a, int b){
        return a * b / GCD(a, b);
    }
    // A * B =  GCD * LCM
}
/*
그들은 M과 N보다 작거나 같은 두 개의 자연수 x, y를 가지고 각 년도를 x:y 같은 형식으로 표현하였다.

<x:y>의 다음 해를 표현한 것을 <x':y'>
x < M 이면 x' = x + 1이고, 그렇지 않으면 x' = 1이다. 같은 방식으로 만일 y < N이면 y' = y + 1이고, 그렇지 않으면 y' = 1이다.

M = 10 이고 N = 12라고 하자.
첫 번째 해는 <1:1>로 표현되고,
11번째 해는 <1:11>로 표현된다.            11 % 10 ... 1  11 % 12 ... 11  <1:11> 11
<3:1>은 13번째 해를 나타내고,             13 % 10 ... 3  13 % 12 ... 1   <3:1> 13
<10:12>는 마지막인 60번째 해를 나타낸다.    60 % 10 ... 0  60 % 12 ... 0

네 개의 정수 M, N, x와 y가 주어질 때, <M:N>이 카잉 달력의 마지막 해라고 하면 <x:y>는 몇 번째 해를 나타내는지 구하는 프로그램을 작성하라.

 */