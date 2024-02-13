package org.example.BarkingDog.YouTube_23_PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

// 절댓값 힙 실버1
public class BJ11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Long> pq = new PriorityQueue<>(new Comparator_2());
        while (N-->0){
            long input = Long.parseLong(br.readLine());
            if(input == 0){
                if(pq.isEmpty()){
                    sb.append("0").append("\n");
                }
                else{
                    sb.append(String.valueOf(pq.poll())).append("\n");
                }
            }
            else{
                pq.add(input);
            }
        }
        System.out.println(sb);
    }
}
class Comparator_2 implements Comparator<Long>{
    public int compare(Long o1, Long o2){
        if(Math.abs(o1) == Math.abs(o2)){
            return (int)(o1 - o2);
        }
        return (int)(Math.abs(o1) - Math.abs(o2));
    }
}

/*
1. 절댓값 힙은 다음과 같은 연산을 지원하는 자료구조이다.
2. 배열에서 절댓값이 가장 작은 값을 출력하고 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.

연산에 대한 정보를 나타내는 정수 x가 주어진다. 만약 x가 0이 아니라면 배열에 x라는 값을 넣는(추가하는) 연산이고, x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다.
입력되는 정수는 -2^31보다 크고, 2^31보다 작다.

 */