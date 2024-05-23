package boj.BarkingDog_Review;

// 강의실 배정
import java.io.*;
import java.util.*;
public class BOJ_37_11000 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        Collections.sort(list, (o1, o2)->{
            if(o1[0]!=o2[0]) return o1[0] - o2[0];
            else return o1[1] - o2[1];
        });

        int max = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < list.size(); i++){
            int [] temp = list.get(i);
            if(pq.isEmpty()){
                pq.add(temp[1]);
            }
            else if(pq.peek() <= temp[0]){
                pq.poll();
                pq.add(temp[1]);
            }
            else{
                pq.add(temp[1]);
                max = Math.max(max, pq.size());
            }
        }
        System.out.println(max);
    }
}
