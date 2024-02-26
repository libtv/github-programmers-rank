package org.example.programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/135807
// 프로그래머스 LEVEL 2 숫자 카드 나누기
import java.util.*;
public class NumberCardDivision {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        // 최대 공약수 GCD 복습
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        int GCDA = arrayA[0];
        for(int i = 0; i < arrayA.length; i++){
            GCDA = GCD(arrayA[i], GCDA);
        }
        int GCDB = arrayB[0];;
        for(int i = 0; i < arrayB.length; i++){
            GCDB = GCD(arrayB[i], GCDB);
        }

        boolean flag = true;
        for(int i = 0; i < arrayB.length; i++){
            if(arrayB[i] % GCDA == 0){
                flag = false;
                break;
            }
        }
        boolean flag2 = true;
        for(int i = 0; i < arrayA.length; i++){
            if(arrayA[i] % GCDB == 0){
                flag2 = false;
                break;
            }
        }
        if(!flag && !flag2) return 0;
        else if(flag && !flag2) return GCDA;
        else if(!flag && flag2) return GCDB;
        else return Math.max(GCDA, GCDB);
    }

    public static int GCD(int a, int b){
        if(b == 0){
            return a;
        }
        return GCD(b, a % b);
    }
}
