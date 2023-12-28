package org.example.programmers.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/12940
// 최대공약수와 최소공배수
public class GreatestCommonDivisorAndLeastCommonMultiple {
    public static void main(String[] args) {

    }
    public int[] solution(int n, int m) {

        int max = 1; // 최대공약수
        int min = 1; // 최소공배수
        for(int i = 2; i <= n; i++){
            if(n%i==0 && m%i==0){
                max = i;
            }
        }
        int num;
        if(n > m){
            num = n;
        }
        else{
            num = m;
        }
        while(true){
            if(num%n==0 && num%m==0){
                min = num;
                break;
            }
            num++;
        }

        int[]answer = {max, min};
        return answer;
    }
}
