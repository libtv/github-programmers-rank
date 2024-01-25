package org.example.BarkingDog.YouTube_16_DP;

import java.util.Scanner;

// https://www.acmicpc.net/problem/9657
// 돌 게임3 실버3
public class BJ9657 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(((N % 7 == 0 || N % 7 == 2) ? "CY" : "SK"));
    }
}
/*
돌은 1개, 3개 또는 4개 가져갈 수 있다. 마지막 돌을 가져가는 사람이 게임을 이기게 된다.
두 사람이 완벽하게 게임을 했을 때, 이기는 사람을 구하는 프로그램을 작성하시오. 게임은 상근이가 먼저 시작한다.
 */