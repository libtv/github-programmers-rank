package BarkingDog.YouTube_23_PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 파일 합치기3 골드4
public class BJ13975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-->0){
            PriorityQueue<Long> pq = new PriorityQueue<>();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            long sum = 0;
            while (n-->0){
                pq.add(Long.parseLong(st.nextToken()));
            }
            while (pq.size() > 1){
                long temp = pq.poll();
                temp += pq.poll();
                sum += temp;
                pq.add(temp);
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
/*
소설가인 김대전은 소설을 여러 장(chapter)으로 나누어 쓰는데, 각 장은 각각 다른 파일에 저장하곤 한다
30 + 30 = 60
40 + 50 = 90
60 + 90 = 150
= 300

 */