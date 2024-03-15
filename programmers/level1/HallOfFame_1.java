package programmers.level1;
// https://school.programmers.co.kr/learn/courses/30/lessons/138477
// 명예의 전당 (1)

import java.util.*;
public class HallOfFame_1 {
    public static void main(String[] args) {

    }

    public static int[] solution(int k, int[] score) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for(int i = 0; i < score.length; i++){
            if(list.size() < k){
                list.add(score[i]);
                list2.add(Collections.min(list));
            }
            else if(list.size() >= k){
                if(Collections.min(list) < score[i]){
                    int index = list.indexOf(Collections.min(list));
                    list.remove(index);
                    list.add(score[i]);
                    list2.add(Collections.min(list));
                }
                else{
                    list2.add(Collections.min(list));
                }
            }
        }
        int [] answer = new int[list2.size()];
        for(int i = 0; i < list2.size(); i++){
            answer[i] = list2.get(i);
        }
        return answer;
    }
}


