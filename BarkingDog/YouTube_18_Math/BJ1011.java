package org.example.BarkingDog.YouTube_18_Math;

import java.io.*;

// Fly me to the Alpha Centauri 골드5
public class BJ1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String[] split = br.readLine().split(" ");
            long x = Long.parseLong(split[0]);
            long y = Long.parseLong(split[1]);

            // 전체 이동거리 = y - x
            long entire = y - x;
            if(entire <= 3){
                sb.append(entire).append("\n");
            }
            else{
                int max = 0;
                int [] DP = new int[100000000];
                // 최대 숫자 찾기
                for (int j = 2; j <= entire; j++) {
                    long sum = 0;
                    DP[j-1] = (j-1) * 2;
                    DP[j-1] += DP[j-2];
                    sum += DP[j-1];
                    sum += j;
                    if(sum > entire){
                        max = j - 1;
                        break;
                    }
                    else if(sum == entire){
                        max = j;
                        break;
                    }
                }
                int temp = DP[max-1] + max;
                int count = (max - 1) * 2 + 1;
                entire -= temp;
                System.out.println(max);
                for (int j = max; j >=1 ; j--) {
                    long tmp = entire / j;
                    if(tmp == 0){
                        continue;
                    }
                    count += tmp;
                    entire = entire % j;
                    if(entire == 0){
                        break;
                    }
                }
                sb.append(count).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
마지막은 1인 연속된 증가 감소 유지 수열
1 1 1      총 이동거리 : 3
1 2 1      총 이동거리 : 4
1 2 1 1    총 이동거리 : 5

 */

/* 16퍼에서 시간초과 코드
public class BJ1011 {
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String[] split = br.readLine().split(" ");
            long x = Long.parseLong(split[0]);
            long y = Long.parseLong(split[1]);

            // 전체 이동거리 = y - x
            long entire = y - x;
            if(entire <= 3){
              sb.append(entire).append("\n");
            }
            else{
                int max = 0;
                // 최대 숫자 찾기
                for (int j = 2; j <= entire; j++) {
                    long sum = 0;
                    for (int k = j-1; k >=1 ; k--) {
                        sum += k;
                    }
                    sum *= 2;
                    sum += j;
                    if(sum > entire){
                        max = j - 1;
                        break;
                    }
                    else if(sum == entire){
                        max = j;
                        break;
                    }
                }
                int temp = 0;
                int count = 0;
                for (int j = max-1; j >=1 ; j--) {
                    temp += j;
                    count++;
                }
                temp *= 2;
                temp += max;
                count *= 2;
                count ++;
                entire -= temp;
                while (entire!=0){
                    for (int j = max; j >=1 ; j--) {
                        long tmp = entire / j;
                        if(tmp == 0){
                            continue;
                        }
                        count += tmp;
                        entire = entire % j;
                        if(entire == 0){
                            break;
                        }
                    }
                }
                sb.append(count).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
 */

/*
distance 정리

1
max = 1
count : 1

2
max = 1
count : 2

3
max = 1
count : 3

4
max = 2
count : 3

5
max = 2
count : 4

6
max = 2
count : 4

7
max = 2
count : 5

8
max = 2
count : 5

9
max = 3
count : 5



 */


