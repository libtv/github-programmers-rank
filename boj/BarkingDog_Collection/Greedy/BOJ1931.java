package boj.BarkingDog_Collection.Greedy;

// 회의실 배정 실버1
import java.io.*;
import java.util.*;
public class BOJ1931 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] meeting = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meeting[i][0] = Integer.parseInt(st.nextToken());
            meeting[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(meeting, (o1,o2)->{
            if(o1[1] != o2[1]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        int time  = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(time <= meeting[i][0]){
                count++;
                time = meeting[i][1];
            }
        }
        System.out.println(count);

    }
}
