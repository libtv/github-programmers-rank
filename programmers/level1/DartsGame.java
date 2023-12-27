package org.example.programmers.level1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// https://school.programmers.co.kr/learn/courses/30/lessons/17682
// 2018 KAKAO BLIND RECRUITMENT // 다트 게임
public class DartsGame {
    public static void main(String[] args) {
        int a = solution("10S0D4D*");
        System.out.println(a);
    }
    public static int solution(String dartResult) {
        // 3chance //  score = 0~10 // s, d(제곱), t(3제곱)
        // * 전에 점수 2배 #은 해당점수 마이너스
        Queue<String> q = new LinkedList();

        for(int i = 0; i < dartResult.length(); i++){
            String temp = Character.toString(dartResult.charAt(i));
            q.offer(temp);
        }
        // System.out.println(q);
        double[] sum = new double[3];

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 3; i++){

            // 숫자 분리
            sb.append(q.poll());
            if (48 <= (int) q.peek().charAt(0) && (int)q.peek().charAt(0) <= 59){
                sb.append(q.poll());
                sum[i] = Double.parseDouble(sb.toString());
            }
            else{
                sum[i] = Double.parseDouble(sb.toString());
            }
            // System.out.println(sb);
            sb.setLength(0); // sb 초기화
            while((int)q.peek().charAt(0) < 48 || 59 < (int)q.peek().charAt(0)){
                sb.append(q.poll());
                if(q.isEmpty()){
                    break;
                }
            }
            String temp = sb.toString();
            if(temp.contains("D")){           // S or D or T
                sum[i] = Math.pow(sum[i] , 2);
            }
            else if(temp.contains("T")){
                sum[i] = Math.pow(sum[i] , 3);
            }
            if(temp.contains("#")){
                sum[i] = sum[i] * (-1);
            }
            if(temp.contains("*")){
                if( i == 0 ){
                    sum[i] = sum[i] * 2;
                }
                else{
                    sum[i] = sum[i] * 2;
                    sum[i-1] = sum[i-1] * 2;
                }
            }
            // System.out.println(sb);
            sb.setLength(0);
        }
        int answer = (int)(sum[0]+sum[1]+sum[2]);

        return answer;
    }
}

/* 너무 비효율적 리팩토링 하기

import java.util.*;
class Solution {
    public static int solution(String dartResult) {
        // 3chance //  score = 0~10 // s, d(제곱), t(3제곱)
        // * 전에 점수 2배 #은 해당점수 마이너스
        int answer = 0;

        String [] arr = new String[3];
        int index1 = 0;
        int index2 = 0;
        boolean flag = false;
        for(int i = 1; i < dartResult.length(); i++){
            if(48 <= (int)dartResult.charAt(i)  &&  (int)dartResult.charAt(i) <=57 && flag == false ){
                if(i==1){
                    continue;
                }
                index1 = i;
                i = i + 1;
                flag = true;
            }
            else if(48 <= (int)dartResult.charAt(i)  &&  (int)dartResult.charAt(i) <=57 && flag == true){
                index2 = i;
                break;
            }
        }
        // System.out.println(index1);
        // System.out.println(index2);
        arr[0] = dartResult.substring(0, index1);
        arr[1] = dartResult.substring(index1, index2);
        arr[2] = dartResult.substring(index2);
        // System.out.println(Arrays.toString(arr)); //  3개의 문자열로 나누기 끝
        // Math.pow(base, 3);

        answer = find(arr);

        return answer;
    }

    public static int find(String[] arr){

        double[] sum = new double[3];

        for(int i = 0; i < 3; i++){
            double temp = 0;
            String strTemp = arr[i];
            // System.out.println(strTemp);

            if(48 <= strTemp.charAt(1) && strTemp.charAt(1) <=57){ // 2번째값이 숫자인경우
                temp = Double.parseDouble(strTemp.substring(0, 2));
                // System.out.println(temp);
                if(strTemp.contains("D")){
                    temp = Math.pow(temp, 2);
                }
                else if(strTemp.contains("T")){
                    temp = Math.pow(temp, 3);
                }
                // System.out.println(temp);
                if(strTemp.contains("*")){
                    if(i == 0){
                        temp = temp * 2;
                    }
                    else{
                        temp  = temp * 2;
                        sum[i-1] = sum[i-1] * 2;
                    }
                }
                else if(strTemp.contains("#")){
                    temp = temp * -1;
                }

            }
            else{
                temp = (double)((int)strTemp.charAt(0) - 48);
                // System.out.println(temp);
                if(strTemp.contains("D")){
                    temp = Math.pow(temp, 2);

                }
                else if(strTemp.contains("T")){
                    temp = Math.pow(temp, 3);

                }
                // System.out.println(temp);
                if(strTemp.contains("*")){
                    if(i == 0){
                        temp =temp * 2;
                    }
                    else{
                        temp = temp * 2;
                        sum[i-1] = sum[i-1] * 2;
                    }
                }
                else if(strTemp.contains("#")){
                    temp = temp * -1;
                }

            }
            sum[i] = temp;
        }

        System.out.println(sum[0]);
        System.out.println(sum[1]);
        System.out.println(sum[2]);

        return (int)(sum[0] + sum[1] + sum[2]);
        }
  }
 */