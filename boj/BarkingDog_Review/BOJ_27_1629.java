package boj.BarkingDog_Review;

// 곱셈
import java.io.*;
import java.util.*;
public class BOJ_27_1629 {
    static long A, B, C;
    static long [] memo = new long[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        // A^B % C =  if(B == even) ->  ( A^B/2 % C *  A^B/2 % C ) % C 였나?
        // A^B % C =  if(B == odd) ->   ( A^B/2 % C *  A^(B/2+1) % C ) % C 였나?
        // A^3 % C =  ((A^2 % C ) * ( A^1 % C )) % C;
        System.out.println(func(B));
    }
    public static long func(long cur){
        if(cur == 0){
            return 1;
        }
        else if(cur == 1){
            return A  %  C;
        }
        if(cur > 100000){
            if(cur % 2 == 0){ // even
                return ((func(cur/2) % C) * (func(cur/2) % C)) % C;
            }
            else{ // odd
                return ((func( cur/2) % C) * (func((cur/2 + 1)) % C)) % C;
            }
        }
        else{
            if(memo[(int)cur] == 0){
                if(cur % 2 == 0){ // even
                     memo[(int)cur] = ((func( cur/2) % C) * (func( cur/2) % C)) % C;
                }
                else{ // odd
                     memo[(int)cur] =  ((func(cur/2) % C) * (func((cur/2 + 1)) % C)) % C;
                }
                return memo[(int)cur];
            }
            else{
                return memo[(int)cur];
            }
        }
    }
}
