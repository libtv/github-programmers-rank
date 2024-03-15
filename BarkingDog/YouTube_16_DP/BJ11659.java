package BarkingDog.YouTube_16_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/11659
// 구간 합 구하기 4 실버3
public class BJ11659 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        int [] arr = new int[100001];

        String [] split2 = br.readLine().split(" ");
        for (int i = 1; i <= N ; i++) {
            arr[i] = Integer.parseInt(split2[i-1]);
        }

        // 1부터 시작

        int [] prefix = new int[100001];
        for (int i = 1; i <= N ; i++) {
            if(i == 1){
                prefix[1] = arr[1];
            }
            else if( i > 0){
                prefix[i] = prefix[i-1] + arr[i];
            }
        }
        //
        for (int i = 0; i < M; i++) {
            String[] split3 = br.readLine().split(" ");
            int a = Integer.parseInt(split3[0]);
            int b = Integer.parseInt(split3[1]);

            if(a == 1){
                System.out.println(prefix[b]);
            }
            else{
                System.out.println(prefix[b] - prefix[a-1]);
            }
        }
    }
}
/*
수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.
첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다. 둘째 줄에는 N개의 수가 주어진다.
수는 1,000보다 작거나 같은 자연수이다. 셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.



 */