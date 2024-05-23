package boj.BarkingDog_Collection.Math;

// 팩토리얼 0의 개수 실버5
import java.util.*;
public class BOJ1676 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long cur = 1;
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            cur *= i;
            while (cur % 10 == 0){
                cnt++;
                cur /= 10;
            }
            cur %= 1000;
        }
        System.out.println(cnt);
    }
}
