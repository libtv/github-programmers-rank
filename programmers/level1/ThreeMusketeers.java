package org.example.programmers.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/131705
// 삼총사
public class ThreeMusketeers {
    public static void main(String[] args) {

    }
    public int solution(int[] number) {
        int answer = 0;
        for(int i = 0; i < number.length; i++){
            for(int j= i+1; j < number.length; j++){
                for(int k = j+1; k < number.length; k++){
                    if(number[i]+number[j]+number[k]==0){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

}
