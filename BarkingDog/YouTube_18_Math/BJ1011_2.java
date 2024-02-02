package org.example.BarkingDog.YouTube_18_Math;

import java.io.*;

public class BJ1011_2 {
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
            long distance = y - x;
            int max = (int)Math.sqrt(distance);
            int count = 0;
            if(distance == max * max){
                count = max * 2 -1;
            }
            else if( max * max < distance && distance <= max * max + max ){
                count = max * 2;
            }
            else{
                count = max * 2 + 1;
            }
            sb.append(count).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
/* 규칙 찾기
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

max = 2 기준
4     count: 3
5, 6  count: 4
7, 8  count: 5
 */