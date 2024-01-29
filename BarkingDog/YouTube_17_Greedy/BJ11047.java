package org.example.BarkingDog.YouTube_17_Greedy;
// 동전 0 실버4

import java.io.*;
import java.util.StringTokenizer;
public class BJ11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [] coin = new int[N];

        for (int i = 0; i < N ; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        while (true){
            if(K == 0){
                break;
            }
            for (int i = N-1; i >=0 ; i--) {
                if(K / coin[i] > 0){
                    int temp = K / coin[i];
                    K -= coin[i] * temp;
                    cnt += temp;
                }
            }
        }
        bw.write(Integer.toString(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
 */

/* 방법1
        while (true){
            if(K == 0){
                break;
            }
            for (int i = N-1; i >=0 ; i--) {
                if(K / coin[i] > 0){
                    int temp = K / coin[i];
                    K -= coin[i] * temp;
                    cnt += temp;
                }
            }
        }
 */
/*
/* 방법2
        while (true){
            if(K == 0){
                break;
            }
            for (int i = N-1; i >=0 ; i--) {
                if(K >= coin[i]){
                    K -= coin[i];
                    cnt++;
                    break;
                }
            }
        }
 */
