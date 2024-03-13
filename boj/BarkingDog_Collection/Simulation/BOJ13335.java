package org.example.boj.BarkingDog_Collection.Simulation;

// 트럭 실버1
import java.io.*;
import java.util.*;
public class BOJ13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 트럭의 수
        int w = Integer.parseInt(st.nextToken()); // 다리의 길이
        int l = Integer.parseInt(st.nextToken()); // 다리의 최대하중
        st = new StringTokenizer(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n ; i++) {
            q.add(Integer.parseInt(st.nextToken()));
        }
        Queue<int[]> bridge = new LinkedList<>();

        int time = 0;
        int weight = 0;
        while (!q.isEmpty() || !bridge.isEmpty()){
            time++;
            if(!bridge.isEmpty() && bridge.peek()[0] == time){
                int [] temp = bridge.poll();
                weight -= temp[1];
            }
            if(!q.isEmpty() && q.peek() + weight <= l && bridge.size() + 1 <= w){
                int temp = q.poll();
                weight += temp;
                bridge.add(new int[]{time + w , temp});
            }
        }
        System.out.println(time);
    }
}
