package org.example.BarkingDog.YouTube_3_Array;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1475
// 방 번호
public class BJ_1475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();

        int [] array = new int[10]; // 0 ~ 9
        for (int i = 0; i < N.length() ; i++) {
            int temp =  N.charAt(i) - '0';
            array[temp]+=1;
        }

        while(array[6]!=array[9]){
            if(Math.abs(array[6]- array[9]) == 1) {
                break;
            }
            if(array[6] > array[9]){
                array[6] = array[6] - 1;
                array[9] = array[9] + 1;
            }
            else if(array[6] < array[9]){
                array[6] = array[6] + 1;
                array[9] = array[9] - 1;
            }
        }
        int max = 0;
        for (int i = 0; i <array.length ; i++) {
            if(array[i] > max){
                max = array[i];
            }
        }
        System.out.println(max);
    }
}
