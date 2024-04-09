package boj.BarkingDog_Collection.Math;

// 에라토스테네스의 체 실버4
import java.util.*;
import java.io.*;
public class BOJ2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean [] visited = new boolean[n+1];
        int cnt = 1;
        for (int i = 2; i <= n; i++) {
            if(visited[i]) continue;
            for (int j = 1; i * j <= n; j++) {
                if(visited[i*j]) continue;
                visited[i*j] = true;
                if(cnt == k){
                    System.out.println(i * j);
                    return;
                }
                cnt++;
            }
        }
    }
}
/*

이 알고리즘은 다음과 같다.

2부터 N까지 모든 정수를 적는다.
아직 지우지 않은 수 중 가장 작은 수를 찾는다. 이것을 P라고 하고, 이 수는 소수이다.
P를 지우고, 아직 지우지 않은 P의 배수를 크기 순서대로 지운다.
아직 모든 수를 지우지 않았다면, 다시 2번 단계로 간다.
N, K가 주어졌을 때, K번째 지우는 수를 구하는 프로그램을 작성하시오.

 */