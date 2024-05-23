package BarkingDog.YouTube_11_Recursion;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1074
// Z 실버1
public class BJ1074 {
    static int count = 0;
    public static void main(String[] args) {
            // N R C
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int R = sc.nextInt();
        int C = sc.nextInt();
        // 언제 R행 C열에 도착하는지
        func((int)Math.pow(2,N),R,C);
        System.out.println(count);

    }
    // 함수를 생각해보자
    public static int func(int n, int r ,int c){ // 8 -> 4 -> 2
        if(n == 1){
            return -1;
        }
        // 4등분 하기
        // 첫 번째 구간
        if(0 <= r && r < n/2 && 0<= c && c < n/2){
            return func(n/2, r, c );
        }
        // 두 번째 군간
        else if(0 <= r && r < n/2 && n/2 <= c && c < n){
            count += n * n / 4;
            return func(n/2, r, c - n/2 );
        }
        // 3
        else if(2/n <= r && r < n && c < n/2 ){
            count += n * n / 2;
            return func(n/2, r - n/2, c);
        }
        // 4
        else{
            count += n * n - ( n * n / 4);
            return func(n/2, r - n/2 , c - n/2);
        }

    }

}
