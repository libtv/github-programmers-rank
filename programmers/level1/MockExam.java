package org.example.programmers.level1;

import java.util.ArrayList;

// https://school.programmers.co.kr/learn/courses/30/lessons/42840
// 완전탐색  // 모의고사
public class MockExam {
    public static void main(String[] args) {

    }
    public int[] solution(int[] answers) {
        // 1.  1 2 3 4 5
        // 2.  2 1 2 3 2 4 2 5
        // 3.  3 3 1 1 2 2 4 4 5 5
        int [] answer1 = {1,2,3,4,5};
        int cnt1 = 0;
        int index1 = 0;
        for(int i = 0; i < answers.length; i++){
            int num = answers[i];
            if(num == answer1[index1]){
                cnt1++;
            }
            index1++;
            if(index1 == answer1.length){
                index1 = 0;
            }
        }
        int [] answer2 = {2,1,2,3,2,4,2,5};
        int cnt2 = 0;
        int index2 = 0;
        for(int i = 0; i < answers.length; i++){
            int num = answers[i];
            if(num == answer2[index2]){
                cnt2++;
            }
            index2++;
            if(index2 == answer2.length){
                index2 = 0;
            }
        }
        int [] answer3 = {3,3,1,1,2,2,4,4,5,5};
        int cnt3 = 0;
        int index3 = 0;
        for(int i = 0; i < answers.length; i++){
            int num = answers[i];
            if(num == answer3[index3]){
                cnt3++;
            }
            index3++;
            if(index3 == answer3.length){
                index3 = 0;
            }
        }
        // System.out.println(cnt1);
        // System.out.println(cnt2);
        // System.out.println(cnt3);
        int [] check = {cnt1, cnt2, cnt3};
        int max = cnt1;
        for(int i = 1; i < 3; i++){
            if(check[i] > max){
                max = check[i];
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            if(max==check[i]){
                list.add(i+1);
            }
        }

        int [] end = new int [list.size()];
        for(int i = 0; i < list.size(); i++){
            end[i] = list.get(i);
        }
        return end;
    }
}
/*
 public int[] solution(int[] answer) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];                            // 어차피 3개니까 score로 저장
        for(int i=0; i<answer.length; i++) {
            if(answer[i] == a[i%a.length]) {score[0]++;}      // i%a.length 방법 좋다
            if(answer[i] == b[i%b.length]) {score[1]++;}
            if(answer[i] == c[i%c.length]) {score[2]++;}
        }
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));  // Max 2번써서 Max 찾기
        ArrayList<Integer> list = new ArrayList<>();
        if(maxScore == score[0]) {list.add(1);}
        if(maxScore == score[1]) {list.add(2);}
        if(maxScore == score[2]) {list.add(3);}
        return list.stream().mapToInt(i->i.intValue()).toArray();
    }
 */