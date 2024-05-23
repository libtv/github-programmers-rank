package boj.BarkingDog_Collection.Deque;

// 최솟값 찾기 플래티넘 5
import java.io.*;
import java.util.*;
public class BOJ11003 {
    static class node{
        long value; int idx;
        public node(long value, int idx){
            this.value = value; this.idx = idx;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        PriorityQueue<node> pq = new PriorityQueue<>((o1, o2)->(int)(o1.value- o2.value));
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            long temp = Long.parseLong(st.nextToken());
            pq.add(new node(temp, i));
            int check = i - l + 1;
            while (pq.peek().idx < check){
                pq.poll();
            }
            sb.append(pq.peek().value).append(" ");
        }
        System.out.println(sb);
    }
}
