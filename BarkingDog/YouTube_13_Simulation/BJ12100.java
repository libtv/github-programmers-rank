package BarkingDog.YouTube_13_Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/12100
// 2048 (Easy) 골드2
public class BJ12100 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] map;
    static int[] arr;
    // static int count;
    static int max;
    // 왼쪽 오른쪽 위로 아래로 순서대로
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        arr = new int[5];
        max = 0;
        for (int i = 0; i < N ; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < N ; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
        // System.out.println(Arrays.deepToString(map)); 입력값 체크
        func(0);
        // System.out.println(count);
        // System.out.println((int)Math.pow(4, 5)); 둘 다 1024로 동일
        System.out.println(max);
    }
    public static void func(int depth){
        if(depth == 5){
            // System.out.println(Arrays.toString(arr));
            // count++;
            int temp = find(arr);
            if(temp > max){
                max = temp;
            }
            return;
        }
        for (int i = 1; i <= 4 ; i++) {
            arr[depth] = i;
            func(depth + 1);
        }
    }
    public static int find(int[] arr){
        int answer = 0;

        int[][] copyMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N ; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
        for (int i = 0; i < 5 ; i++) { // 1: 왼쪽 2: 오른쪽 3: 위로 4: 아래로
            int temp = arr[i];
            ArrayList<Integer> list = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            if( temp == 1 ){ // 오른쪽에서 왼쪽으로
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        if(copyMap[j][k] > 0){
                            stack.push(copyMap[j][k]);
                        }
                    }
                    while (!stack.isEmpty()){
                        int cur = stack.pop();
                        if(stack.size() >= 1){
                            if(stack.peek() == cur){
                                stack.pop();
                                list.add(cur * 2);
                            }
                            else{
                                list.add(cur);
                            }
                        }
                        else{
                            list.add(cur);
                        }
                    }
                    int check = list.size();
                    for (int k = 0; k < check ; k++) {
                        copyMap[j][k] = list.get(k);
                    }
                    for (int k = check; k < N ; k++) {
                        copyMap[j][k] = 0;
                    }
                    list.clear();
                }
            }
            else if( temp == 2 ){ // 왼쪽에서 오른쪽으로 -> 오른쪽부터 검사
                for (int j = 0; j < N; j++) {
                    for (int k = N-1; k >=0 ; k--) {
                        if(copyMap[j][k] > 0){
                            stack.push(copyMap[j][k]);
                        }
                    }
                    while (!stack.isEmpty()){
                        int cur = stack.pop();
                        if(stack.size() >= 1){
                            if(stack.peek() == cur){
                                stack.pop();
                                list.add(cur * 2);
                            }
                            else{
                                list.add(cur);
                            }
                        }
                        else{
                            list.add(cur);
                        }
                    }
                    int check = list.size();
                    int cnt = 0;
                    for (int k = N-1; k > N-1-check; k--) {
                        copyMap[j][k] = list.get(cnt);
                        cnt++;
                    }
                    for (int k = N-1-check; k >=0 ; k--) {
                        copyMap[j][k] = 0;
                    }
                    list.clear();
                }
            }
            else if( temp == 3 ){ // 아래에서 위로
                for (int j = 0; j < N ; j++) {
                    for (int k = 0; k < N ; k++) {
                        if(copyMap[k][j] > 0){
                            stack.push(copyMap[k][j]);
                        }
                    }
                    while (!stack.isEmpty()){
                        int cur = stack.pop();
                        if(stack.size() >= 1){
                            if(stack.peek() == cur){
                                stack.pop();
                                list.add(cur * 2);
                            }
                            else{
                                list.add(cur);
                            }
                        }
                        else{
                            list.add(cur);
                        }
                    }
                    int check = list.size();
                    for (int k = 0; k < check; k++) {
                        copyMap[k][j] = list.get(k);
                    }
                    for (int k = check; k < N ; k++) {
                        copyMap[k][j] = 0;
                    }
                    list.clear();
                }
            }
            else if( temp == 4 ){ // 위에서 아래로
                for (int j = 0; j < N ; j++) {
                    for (int k = N-1; k >=0 ; k--) {
                        if(copyMap[k][j] > 0){
                            stack.push(copyMap[k][j]);
                        }
                    }
                    while (!stack.isEmpty()){
                        int cur = stack.pop();
                        if(stack.size() >= 1){
                            if(stack.peek() == cur){
                                stack.pop();
                                list.add(cur * 2);
                            }
                            else{
                                list.add(cur);
                            }
                        }
                        else{
                            list.add(cur);
                        }
                    }
                    int check = list.size();
                    int cnt = 0;
                    for (int k = N-1; k > N-1-check ; k--) {
                        copyMap[k][j] = list.get(cnt);
                        cnt++;
                    }
                    for (int k = N-1-check; k >=0 ; k--) {
                        copyMap[k][j] = 0;
                    }
                    list.clear();
                }
            }
        }
        // 가장 큰 블록 찾기
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < N; j++) {
                if(copyMap[i][j] > answer){
                    answer = copyMap[i][j];
                }
            }
        }
        return  answer;
    }
}



/*
문제 설명
 최대 5번 이동해서 만들 수 있는 가장 큰 블록의 값을 구하는 프로그램을 작성하시오.
 마지막으로, 똑같은 수가 세 개가 있는 경우에는 이동하려고 하는 쪽의 칸이 먼저 합쳐진다.
 */

/* 3:05 pm 시작 ~

문제 접근
백트래킹 + 스택 활용

5번 상하좌우 가능하니까 조합의 수는 4의5승이다.
각 조합의 경우의수 중에서 가장 큰 값을 찾는다.

 */
