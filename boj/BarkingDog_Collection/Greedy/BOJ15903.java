package boj.BarkingDog_Collection.Greedy;

// 카드 합체 놀이 실버1
import java.io.*;
import java.util.*;
public class BOJ15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 카드의 개수 n(2 ≤ n ≤ 1,000)
        int m = Integer.parseInt(st.nextToken()); // 카드 합체 m(0 ≤ m ≤ 15×n)

        // (1 ≤ ai ≤ 1,000,000)
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
             pq.add(Long.parseLong(st.nextToken()));
        }
        while (m-->0){
            if(pq.size() >= 2){
                long temp = pq.poll() + pq.poll();
                pq.add(temp);
                pq.add(temp);
            }
        }
        long sum = 0;
        while (!pq.isEmpty()){
            sum += pq.poll();
        }
        System.out.println(sum);
    }
}
/*

1. x번 카드와 y번 카드를 골라 그 두 장에 쓰여진 수를 더한 값을 계산한다. (x ≠ y)
2. 계산한 값을 x번 카드와 y번 카드 두 장 모두에 덮어 쓴다.

이 카드 합체를 총 m번 하면 놀이가 끝난다.
m번의 합체를 모두 끝낸 뒤, n장의 카드에 쓰여있는 수를 모두 더한 값이 이 놀이의 점수가 된다.
이 점수를 가장 작게 만드는 것이 놀이의 목표이다.

 */