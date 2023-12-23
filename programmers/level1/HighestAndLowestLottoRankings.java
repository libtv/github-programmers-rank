package org.example.programmers.level1;

import java.util.HashMap;

// https://school.programmers.co.kr/learn/courses/30/lessons/77484
// 로또의 최고 순위와 최저 순위
public class HighestAndLowestLottoRankings {
    public static void main(String[] args) {

    }
    public int[] solution(int[] lottos, int[] win_nums) {
        int [] rank = {6 ,6 ,5, 4, 3, 2, 1};

        int cnt =0;
        int num =0;
        for(int i = 0; i < 6; i++){
            if(lottos[i]==0){
                num++;
                continue;
            }
            for(int j = 0; j < 6; j++){
                if(lottos[i]==win_nums[j]){
                    cnt++;
                }
            }
        }
        int [] answer = {rank[cnt+num], rank[cnt]};
        return answer;
    }
}
// 코드 진짜 개더럽네 ㅋㅋ 1. 코드 100점
/*
public int[] solution(int[] lottos, int[] win_nums) {

        int cnt =0;
        int num =0;
        for(int i = 0; i < 6; i++){
            if(lottos[i]==0){
                num++;
                continue;
            }
            for(int j = 0; j < 6; j++){
                if(lottos[i]==win_nums[j]){
                    cnt++;
                }
            }
        }
        int[]answer = new int[2];
        if(cnt==6){
            answer[0] = 1;
            answer[1] = 1;
        }
        else if(cnt==5){
            if(num==0){
                answer[0] = 2;
            }
            else if (num==1){
                answer[0] = 1;
            }
            answer[1] = 2;
        }
        else if(cnt==4){
            answer[1] = 3;
            if(num==0){
                answer[0] = 3;
            }
            else if(num==1){
                answer[0] = 2;
            }
            else{
                answer[0] = 1;
            }
        }
        else if(cnt==3){
            answer[1] = 4;
            if(num==0){
                answer[0] = 4;
            }
            else if(num==1){
                answer[0] = 3;
            }
            else if(num==2){
                answer[0] = 2;
            }
            else if(num==3){
                answer[0] = 1;
            }
        }
        else if(cnt==2){
            answer[1] = 5;
            if(num==0){
                answer[0] = 5;
            }
            else if(num==1){
                answer[0] = 4;
            }
            else if(num==2){
                answer[0] = 3;
            }
            else if(num==3){
                answer[0] = 2;
            }
            else if(num==4){
                answer[0] = 1;
            }
        }
        else if(cnt==1){
            answer[1] = 6;
            if(num==0){
                answer[0] = 6;
            }
            else if(num==1){
                answer[0] = 5;
            }
            else if(num==2){
                answer[0] = 4;
            }
            else if(num==3){
                answer[0] = 3;
            }
            else if(num==4){
                answer[0] = 2;
            }
            else if(num==5){
                answer[0] = 1;
            }
        }
        else if(cnt==0){
            answer[1] = 6;
            if(num==0){
                answer[0] = 6;
            }
            else if(num==1){
                answer[0] = 6;
            }
            else if(num==2){
                answer[0] = 5;
            }
            else if(num==3){
                answer[0] = 4;
            }
            else if(num==4){
                answer[0] = 3;
            }
            else if(num==5){
                answer[0] = 2;
            }
            else if(num==6){
                answer[0] = 1;
            }
        }

        return answer;

    }
 */
/* 2. 코드
public int[] solution(int[] lottos, int[] win_nums) {
        HashMap<Integer , Integer> map = new HashMap<>();
        //     <일치 내용  /  순위>
        int down = 6;
        for(int i=1; i <= 6; i++){
            map.put(i, down);
            down--;
        }
        // System.out.println(map);

        int cnt =0;
        int num =0;
        for(int i = 0; i < 6; i++){
            if(lottos[i]==0){
                num++;
                continue;
            }
            for(int j = 0; j < 6; j++){
                if(lottos[i]==win_nums[j]){
                    cnt++;
                }
            }
        }
        int[]answer = new int[2];
        if(cnt!=0){
            answer[1] = map.get(cnt);
        }
        else if(cnt==0){
            answer[1] = 6;
        }
        if(num==6){
            answer[0] = 1;
        }
        else{ // 0 ~ 5
            answer[0] = answer[1] - num;
        }
        return answer;
    }
 */
