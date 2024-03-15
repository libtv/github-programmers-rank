package boj.BarkingDog_Collection.Deque;

import java.io.*;
import java.util.*;
// 회전하는 큐 실버3
public class BOJ1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> dq = new LinkedList<>();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= n; i++){
            dq.addLast(i);
        }
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        while (k-->0){
            int target = Integer.parseInt(st.nextToken());
            if(dq.peekFirst() == target){
                dq.pollFirst();
            }
            else{
               int idx = dq.indexOf(target);
               if(idx <= dq.size()/2){
                   while (dq.peekFirst()!=target){
                       dq.addLast(dq.pollFirst());
                       sum++;
                   }
               }
               else{
                   while (dq.peekFirst()!=target){
                       dq.addFirst(dq.pollLast());
                       sum++;
                   }
               }
               dq.pollFirst();
            }
        }
        System.out.println(sum);
    }
}
