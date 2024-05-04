package boj.BarkingDog_Collection.Math;

// 이항 계수 1 브론즈 1
import java.io.*;
import java.util.*;
public class BOJ11050 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 이항 계수 -> 조합 n!/k! * (n-k)! 5!/2! * 3! = 10

        if(k == 0){
            System.out.println(1);
            return;
        }
        int cnt = 1;
        for (int i = n - k + 1; i <= n; i++) {
            cnt *= i;
        }
        for (int i = 1; i <= k; i++) {
            cnt /= i;
        }
        System.out.println(cnt);

    }
}
/*

N 에서 K개를 뽑을 때 순서를 고려하지 않으면 조합

N!/(N-K)! * K!

N 에서 K개를 뽑을 때 순서를 고려하면 순열

N!/(N-K)!

 */