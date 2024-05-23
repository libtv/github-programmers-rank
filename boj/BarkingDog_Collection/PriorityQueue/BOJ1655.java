package boj.BarkingDog_Collection.PriorityQueue;

// 가운데를 말해요 골드2
import java.util.*;
import java.io.*;
public class BOJ1655 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> max = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        /**
         * 항상 min에서 출력 홀수든 짝수든
         * min(max) <= max(min)
         */
        while (n-->0){
            int input = Integer.parseInt(br.readLine());

            if(min.size() == max.size()){
                min.add(input);
            }
            else max.add(input);

            // 이제 구조 변경
            if(!min.isEmpty() && !max.isEmpty()){
                while (min.peek() > max.peek()){
                    int min_out = min.poll();
                    int max_out = max.poll();
                    min.add(max_out);
                    max.add(min_out);
                }
            }
            sb.append(min.peek());
            sb.append("\n");
            System.out.println(min);
            System.out.println(max);
        }
        System.out.println(sb);
    }
}
/* 문제 설명

백준이가 말한 수 중에서 중간값을 말해야 한다. 만약, 그동안 백준이가 외친 수의 개수가 짝수개라면 중간에 있는 두 수 중에서 작은 수를 말해야 한다.

1, 5, 2, 10, -99, 7, 5를 순서대로 외쳤다고 하면, 동생은 1, 1, 2, 2, 2, 2, 5를 차례대로 말해야 한다.


 */