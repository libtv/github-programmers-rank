package org.example.BarkingDog.YouTube_18_Math;

import java.util.Scanner;

// 팩토리얼 0의 개수 실버5
public class BJ1676 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        while (n >= 5){
            cnt += n / 5;
            n /= 5;
        }
        System.out.println(cnt);

    }
}
/* 소인수 5의 개수로 0의 개수가 정해진다.

10! = 10(2 * 5), 5  2개
15  = 3
20  = 4
25  = 5

 */





/*
N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오

3!  1 * 2 * 3 = 6

4!  1 * 2 * 3 * 4 = 24

5!  120 ans : 1

5의 배수가 곱해지면 0의 개수가 1개씩 추가

즉 5부터 n까지 5의 배수의 개수를 구하자.

10! 2 * 5 and 10

20! 2 * 5 , 10 , 20 , 15 * 3 = 30 4개

25! 6개

1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25

25 * 2 = 50
24 * 5 = 120

20 * 1 = 20

 */