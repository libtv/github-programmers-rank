package org.example.BarkingDog.YouTube_11_Recursion;

// https://www.acmicpc.net/problem/1629
// 곱셈 실버1
import java.io.*;
import java.util.*;
public class BJ1629 {
    static long C;
    public static void main(String[] args) {
        // 자연수 A를 B번 곱한 수를 알고 싶다. 단 구하려는 수가 매우 커질 수 있으므로 이를 C로 나눈 나머지를 구하는 프로그램을 작성하시오.
        // 첫째 줄에 A, B, C가 빈 칸을 사이에 두고 순서대로 주어진다. A, B, C는 모두 2,147,483,647 이하의 자연수이다.

        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        C = sc.nextLong();
        System.out.println(find(A, B));

    }

    public static long find(long A, long B){ // 10 , 11 , 12
        if(B==0){
            return 0;
        }
        else if(B==1){
            return A % C;
        }
        long num = find(A, B/2);
        long result = (num * num) % C;

        if(B % 2 == 1){
            result = (result * (A % C)) % C;
        }
        return result;

    }
}
/*
(A + B) % p = ((A % p) + (B % p)) % p
(A * B) % p = ((A % p) * (B % p)) % p  == > (a5 * a5) % c  == ((a5 % c) * (a5 %c)) % c
(A - B) % p = ((A % p) - (B % p) + p) % p
 */

// 7^8 mod 13 = (7^4 * 7^4) mod 13 = (7^4 mod 13 * 7^4 mod 13) mod 13
// 7^9 mod 13 = (7^4 * 7^4 * 7^1) mod 13 = (7^4 mod 13 * 7^4 mod 13 * 7^1 mod 13) * 13?