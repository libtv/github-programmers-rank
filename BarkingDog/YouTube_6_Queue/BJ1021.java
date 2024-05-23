package BarkingDog.YouTube_6_Queue;

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
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 1; i <= size; i++) {
            q.offer(i);
        }
        int cnt = 0;
        for (int i = 0; i < list.size(); i++) {
            int target = list.get(i);
            int a = q.size();
            int idx = q.indexOf(target);
            boolean flag = false;
            if(idx <= a/2){
                flag = true;
            }
            else if(idx > a/2){
                flag = false;
            }
            while(a==q.size()){
                if(q.peek()==target){
                    q.poll();
                    break;
                }
                if(flag){
                    int temp = q.pollFirst();
                    q.offerLast(temp);
                    cnt++;
                }
                else if(!flag){
                    int temp = q.pollLast();
                    q.offerFirst(temp);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
/*
[2, 3, 4, 5, 6, 7, 8, 9, 10]

10 2 3 4 5 6 7 8 9
9 10 2 3 4 5 6 7 8
8 9 10 2 3 4 5 6 7
7 8 9 10 2 3 4 5 6
6 7 8 9 10 2 3 4 5

 */

