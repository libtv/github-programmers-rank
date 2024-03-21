package boj.BarkingDog_Collection.Sort;

// 먹을 것인가 먹힐 것인가 실버3
import java.io.*;
import java.util.*;
public class BOJ7795 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (t-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken());
            ArrayList<Integer> list1 = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < a; i++) {
                list1.add(Integer.parseInt(st.nextToken()));
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->-(o1-o2));
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < b; i++) {
                pq.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(list1, Collections.reverseOrder());
            int sum = 0;
            for (int i = 0; i < list1.size(); i++) {
                int target = list1.get(i);
                while (!pq.isEmpty() && target <= pq.peek()){
                    pq.poll();
                }
                sum += pq.size();
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
/*
우선순위 큐에서 가장 큰 값들




 */