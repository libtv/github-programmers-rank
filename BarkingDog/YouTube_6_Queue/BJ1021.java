package org.example.BarkingDog.YouTube_6_Queue;

// https://www.acmicpc.net/problem/1021
// 회전하는 큐

import java.util.*;
import java.io.*;

public class BJ1021 {
    public static void main(String[] args) {
        // 지민이는 이 큐에서 다음과 같은 3가지 연산을 수행할 수 있다.
       /*
       첫 번째 원소를 뽑아낸다. 이 연산을 수행하면, 원래 큐의 원소가 a1, ..., ak이었던 것이 a2, ..., ak와 같이 된다.
       왼쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 a2, ..., ak, a1이 된다.
       오른쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 ak, a1, ..., ak-1이 된다.
        */

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int N = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }
        Deque<Integer> q = new LinkedList<>();
        for (int i = 1; i <= size; i++) {
            q.offer(i);
        }

        int sum = 0;
        for (int i = 0; i < list.size(); i++) { //  3 4 5 6 7 8 9 10 1
            int target = list.get(i);
            int big = q.size();
            int cnt = 0;
            int cnt2= 0;
            Deque<Integer> q2 = new LinkedList<>(q);
            while(q.size()==big){
                if(q.peek()==target){
                    q.poll();
                    break;
                }
                int temp = q.poll();
                q.offerLast(temp);
                cnt++;
            }
            while(q2.size()==big){
                if(q2.peek()==target){
                    q2.poll();
                    break;
                }
                int temp = q2.pollLast();
                q2.offerFirst(temp);
                cnt2++;
            }
            if(cnt > cnt2){
                sum = sum + cnt2;
                q = q2;
            }
            else{
                sum = sum + cnt;
            }
        }
        System.out.println(sum);
    }
}
// 1 2 3 4 5 6 7 8 9 10
// 2 3 4 5 6 7 8 9 10 1 (1) -> 3 4 5 6 7 8 9 10 1
// 1 3 4 5 6 7 8 9 10 (2)
// 10 1 3 4 5 6 7 8 9 (3)
// 9 10 1 3 4 5 6 7 8 (4) ->  10 1 3 4 5 6 7 8
// 8 10 1 3 4 5 6 7 (5)
// 7 8 10 1 3 4 5 6 (6)
// 6 7 8 10 1 3 4 5 (7)
// 5 6 7 8 10 1 3 4 (8)

