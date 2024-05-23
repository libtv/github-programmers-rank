package boj.BarkingDog_Collection.Greedy;

// 강의실 배정 골드5
import java.io.*;
import java.util.*;
public class BOJ11000 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long [][] data = new long [n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            data[i][0] = Long.parseLong(st.nextToken()); // start time
            data[i][1] = Long.parseLong(st.nextToken()); // end   time
        }
        // 빨리 시작하는 순서 -> 빨리 끝나는 순서
        Arrays.sort(data, (o1,o2)->{
            if(o1[0] != o2[0]) return (int)(o1[0] - o2[0]);
            return (int)(o1[1] - o2[1]);
        });
        int min = 0; // 필요한 강의실의 개수
        PriorityQueue<long []> q = new PriorityQueue<>(((o1, o2) -> (int)(o1[1] - o2[1])));
        for (int i = 0; i < n; i++) {
            if(q.isEmpty()){
                q.add(data[i]);
            }
            else{
                if(q.peek()[1] <= data[i][0]) q.poll();
                q.add(data[i]);
            }
            if(min < q.size()){
                min = q.size();
            }
        }
        System.out.println(min);
    }
}
