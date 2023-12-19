package org.example.programmers.level1;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/172928
// 공원 산책
public class WalkInThePark {
    public static void main(String[] args) {

    }
    public int[] solution(String[] park, String[] routes) {

        // 1차원 배열-> 2차원배열
        int x = 0;
        int y = 0;
        String[][]realPark = new String[park.length][park[0].length()];
        for (int i = 0; i < park.length ; i++) {
            for(int j = 0; j < park[0].length(); j++){
                if(park[i].charAt(j)=='S'){
                    x = i;
                    y = j;
                }
                realPark[i][j] = Character.toString(park[i].charAt(j));
            }
        }
        // System.out.println(Arrays.deepToString(realPark));
        // System.out.println(x + "," + y);

        int newX = x;
        int newY = y;
        for (int i = 0; i < routes.length ; i++) {
            String[] split = routes[i].split(" ");

            int tmpx = newX;
            int tmpy = newY;

            if(split[0].equals("N")){
                boolean flag = false;
                for (int j = 0; j < Integer.parseInt(split[1]); j++) {
                    newX--;
                    if(!check(newX, newY, realPark)){
                        flag = true;
                        break;
                    }
                }
                if(flag){
                    newX = tmpx;
                }
                tmpx = newX;
            }
            else if(split[0].equals("S")){
                boolean flag = false;
                for (int j = 0; j < Integer.parseInt(split[1]); j++) {
                    newX++;
                    if(!check(newX, newY, realPark)){
                        flag = true;
                        break;
                    }
                }
                if(flag){
                    newX = tmpx;
                }
                tmpx = newX;
            }
            else if(split[0].equals("W")){
                boolean flag = false;
                for (int j = 0; j < Integer.parseInt(split[1]); j++) {
                    newY--;
                    if(!check(newX, newY, realPark)){
                        flag = true;
                        break;
                    }
                }
                if(flag){
                    newY = tmpy;
                }
                tmpy = newY;
            }
            else if(split[0].equals("E")){
                boolean flag = false;
                for (int j = 0; j < Integer.parseInt(split[1]); j++) {
                    newY++;
                    if(!check(newX, newY, realPark)){
                        flag = true;
                        break;
                    }
                }
                if(flag){
                    newY = tmpy;
                }
                tmpy = newY;
            }
            // System.out.println(newX);
            // System.out.println(newY);
            // System.out.println(Arrays.deepToString(realPark));
        }

        int[] result = {newX,newY};
        return result;
        // N : 북쪽으로 주어진 칸만큼 이동합니다.
        // S : 남쪽으로 주어진 칸만큼 이동합니다.
        // W : 서쪽으로 주어진 칸만큼 이동합니다.
        // E : 동쪽으로 주어진 칸만큼 이동합니다.

    }
    public static boolean check(int newX, int newY, String[][]realpark) {
        if(newX < 0 || newX >= realpark.length || newY < 0 || newY >= realpark[0].length || realpark[newX][newY].equals("X"))
            return false;

        return true;
    }

}
/*  이부분 리팩토링 하기
 for (int i = 0; i < routes.length ; i++) {
            String[] split = routes[i].split(" ");
            System.out.println(split[0]);
            System.out.println(split[1]);
            if(split[0].equals("N") && (x - Integer.parseInt(split[1])>=0) && (!realPark[ x - Integer.parseInt(split[1])][y].equals("X"))){
               x = x - Integer.parseInt(split[1]);
                System.out.println("N");
                System.out.println(x);
                System.out.println(y);
            }
            else if(split[0].equals("S") && (x + Integer.parseInt(split[1]) < realPark.length) && (!realPark[ x + Integer.parseInt(split[1])][y].equals("X"))) {
                x = x + Integer.parseInt(split[1]);
                System.out.println("S");
                System.out.println(x);
                System.out.println(y);
            }
            else if(split[0].equals("W") && (y-Integer.parseInt(split[1])>=0) && (!realPark[x][y-Integer.parseInt(split[1])].equals("X"))){
                y = y - Integer.parseInt(split[1]);
                System.out.println("W");
                System.out.println(x);
                System.out.println(y);
            }
            else if(split[0].equals("E") && (y+Integer.parseInt(split[1]) < realPark[0].length) && (!realPark[x][y+Integer.parseInt(split[1])].equals("X")) ) {
                y = y + Integer.parseInt(split[1]);
                System.out.println("E");
                System.out.println(x);
                System.out.println(y);
            }
        }
 */