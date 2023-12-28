package org.example.programmers.level1;
// https://school.programmers.co.kr/learn/courses/30/lessons/17681
// 2018 KAKAO BLIND RECRUITMENT [1차] 비밀지도
public class SecretMap {
    public static void main(String[] args) {

    }
    public String[] solution(int n, int[] arr1, int[] arr2) { // Integer.toBinaryString(int num) 사용 100점
        // Integer.toBinaryString
        String[] sol = new String[n];
        for(int i = 0; i < n; i++){

            int one = arr1[i];
            int two = arr2[i];

            String oneBinary = Integer.toBinaryString(one);
            String twoBinary = Integer.toBinaryString(two);

            StringBuilder sb1 = new StringBuilder(oneBinary);
            StringBuilder sb2 = new StringBuilder(twoBinary);

            int onelength = sb1.length();
            int twolength = sb2.length();

            if(onelength < n){
                for(int j = 0; j < n - onelength; j++){
                    sb1.insert(0, "0");
                }
            }
            if(twolength < n){
                for(int j = 0; j < n - twolength; j++){
                    sb2.insert(0, "0");
                }
            }
            String temp1 = sb1.toString();
            String temp2 = sb2.toString();

            StringBuilder secretMap = new StringBuilder();
            for(int j = 0; j < n; j++){
                if(temp1.charAt(j) == '0' && temp2.charAt(j) == '0'){
                    secretMap.append(" ");
                }
                else{
                    secretMap.append("#");
                }
            }
            // System.out.println(secretMap);
            sol[i] = secretMap.toString();
        }
        return sol;
    }
}
/* 런타임에러 25점 배열 index 에러 나는듯
import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[]array = new String[n];
        for(int i = 0; i < n; i++){
            int[]temp = find(arr1[i], arr2[i], n);
            // System.out.println(Arrays.toString(temp));
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++){
                if(temp[j]==0){
                    sb.append(" ");
                }
                else if(temp[j]==1){
                    sb.append("#");
                }
            }
            array[i] = sb.toString();
        }
        return array;
    }

    public static int[] find(int num1, int num2,  int n){ // 여기 문제
        // System.out.println(num1);
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        while(true){
            if(num1 < 2){
                sb1.append(num1);
                break;
            }
            sb1.append(num1%2);
            num1 = num1 / 2;
            if(num1 < 2){
                sb1.append(num1);
                break;
            }
        }

        if(sb1.length() < n){
            for(int i = 0; i < n-sb1.length(); i++){
                sb1.append("0");
            }
        }

        while(true){
            if(num2 < 2){
                sb2.append(num2);
                break;
            }
            sb2.append(num2%2);
            num2 = num2 / 2;
            if(num2 < 2){
                sb2.append(num2);
                break;
            }
        }
        // System.out.println(sb2.length());

        // System.out.println(n);
        if(sb2.length() < n){

            int test = n - sb2.length();

            for(int i = 0; i < test; i++){ // 0 1 2 3
                sb2.append("0");
            }
        }
        // System.out.println(sb2.length());
        sb1.reverse();
        sb2.reverse();

        String temp = sb1.toString();
        String temp2 = sb2.toString();

        int[] answer = new int[n];
        //System.out.println(temp);
        //System.out.println(temp2);
        for(int i = 0; i < n; i++){
            if(temp.charAt(i) == '0' && temp2.charAt(i) =='0'){
                answer[i] = 0;
            }
            else{
                answer[i] = 1;
            }
        }
        return answer;
    }
}

 */