package org.example.programmers.level0;

import java.util.Scanner;
public class PCCE5 {
    // East 동쪽
    // West 서쪽

    public static void main(String[] args) {

        System.out.println(solution("NSSNEWWN").toString());

    }

    public static int[] solution(String route) {
        int east = 0;
        int north = 0;
        int[] answer = new int [2];
        for(int i=0; i<route.length(); i++){
            switch(route.charAt(i)){
                case 'N':
                    north++;
                    break;
                case 'S':
                    north--;
                    break;
                case 'E':
                    east++;
                    break;
                case 'W':
                    east--;
                    break;
                default:
                    System.out.println("error");
            }
        }
        answer[0] = east;
        answer[1] = north;
        return answer;
    }
}

/*
출발점으로부터 동쪽으로 2, 북쪽으로 3만큼 떨어졌다면 [2, 3]을 return 합니다.
출발점으로부터 서쪽으로 1, 남쪽으로 4만큼 떨어졌다면 [-1, -4]를 return 합니다.
 */