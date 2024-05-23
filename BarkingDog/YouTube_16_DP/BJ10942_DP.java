package BarkingDog.YouTube_16_DP;

import java.io.*;
import java.util.StringTokenizer;

public class BJ10942_DP{

    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //  EX) DP[1][3] = 1부터 3까지 팰린드롭인지 아닌지
        int[][] DP = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            DP[i][i] = 1;
        }
        for (int i = 1; i <= N-1; i++) {
            if(arr[i] == arr[i+1]){
                DP[i][i+1] = 1;
            }
        }
        for (int i = 2; i < N; i++) {
            for (int j = 1; j <= N-i; j++) {
                if(arr[j] == arr[j+i] && DP[j+1][j+i-1] == 1){
                    DP[j][j+i] = 1;
                }
            }
        }
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String[] split2 = br.readLine().split(" ");
            int start = Integer.parseInt(split2[0]);
            int end = Integer.parseInt(split2[1]);
            sb.append(DP[start][end]);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
