package BarkingDog.YouTube_3_Array;

// https://www.acmicpc.net/problem/10808
// 알파벳 개수

// 배열만 사용해서 풀어보기

import java.util.*;
public class BJ_10808_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        int[] count = new int[26]; // a~z의 개수 확인용 int[0] = 'a' 개수  int[25] = 'z' 개수
        for(int i = 0; i < input.length(); i++) {
            char temp = input.charAt(i);
            count[temp-97] = count[temp-97] + 1;
        }
        for (int i = 0; i < count.length; i++) {
            System.out.print(count[i] + " ");
        }
    }
}
