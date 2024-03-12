package org.example.boj.BarkingDog_Collection.Simulation;

// 연산자 끼워넣기 실버1
import java.util.*;
import java.io.*;
public class BOJ14888 {
    static long max; static long min; static boolean flag = true;
    static long[] arr; static int n; static int [] input; static int[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 수의 개수
        arr = new long[n];
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        input = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4 ; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        visited = new int[4];
        BackTracking(arr[0], 1);
        System.out.println(max);
        System.out.println(min);
    }
    public static void BackTracking(long cur, int idx){
        if(idx == n){
            if(flag){
                max = cur;
                min = cur;
                flag = false;
            }
            max = Math.max(max, cur);
            min = Math.min(min, cur);
            return;
        }
        long temp = arr[idx];
        for (int i = 0; i < 4; i++) {
            if(input[i] > visited[i]){
                switch (i){
                    case 0 : {
                        visited[i]++;
                        BackTracking(cur + temp, idx + 1);
                        visited[i]--;
                        break;
                    }
                    case 1 : {
                        visited[i]++;
                        BackTracking(cur - temp, idx + 1);
                        visited[i]--;
                        break;
                    }
                    case 2 : {
                        visited[i]++;
                        BackTracking(cur * temp, idx + 1);
                        visited[i]--;
                        break;
                    }
                    case 3 : {
                        visited[i]++;
                        BackTracking(cur / temp, idx + 1);
                        visited[i]--;
                        break;
                    }
                }
            }
        }
    }
}
