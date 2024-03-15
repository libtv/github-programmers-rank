package BarkingDog.YouTube_18_Math;

import java.util.Scanner;

// 소인수분해 브론즈1
public class BJ11653 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int cnt = 2;
        int end = N;
        while (cnt * cnt <= end){
            if(N % cnt == 0){
                N /= cnt;
                sb.append(cnt);
                sb.append("\n");
            }
            else{
                cnt++;
            }
        }
        if(N != 1){
            sb.append(N);
        }
        System.out.println(sb);
    }
}
