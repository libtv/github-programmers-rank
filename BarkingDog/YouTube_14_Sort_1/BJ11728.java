package BarkingDog.YouTube_14_Sort_1;

import java.io.*;
import java.util.Arrays;

// https://www.acmicpc.net/problem/11728
// 배열 합치기 실버5
public class BJ11728 {

    static int N;
    static int M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        // 첫째 줄에 배열 A의 크기 N, 배열 B의 크기 M이 주어진다. (1 ≤ N, M ≤ 1,000,000)
        String [] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        int [] arr1 = new int[N];
        String [] split2 = br.readLine().split(" ");
        for (int i = 0; i < N ; i++) {
            arr1[i] = Integer.parseInt(split2[i]);
        }
        int [] arr2 = new int[M];
        String [] split3 = br.readLine().split(" ");
        for (int i = 0; i < M ; i++) {
            arr2[i] = Integer.parseInt(split3[i]);
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Merge Sort는 정렬 이후에 가능하다.
        int [] arr3 = new int[N + M];
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        for (int i = 0; i < N + M; i++) {
            if(cnt1 <= N-1 && cnt2 <= M-1){
                if(arr1[cnt1] < arr2[cnt2]){
                    arr3[cnt3] = arr1[cnt1];
                    cnt3++;
                    cnt1++;
                }
                else{
                    arr3[cnt3] = arr2[cnt2];
                    cnt3++;
                    cnt2++;
                }
            }
            else if(cnt1 <= N-1 && cnt2 > M-1){
                arr3[cnt3] = arr1[cnt1];
                cnt1++;
                cnt3++;
            }
            else{
                arr3[cnt3] = arr2[cnt2];
                cnt2++;
                cnt3++;
            }
        }
        for (int i = 0; i < N+M; i++) {
            bw.write(arr3[i] +" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
