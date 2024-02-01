package org.example.BarkingDog.YouTube_18_Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 30 실버4
public class BJ10610 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        char[] arr = input.toCharArray();
        int [] arr2 = new int[arr.length];
        int sum = 0;
        int cnt = 0;
        for (char target : arr) {
            sum += target - '0';
            arr2[cnt] = target - '0';
            cnt++;
        }

        // 30의 배수 조건
        if(sum % 3 !=0 || !input.contains("0")){
            System.out.println(-1);
            return;
        }
        Arrays.sort(arr2);
        // System.out.println(Arrays.toString(arr2));
        StringBuilder sb = new StringBuilder();
        for (int i = arr2.length-1; i >=0 ; i--) {
            sb.append(arr2[i]);
        }
        System.out.println(sb);
    }
}
/*
그는 길거리에서 찾은 수에 포함된 숫자들을 섞어 30의 배수가 되는 가장 큰 수를 만들고 싶어한다.
N을 입력받는다. N는 최대 10(5)개의 숫자로 구성되어 있으며, 0으로 시작하지 않는다.
미르코가 만들고 싶어하는 수가 존재한다면 그 수를 출력하라. 그 수가 존재하지 않는다면, -1을 출력하라.

10만개 백트래킹은 불가

핵심은
모든 자리를 더했을 때 3의 배수이고 그리고 0을 포함해야 한다.



 */