package boj.BarkingDog_Collection.PriorityQueue;

// 컵라면 골드2
import java.io.*;
import java.util.*;
public class BOJ1781 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        PriorityQueue<int []> pq = new PriorityQueue<>(
                (o1, o2)->{
                   if(o1[1] != o2[1]) return -(o1[1] - o2[1]);  // 데드라인이 빨리 끝나는 순서대로 데드라인이 똑같으면 더 큰 순서대로
                   return o1[0] - o2[0];
                }
        );
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            set.add(i);
        }
        int sum = 0;
        while (!pq.isEmpty()){
            int [] temp = pq.poll();
            int target = temp[0];
            Integer key = set.floor(target);
            if(key == null) continue;
            sum += temp[1];
            set.remove(Integer.valueOf(key));
        }
        System.out.println(sum);

    }
}
