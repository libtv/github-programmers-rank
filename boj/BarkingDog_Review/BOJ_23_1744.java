package boj.BarkingDog_Review;

// 수 묶기
import java.io.*;
import java.util.*;
public class BOJ_23_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] memo = new int[3];

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->-(o1-o2));

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            pq.add(input);
            if(input == 0) memo[1]++;
            else if(input > 0) memo[2]++;
            else memo[0]++;
        }
        int sum = 0;
        int cnt = 0;
        while (!pq.isEmpty()){
            int cur = pq.poll();
            if(pq.isEmpty()){
                if(cnt == 0){
                    sum += cur;
                }
                break;
            }
            else{
                if(cur > 0){
                    memo[2]--;
                    if(memo[2] > 0){
                        memo[2]--;
                        if(pq.peek() > 1){
                            sum += (cur * pq.poll());
                        }
                        else sum += cur + pq.poll();
                    }
                    else sum += cur;
                }
                else if(cur == 0){
                    memo[1]--;
                    if(memo[0] > 0){
                        if(memo[0] % 2 == 1 && cnt == 0){
                            cnt = 1;
                        }
                    }
                }
                else{
                    memo[0]--;
                    if(memo[0] > 0){
                        if(cnt > 0){
                            cnt = 0;
                        }
                        else{
                            if(memo[0] % 2 == 1){
                                memo[0]--;
                                sum += (cur * pq.poll());
                            }
                            else sum += cur;
                        }
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
