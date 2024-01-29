package org.example.BarkingDog.YouTube_17_Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 카드 합체 놀이 실버1
public class BJ15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        long [] arr = new long[N];
        for (int i = 0; i < N ; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        int cnt = 0;
        while (cnt!=M){
            cnt++;
            Arrays.sort(arr);
            long temp = arr[0] + arr[1];
            arr[0] = temp;
            arr[1] = temp;
        }
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }
        bw.write(Long.toString(sum));
        bw.flush();
        bw.close();
        br.close();
    }
}

// 1 2 3 4
// 3 3 3 4
// 6 6 3 4