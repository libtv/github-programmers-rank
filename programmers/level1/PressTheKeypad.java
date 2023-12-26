package org.example.programmers.level1;

import java.util.ArrayList;
import java.util.HashMap;

// https://school.programmers.co.kr/learn/courses/30/lessons/67256
// 2020 카카오 인턴십 키패드 누르기
public class PressTheKeypad {
    public static void main(String[] args) {

    }
    public String solution(int[] numbers, String hand) {

        int[][] arr =new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};

        int[] left = {3,0};
        int[] right = {3,2};

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numbers.length; i++){
            int number = numbers[i];
            if(number == 0){
                number = 11;
            }
            if(number == 1 || number == 4 || number == 7){
                sb.append("L");
                for(int j = 0; j < 4; j++){
                    for(int k = 0; k < 3; k++){
                        if(arr[j][k] == number){
                            left[0] = j;
                            left[1] = k;
                        }
                    }
                }
            }
            else if (number == 3 || number == 6 || number == 9){
                sb.append("R");
                for(int j = 0; j < 4; j++){
                    for(int k = 0; k < 3; k++){
                        if(arr[j][k] == number){
                            right[0] = j;
                            right[1] = k;
                        }
                    }
                }
            }
            else {
                for(int j = 0; j < 4; j++){
                    for(int k = 0; k < 3; k++){
                        if(arr[j][k] == number){
                            int Llength = Math.abs(left[0]-j) + Math.abs(left[1]-k);
                            int Rlength = Math.abs(right[0]-j) + Math.abs(right[1]-k);
                            if(Llength == Rlength && hand.equals("right")){
                                sb.append("R");
                                right[0] = j;
                                right[1] = k;
                            }
                            else if(Llength == Rlength && hand.equals("left")){
                                sb.append("L");
                                left[0] = j;
                                left[1] = k;
                            }
                            else if(Llength > Rlength){
                                sb.append("R");
                                right[0] = j;
                                right[1] = k;
                            }
                            else{
                                sb.append("L");
                                left[0] = j;
                                left[1] = k;
                            }
                        }
                    }
                }
            }
            // System.out.println("left = " + left[0] + left[1]);
            // System.out.println("right = " + right[0] + right[1]);
        }
        return sb.toString();
    }

}
