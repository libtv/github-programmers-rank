package boj.BarkingDog_Collection.PriorityQueue;

// N번째 큰 수 실버2

import java.util.*;
import java.io.*;
public class BOJ2075 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> set = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n ; j++) {
               set.add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < n; i++) {
            if(i == n -1){
                System.out.println(set.peek());
            }
            else set.poll();
        }
    }
}
/*
1500 * 1500 = 10000 * 225 = 2250000 // 삽입에 O(log N) +  O(1) * N

걍 우선순위 큐 활용하면 끝


 */