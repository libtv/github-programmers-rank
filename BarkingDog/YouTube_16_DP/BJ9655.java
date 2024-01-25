package org.example.BarkingDog.YouTube_16_DP;

import java.util.Scanner;

// https://www.acmicpc.net/problem/9655
// 돌 게임 실버5
public class BJ9655 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        /*
        int [] DP = new int[1001];
        DP[1] = 1;
        DP[2] = 0;
        DP[3] = 1;
        DP[4] = 0;
         */
        if(n%2==0){
            System.out.println("CY");
        }
        else{
            System.out.println("SK");
        }
    }
}
/*
돌게임
돌 게임은 두 명이서 즐기는 재밌는 게임이다.
탁자 위에 돌 N개가 있다. 상근이와 창영이는 턴을 번갈아가면서 돌을 가져가며, 돌은 1개 또는 3개 가져갈 수 있다.
마지막 돌을 가져가는 사람이 게임을 이기게 된다.
두 사람이 완벽하게 게임을 했을 때, 이기는 사람을 구하는 프로그램을 작성하시오. 게임은 상근이가 먼저 시작한다.

DP[K] = 1 이면 상근이 승리 SK
DP[K] = 0 이면 창영이 승리 CY


 */