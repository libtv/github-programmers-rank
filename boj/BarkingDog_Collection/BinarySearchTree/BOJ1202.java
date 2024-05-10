package boj.BarkingDog_Collection.BinarySearchTree;

// 보석 도둑 골드2
import java.io.*;
import java.util.*;
public class BOJ1202 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 보석의 개수
        int k = Integer.parseInt(st.nextToken()); // 가방의 개수

        PriorityQueue<int[] > pq = new PriorityQueue<>((o1,o2) -> {
            if(o1[0] != o2[0]) return o1[0] - o2[0];
            return o2[1] - o1[1];
        });
        while (n-->0){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            pq.add(new int[]{m,v});
        }

        int [] bag = new int[k];
        for (int i = 0; i < k; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bag);
        PriorityQueue<Integer> big = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        for (int i = 0; i < k; i++) {
            int limit = bag[i];
            while (!pq.isEmpty() && pq.peek()[0] <= limit){ // 현재 가방의 무게에서 담는게 가능한 보석들이면 전부 넣기
                big.add(pq.poll()[1]);
            }
            if(big.isEmpty()) continue;
            sum += big.poll();
        }
        System.out.println(sum);
    }
}
/*
현재 가방의 허용 무게 보다 작으면서 가장 큰 값을 찾는게 빠른 자료구조?

 */