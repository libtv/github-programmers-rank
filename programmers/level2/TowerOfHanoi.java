package org.example.programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/12946
// 프로그래머스 Level2 하노이의 탑
import java.util.*;
public class TowerOfHanoi {
    static ArrayList<int[]> list;
    public int[][] solution(int n) {
        list = new ArrayList<>();
        Hanoi(n, 1, 2, 3);
        int [][] answer = new int [list.size()][2];
        for(int i = 0; i < list.size(); i++){
            int [] temp = list.get(i);
            answer[i][0] = temp[0];
            answer[i][1] = temp[1];
        }
        return answer;
    }
    public static void Hanoi(int n, int start, int mid, int end){
        if(n == 1){
            list.add(new int[]{start, end});
            return;
        }
        Hanoi(n-1, start, end, mid);
        list.add(new int[]{start, end});
        Hanoi(n-1, mid, start, end);
    }
}
