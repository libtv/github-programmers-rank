package boj.BarkingDog_Collection.Math;

// 소수 찾기
import java.io.*;
import java.util.*;
public class BOJ1978 {
    static int answer;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (n-->0){
            isPrime(Integer.parseInt(st.nextToken()));
        }

        System.out.println(answer);

    }
    public static void isPrime(int n){
        if(n == 1) return;
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0) return;
        }
        answer++;
    }

}
