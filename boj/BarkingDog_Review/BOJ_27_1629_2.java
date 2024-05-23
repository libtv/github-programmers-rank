package boj.BarkingDog_Review;

// 곱셈
import java.io.*;
import java.util.*;
public class BOJ_27_1629_2 {
    static int A, B, C;
    static long [] memo = new long[100001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        System.out.println(func(B));
    }
    static long func(int cur){
        if(cur == 1) return A % C;
        if(cur > 100000){
            long ans = func(cur/2) % C;
            if(cur % 2 == 0){
                 return (ans * ans) % C;
            }
            else return (ans * ((ans * (func(1))) % C)) % C;
        }
        else{
            if(memo[cur] == 0){
                long ans = func(cur/2) % C;
                if(cur % 2 == 0){
                    memo[cur] = (ans * ans) % C;
                }
                else memo[cur] = (ans * ((ans * (func(1))) % C)) % C;
            }
            return memo[cur];
        }
    }
}
