package boj.BarkingDog_Review;

// 택배                 // 11:10 시작 11:35 끝
import java.util.*;
import java.io.*;
public class BOJ_6_8980 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 마을 개수
        int capacity = Integer.parseInt(st.nextToken()); // 트럭 용량
        int info = Integer.parseInt(br.readLine()); // 택배 정보
        ArrayList<int []> list = new ArrayList<>();  // 0 시작 마을 1 도착 마을 2 택배 개수
        while (info --> 0){
            st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        Collections.sort(list, (o1,o2)->{
            if(o1[1] != o2[1]) return o1[1] - o2[1];
            else{
                if(o1[0] != o2[0]) return o1[0] - o2[0];
                else return -(o1[2]-o2[2]);
            }
        });
        // 빨리 끝나는 마을 순서 -> 택배 용량 -> 빨리 시작하는 마을 순서로 정렬
        int [] memo = new int[n+1];
        int sum = 0;
        for (int[] ints : list) {
            boolean flag = true;
            int min = Integer.MAX_VALUE;
            for (int i = ints[0]; i < ints[1]; i++) {
                if(memo[i] >= capacity){
                    flag = false;
                    break;
                }
                min = Math.min(min, capacity - memo[i]);
            }
            if(!flag) continue;

            min = Math.min(min, ints[2]);
            for (int i = ints[0]; i < ints[1]; i++) {
                memo[i] += min;
            }
            sum += min;
        }
        System.out.println(sum);
    }
}
