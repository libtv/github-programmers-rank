package org.example.BarkingDog.YouTube_20_TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 소수의 연속합  골드3
public class BJ1644 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        // 에라토스테네스의 체 만들기
        boolean[] find = new boolean[target + 1];
        for (int i = 2; i <= target; i++) {
            if(!find[i]){
                for (int j = 2; true; j++) {
                    if(i * j <= target){
                        find[i * j] = true;
                    }
                    else{
                        break;
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(find)); false만 소수 확인
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i <= target ; i++) {
            if(!find[i]){
                list.add(i);
            }
        }
        // System.out.println(list);
        int size = list.size();
        int left = 0;
        int right = 0;
        int cur = 0;
        int answer = 0;
        while (left <= right && left < size && right < size){
               cur += list.get(right);
               if(cur == target){
                   answer++;
                   right++;
               }
               else if(cur < target){
                   right++;
               }
               else if(cur > target){
                   cur -= list.get(left);
                   cur -= list.get(right);
                   left++;
               }
        }
        System.out.println(answer);
    }
}
/*
하나 이상의 연속된 소수의 합으로 나타낼 수 있는 자연수들이 있다. 몇 가지 자연수의 예를 들어 보면 다음과 같다.

3 : 3 (한 가지)
41 : 2+3+5+7+11+13 = 11+13+17 = 41 (세 가지)
53 : 5+7+11+13+17 = 53 (두 가지)

 */