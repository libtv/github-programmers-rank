package boj.BarkingDog_Collection.Math;

// 거의 소스 골드5
import java.io.*;
import java.util.*;
public class BOJ1456 {
    static final int INF = 10000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        boolean [] visited = new boolean[INF+1];

        int cnt =0;

        for (int i = 2; (long)i * i <= b; i++) {
            if(visited[i]) continue;
            for (int j = 2; j * i <= INF; j++) {
                visited[j * i] = true;
            }
            long cur = i;
            while (cur <= b / i){
                cur *= i;
                if(a <= cur) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
/*

어떤 수가 소수의 N제곱(N>=2) 꼴일 때, 그 수를 거의 소수라고 한다.
두 정수 A와 B가 주어지면, A보다 크거나 같고, B보다 작거나 같은 거의 소수가 몇 개인지 출력한다.

예제 입력2 1 10

4 8 9

 */