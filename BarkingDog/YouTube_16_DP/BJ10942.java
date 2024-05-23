package BarkingDog.YouTube_16_DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10942
// 팰린드롬? 골드4
public class BJ10942 {

    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //  EX) DP[1][3] = 1부터 3까지 팰린드롭인지 아닌지

        // System.out.println(Arrays.deepToString(DP));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T ; i++) {
            String[] split2 = br.readLine().split(" ");
            int start = Integer.parseInt(split2[0]);
            int end   = Integer.parseInt(split2[1]);
            sb.append(check(start, end));
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
        /*  최악의 경우 2000 * 1000000 = 2000,000,000 => 20초 단순 for문으로 찾기 x
            자바는 2.5초까지 허용

            질문의 개수 1000000
            최악의 경우 수열이 2000
            while문 최악의 연산 500
            500 * 1000000 = 5억 하지만 1, 2000만 계속 들어오는 경우는 없다. 충분히 통과
         */
    }
    public static int check(int start, int end){
        boolean flag = true;
        while (start < end){
            if(arr[start] != arr[end]){
                flag = false;
                break;
            }
            start++;
            end--;
        }
        if(flag){
            return 1;
        }
        return 0;
    }
}
/*  시간초과 코드
public class BJ10942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        int [] arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(split[i-1]);
        }
        //  EX) DP[1][3] = 1부터 3까지 팰린드롭인지 아닌지

        int [][] DP = new int[N+1][N+1];
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 1; i <= N ; i++) {
            for (int j = i; j <= N ; j++) {
               sb.append(arr[j]);
               sb2.append(arr[j]);
               if(sb.reverse().toString().equals(sb2.toString())){
                   DP[i][j] = 1;
               }
               else{
                   DP[i][j] = 0;
               }
               sb.reverse();
            }
            sb.setLength(0);
            sb2.setLength(0);
        }
        // System.out.println(Arrays.deepToString(DP));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T ; i++) {
            String[] split2 = br.readLine().split(" ");
            int start = Integer.parseInt(split2[0]);
            int end   = Integer.parseInt(split2[1]);
            System.out.println(DP[start][end]);
        }

   }
}
 */

/* 시간초과 코드 2
public class BJ10942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        int [] arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(split[i-1]);
        }
        //  EX) DP[1][3] = 1부터 3까지 팰린드롭인지 아닌지

        int [][] DP = new int[N+1][N+1]; // 1 = 팰린드롭  0 = 팰린드롭 x

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i == j){
                    DP[i][j] = 1;
                    continue;
                }
                int left = i;
                int right = j;
                boolean flag = true;
                while (left < right){
                    if(arr[left]!=arr[right]){
                        flag = false;
                        break;
                    }
                    left++;
                    right--;
                }
                if(flag){
                    DP[i][j] = 1;
                }
                else{
                    DP[i][j] = 0;
                }
            }
        }


        // System.out.println(Arrays.deepToString(DP));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T ; i++) {
            String[] split2 = br.readLine().split(" ");
            int start = Integer.parseInt(split2[0]);
            int end   = Integer.parseInt(split2[1]);
            System.out.println(DP[start][end]);
        }

    }
}
 */