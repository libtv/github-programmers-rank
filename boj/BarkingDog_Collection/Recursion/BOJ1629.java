package boj.BarkingDog_Collection.Recursion;

// 곱셈 실버1
import java.io.*;
import java.util.*;
public class BOJ1629 {
    static long a; static long b; static long c; static long[] memo;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());
        memo = new long[1001]; // 거듭제곱 100까지 메모하기
        Arrays.fill(memo , - 1);
        System.out.println(calculate(b));
    }
    public static long calculate(long cur){
        if(cur == 1){
            return (a * cur) % c;
        }
        if(cur <= 1000 && memo[(int)cur] == -1){
            long temp = 0;
            if(cur % 2 == 0){
                temp = ((calculate(cur/2) % c) * (calculate(cur/2) % c)) % c;
                memo[(int)cur] = temp;
                return temp;
            }
            else{
                temp = ((calculate(cur/2 + 1) % c) * (calculate(cur/2) % c)) % c;
                memo[(int)cur] = temp;
                return temp;
            }
        }
        else if (cur <= 1000) {
            return memo[(int)cur];
        }
        else{
            if(cur % 2 == 0){
                return ((calculate(cur/2) % c) * (calculate(cur/2) % c)) % c;
            }
            else{
                return  ((calculate(cur/2 + 1) % c) * (calculate(cur/2) % c)) % c;
            }
        }
    }
}
