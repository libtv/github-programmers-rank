package BarkingDog.YouTube_23_PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

// 가운데를 말해요 골드2
public class BJ1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 1. pq는 내림차순 작은 숫자들
        // 2. pq는 오름차순 큰 숫자들
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(); // 오름차순
        StringBuilder sb = new StringBuilder();
        // 항상 pq1 size가 pq2 사이즈보다 크거나 같게 유지하기
        while (n-->0){
            int temp = Integer.parseInt(br.readLine());
            if(pq1.isEmpty()){
                pq1.add(temp);
            }
            else if(pq2.isEmpty()){
                if(temp >= pq1.peek()){
                    pq2.add(temp);
                }
                else{
                    pq2.add(pq1.poll());
                    pq1.add(temp);
                }
            }
            else if(pq1.size() == pq2.size()){
                if(temp <= pq1.peek() || pq2.peek() >= temp){
                    pq1.add(temp);
                }
                else if(pq2.peek() < temp){
                    pq1.add(pq2.poll());
                    pq2.add(temp);
                }
            }
            else if(pq1.size() > pq2.size()){
                if(temp <= pq1.peek()){
                    pq2.add(pq1.poll());
                    pq1.add(temp);
                }
                else if(temp > pq1.peek()){
                    pq2.add(temp);
                }
            }
            sb.append(pq1.peek()).append("\n");
        }
        System.out.println(sb);
    }
}
/*
백준이는 동생에게 "가운데를 말해요" 게임을 가르쳐주고 있다. 백준이가 정수를 하나씩 외칠때마다 동생은 지금까지 백준이가 말한 수 중에서
중간값을 말해야 한다. 만약, 그동안 백준이가 외친 수의 개수가 짝수개라면 중간에 있는 두 수 중에서 작은 수를 말해야 한다.
 */

/*
내림차순 pq1
오름차순 pq2

pq2는 항상 pq1에 있는 값보다 더 커야한다. 1 3    5
3 출력
1 2         4 5
2 출력
출력은 항상 pq1 peek()

값 삽입은 어떻게 하는가

4 4       5


 */