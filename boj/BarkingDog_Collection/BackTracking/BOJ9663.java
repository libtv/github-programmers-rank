package org.example.boj.BarkingDog_Collection.BackTracking;

// N-Queen 골드4
import java.util.*;
public class BOJ9663 {
    static int n; static int answer;
    static boolean [] col; static boolean [] Up;
    static boolean [] Down; static boolean [] MinusDown;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        col = new boolean[n];  Down = new boolean[n * 2];
        Up = new boolean[n * 2]; MinusDown = new boolean[n * 2];
        BackTracking(0);
        System.out.println(answer);
    }
    public static void BackTracking(int count){
        if(count == n){
            answer++;
        }
        for (int i = 0; i < n ; i++) { // cnt 는 행을 의미한다. i = 열을 의미
            if(count - i < 0){
                if(col[i] || MinusDown[Math.abs(count - i)] || Up[count + i]) continue;
                col[i] = true; MinusDown[Math.abs(count - i)] = true; Up[count+i] = true;
                BackTracking(count + 1);
                col[i] = false; MinusDown[Math.abs(count - i)] = false; Up[count+i] = false;
            }
            else if(count - i >= 0){
                if(col[i] || Down[count - i] || Up[count + i]) continue;
                col[i] = true; Down[Math.abs(count - i)] = true; Up[count+i] = true;
                BackTracking(count + 1);
                col[i] = false; Down[Math.abs(count - i)] = false; Up[count+i] = false;
            }
        }
    }
}
/*
3 * 3 배열

0,0 0,1 0,2          -2 -1 0 1 2
1,0 1,1 1,2
2,0 2,1 2,2

 */