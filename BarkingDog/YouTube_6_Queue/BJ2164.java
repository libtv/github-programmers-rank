package BarkingDog.YouTube_6_Queue;

// https://www.acmicpc.net/problem/2164
// 카드2 실버4

import java.util.*;
import java.io.*;
public class BJ2164 {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        int N = sc.nextInt();

        for (int i = 1; i <= N ; i++) {
            queue.offer(i);
        }
        while (queue.size() > 1){
            // 1. 제일 위에 있는 카드를 바닥에 버리기
            queue.poll();
            if(queue.size()==1){
                break;
            }
            // 2.
            int temp = queue.poll();
            queue.offer(temp);
        }
        System.out.println(queue.peek());
    }
}
// 각각의 카드는 차례로 1부터 N까지의 번호가 붙어 있으며
// 1번 카드가 제일 위에, N번 카드가 제일 아래인 상태로 순서대로 카드가 놓여 있다.
// 이제 다음과 같은 동작을 카드가 한 장 남을 때까지 반복하게 된다
// 우선, 제일 위에 있는 카드를 바닥에 버린다.
// 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.