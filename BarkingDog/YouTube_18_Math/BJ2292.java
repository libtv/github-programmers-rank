package BarkingDog.YouTube_18_Math;

import java.util.Scanner;

// 벌집 브론즈2
public class BJ2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        long sum = 1;
        int cnt = 0;
        while (true){
            sum += cnt * (6);
            cnt++;
            if(input <= sum){
                break;
            }
        }
        System.out.println(cnt);
    }
}
/*
1 : 1
2 : 2 3 4 5 6 7
3 : 8 9 10 11 12 13 14 15 16 17 18 19







 */