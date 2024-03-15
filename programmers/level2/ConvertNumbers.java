package programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/154538
// 프로그래머스 level 2 숫자 변환하기

import java.util.*;
public class ConvertNumbers {
    public int solution(int x, int y, int n) {
        int [] DP = new int[1000001];
        Arrays.fill(DP, 1000001);
        DP[x] = 0;
        for(int i = x + 1; i <= y ; i++){

            if(i % 2 == 0){
                DP[i] = Math.min(DP[i], DP[i/2] + 1);
            }
            if(i % 3 == 0){
                DP[i] = Math.min(DP[i], DP[i/3] + 1);
            }
            if(i - n >= x){
                DP[i] = Math.min(DP[i], DP[i - n] + 1);
            }

        }
        if(DP[y] == 1000001) return -1;
        return DP[y];
    }
}
