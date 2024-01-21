package org.example.BarkingDog.YouTube_13_Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/13335
// 트럭 실버1
public class BJ13335 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;  // 트럭의 수
    static int W;  // 다리의 길이
    static int L;  // 다리의 최대하중
    static int [] Trucks; // 트럭의 순서
    static int answer; // 최단시간
    public static void main(String[] args) throws IOException {
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        W = Integer.parseInt(split[1]);
        L = Integer.parseInt(split[2]);
        Trucks = new int[N];

        String[] split2 = br.readLine().split(" ");
        for (int i = 0; i < N ; i++) {
            Trucks[i] = Integer.parseInt(split2[i]);
        }
        answer = func();
        System.out.println(answer);
    }

    public static int func(){
        int time = 1;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        int cnt = 1;    // arr의 위치를 표시하기 위한 cnt
        int current = Trucks[0]; // 현재의 다리에 있는 트럭의 무게

        q1.offer(1 + W);
        q2.offer(Trucks[0]);

        while (!q1.isEmpty()){
            time++;

            if(q1.peek() == time){
                q1.poll();
                current -= q2.poll();
            }

            if(cnt <= N-1){
                if(q1.size() < W && current + Trucks[cnt] <= L){
                    q1.offer(time + W);
                    q2.offer(Trucks[cnt]);
                    current += Trucks[cnt];
                    cnt++;
                }
            }
        }

        return time;
    }
}



/* 문제 설명
다리의 길이와 다리의 최대하중, 그리고 다리를 건너려는 트럭들의 무게가 순서대로 주어졌을 때, 모든 트럭이 다리를 건너는 최단시간을 구하는 프로그램을 작성하라.
트럭의 순서는 바꿀 수 없으며, 트럭의 무게는 서로 같지 않을 수 있다.

n은 다리를 건너는 트럭의 수, w는 다리의 길이, 그리고 L은 다리의 최대하중을 나타낸다.

 */

/* 문제 접근
1. 큐1에는 트럭이 나가야 하는 시간
2. 큐2에는 트럭의 무게를 넣는다.

만약 큐의 사이즈가 w보다 작고 다리에 있는 무게와 들어올 값을 더 했을 때 L(최대하중) 보다 작으면

큐1의 peek()가 현재 시간과 동일하다면
큐1 pop
큐2 pop 현재 다리에 있는 무게에서 큐2 pop한 값을 빼준다.

큐 1개로 해결 가능 class를 하나 만들어서
나가야 하는 시간 , 무게를 넣어준다.

시간은?


 */