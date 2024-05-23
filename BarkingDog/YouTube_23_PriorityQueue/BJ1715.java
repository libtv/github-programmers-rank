package BarkingDog.YouTube_23_PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 카드 정렬하기 골드4
public class BJ1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 최소힙
        while (n-- > 0) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        long sum = 0;
        while (pq.size() > 1){
            int temp = pq.poll();
            temp += pq.poll();
            sum += temp;
            pq.add(temp);
        }
        System.out.println(sum);
    }
}
/*
30 + 60 + 100
190

10 + 20 = 30
30 + 30 = 60
60 + 40 = 100
190


 */