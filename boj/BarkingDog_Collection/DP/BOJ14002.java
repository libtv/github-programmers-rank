package boj.BarkingDog_Collection.DP;

// 가장 긴 증가하는 부분 수열 4
import java.io.*;
import java.util.*;
public class BOJ14002 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] DP = new int[n+1][3];  // [0] = 이번 숫자 [1] = 전 index [2] = 길이 기록
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            DP[i][0] = Integer.parseInt(st.nextToken());
            int max = 0;
            for (int j = i - 1; j >=1 ; j--) {
                if(DP[j][0] < DP[i][0] && max < DP[j][2]){
                    DP[i][1] = j;
                    DP[i][2] = DP[j][2] + 1;
                    max = DP[j][2];
                }
            }
            if(DP[i][2] == 0){
                DP[i][1] = i;
                DP[i][2] = 1;
            }
        }
        int [] max = Arrays.stream(DP).max(
                (o1, o2)->{
                    return o1[2] - o2[2];
                }
        ).get();
        System.out.println(max[2]);
        if(max[2] == 1){
            System.out.println(max[0]);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(" ").append(max[0]);
        int start = max[1];
        while (true){
            int temp = start;
            start = DP[start][1];
            if(temp == start){
                sb.insert(0, DP[temp][0]);
                break;
            }
            sb.insert(0, DP[temp][0]);
            sb.insert(0, " ");
        }
        System.out.println(sb);
    }
}
