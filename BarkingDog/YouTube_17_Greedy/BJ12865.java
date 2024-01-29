package org.example.BarkingDog.YouTube_17_Greedy;

import java.io.*;
import java.util.*;

// 평범한 배낭 골드5
public class BJ12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] weights = new int[N+1]; // 물건의 무게
        int[] values = new int[N+1]; // 물건의 가치
        for (int i = 1; i <= N ; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken()); // 무게
            int b = Integer.parseInt(st2.nextToken()); // 가치
            weights[i] = a;
            values[i] = b;
        }
        int [][] DP = new int[N+1][K+1];
        for (int i = 1; i <= N; i++) {    // weights[1] = 6 values[1] = 13
            for (int j = 1; j <= K; j++) {
                if (weights[i] <= j) {
                    DP[i][j] = Math.max(DP[i-1][j], DP[i-1][j-weights[i]] + values[i]);
                } else {
                    DP[i][j] = DP[i-1][j];
                }
            }
        }
        // System.out.println(Arrays.deepToString(DP));
        bw.write(Integer.toString(DP[N][K]));
        bw.flush();
        bw.close();
        br.close();
    }
}

/* 잘못된 그리디 예시 문제

이 문제는 아주 평범한 배낭에 관한 문제이다.
한 달 후면 국가의 부름을 받게 되는 준서는 여행을 가려고 한다.
세상과의 단절을 슬퍼하며 최대한 즐기기 위한 여행이기 때문에, 가지고 다닐 배낭 또한 최대한 가치 있게 싸려고 한다.

준서가 여행에 필요하다고 생각하는 N개의 물건이 있다.
각 물건은 무게 W와 가치 V를 가지는데, 해당 물건을 배낭에 넣어서 가면 준서가 V만큼 즐길 수 있다.
아직 행군을 해본 적이 없는 준서는 최대 K만큼의 무게만을 넣을 수 있는 배낭만 들고 다닐 수 있다.

준서가 최대한 즐거운 여행을 하기 위해 배낭에 넣을 수 있는 물건들의 가치의 최댓값을 알려주자.

입력
첫 줄에 물품의 개수와 준서가 버틸 수 있는 무게가 주어진다.
 */

/*
4 7
6 13
4 8
3 6
5 12

준서의 가방이 버티는 무게 : 7

그리드로 풀면 가치가 가장 큰 12를 넣어서 최댓값이 12로 끝나지만

4 | 8 , 3 | 6 을 넣으면 무게는 가치합은 14이다.

어떻게 풀까?
DP로 푼다.

먼저 입력은 처음 준서 가방이 버티는 무게가 넘으면 넣지 않는다.

DP[K]는 가방에 K개를 넣었을 때 최대 가치값
DP[0] = 0
DP[1] = 12
DP[2] = 14
DP[3] XX
 */

/*  반례
5 7
4 10
1 5
3 20
2 6
5 10
output = 30
answer = 31




 */