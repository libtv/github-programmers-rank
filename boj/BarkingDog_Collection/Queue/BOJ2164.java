package boj.BarkingDog_Collection.Queue;

import java.util.*;
import java.io.*;
// 카드2 실버4
public class BOJ2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i++){
            q.add(i);
        }
        while (q.size() > 1){
            q.poll();
            int target = q.poll();
            q.add(target);
        }
        System.out.println(q.peek());
    }
}
