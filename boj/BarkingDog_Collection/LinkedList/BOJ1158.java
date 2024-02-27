package org.example.boj.BarkingDog_Collection.LinkedList;

// 요세푸스 문제 실버4
import java.util.*;
import java.io.*;
public class BOJ1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (!q.isEmpty()){
            for (int i = 0; i < k - 1; i++) {
                q.add(q.poll());
            }
            if(q.size() == 1){
                sb.append(q.poll()).append(">");
                break;
            }
            sb.append(q.poll()).append(", ");
        }
        System.out.println(sb);
    }
}
// 5000 * 5000 = 25/000/000