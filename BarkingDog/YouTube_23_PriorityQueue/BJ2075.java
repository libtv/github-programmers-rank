package org.example.BarkingDog.YouTube_23_PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// N번째 큰 수 실버2
public class BJ2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                long temp = Long.parseLong(st.nextToken());
                if(pq.size() < n){
                    pq.add(temp);
                }
                if(pq.size() == n){
                    if(temp > pq.peek()){
                        pq.poll();
                        pq.add(temp);
                    }
                }
            }
        }
        System.out.println(pq.peek());
    }
}
