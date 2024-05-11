package boj.BarkingDog_Collection.PriorityQueue;

// 최소 힙 실버2
import java.io.*;
import java.util.*;
public class BOJ1927 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-->0){
            int action = Integer.parseInt(br.readLine());
            if(action == 0){
                if(pq.isEmpty()){
                    sb.append(0);
                }
                else{
                    sb.append(pq.poll());
                }
                sb.append("\n");
            }
            else{
                pq.add(action);
            }
        }
        System.out.println(sb);
    }
}
