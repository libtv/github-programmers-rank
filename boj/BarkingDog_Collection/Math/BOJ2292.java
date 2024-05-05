package boj.BarkingDog_Collection.Math;

// 벌집 브론즈2
import java.util.*;
public class BOJ2292 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int cnt = 1;
        int cur = 1;
        while (cur < input){
            cur += cnt++ * 6;
        }
        System.out.println(cnt);
    }
}
/*

1 7 19 37
 6 12 18



 */