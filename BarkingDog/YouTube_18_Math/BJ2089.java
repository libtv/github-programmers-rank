package org.example.BarkingDog.YouTube_18_Math;

import java.util.Scanner;

// -2진수 실버2
public class BJ2089 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        while (true){
            int temp = (int)Math.ceil((double)n / -2);
            if(temp * -2 == n){
                sb.insert(0, 0);
            }
            else{
                sb.insert(0, 1);
            }
            n = temp;
            if(n == 0){
                break;
            }
            if(n == 1){
                sb.insert(0, 1);
                break;
            }
        }
        System.out.println(sb.toString());
    }
}
/*

case1 : -1

-1 = (-2 * 1) + 1

ans : 11

case2 : 1

1 = (-2 * 0) + 1
stop
1 = 1

- 13 = (-2 * 7) + 1


 */