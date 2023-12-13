package org.example.boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/26099

/*
설탕 봉지는 3KG, 5KG
최대한 작은 개수의 봉지에 배달
설탕을 정확하게 N킬로그램 배달해야 할 때, 봉지를 몇개 가져가면 되는지?
 */
public class BJ26099 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        long bag5 = 0; // 카운트용 변수
        long bag3 = 0;

        // 설탕 분류 공장

        while(N>0){
           if(N%5==0){ // 남은 설탕이 5의 배수인가?
               bag5 = N/5;
               N = 0;
               break;
           }
           N = N - 3;
           bag3++;
           if (N==0){
               break;
           }
        }

        // 설탕을 분류하고 남은 설탕이 있으면 -1 출력 아니면 봉지의 개수 출력
        if(N!=0){
            System.out.println(-1);
        }
        else{
            System.out.println(bag5 + bag3);
        }

    }
}
