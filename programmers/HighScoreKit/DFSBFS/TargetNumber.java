package org.example.programmers.HighScoreKit.DFSBFS;

// https://school.programmers.co.kr/learn/courses/30/lessons/43165
// 프로그래머스 고득점 키트 level2

import java.util.*;
public class TargetNumber {
    static int num;
    static int answer;
    static int [] arr;
    static int tar;
    static int [] numberss;

    public static void main(String[] args) {
        int [] test = {4,1,2,1};
        int target = 4;
        System.out.println(solution(test, target));
    }
    public static int solution(int[] numbers, int target) {
        num = numbers.length;
        answer = 0;
        tar = target;
        numberss = numbers;
        arr = new int[num];
        func(0);
        // System.out.println(Arrays.toString(numberss));
        return answer;
    }
    public static void func(int depth){ // 1은 더하기 0은 빼기
        if( depth == num ){
            // System.out.println(Arrays.toString(arr));
            func2(arr);
            return;
        }
        for(int i = 0; i <= 1; i++){
            arr[depth] = i;
            func(depth + 1);
        }
    }
    public static void func2(int [] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                sum -= numberss[i];
            }
            else{
                sum += numberss[i];
            }
        }
        if(sum == tar){
            // System.out.println(Arrays.toString(arr));
            answer++;
        }
    }
}
