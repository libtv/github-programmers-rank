package org.example.programmers.level1;

import java.util.ArrayList;
import java.util.Collections;

// https://school.programmers.co.kr/learn/courses/30/lessons/161990
// 바탕화면 정리
public class CleanUpYourDesktop {
    public static void main(String[] args) {

    }
    public int[] solution(String[] wallpaper) {
        String[][] wall = new String[wallpaper.length][wallpaper[0].length()];
        for(int i = 0; i < wallpaper.length; i++){
            String[] split = wallpaper[i].split("");
            for(int j = 0; j < wallpaper[0].length(); j++){
                wall[i][j] = split[j];
            }
        }
        // System.out.println(Arrays.deepToString(wall));

        ArrayList<Integer> xList = new ArrayList<>();
        ArrayList<Integer> yList = new ArrayList<>();

        for(int i = 0; i < wall.length; i++ ){ // 0,1  3,4
            for(int j = 0; j < wall[0].length; j++){
                if(wall[i][j].equals("#")){
                    xList.add(i);
                    yList.add(j);
                }
            }
        }
        int xMin = Collections.min(xList);
        int xMax = Collections.max(xList);
        int yMin = Collections.min(yList);
        int yMax = Collections.max(yList);

        int [] answer = new int[4];
        answer[0] = xMin;
        answer[1] = yMin;
        answer[2] = xMax+1;
        answer[3] = yMax+1;
        return answer;
    }

}
