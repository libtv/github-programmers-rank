package org.example.BarkingDog.YouTube_18_Math;

import java.io.*;
import java.util.*;

// GCD 합 실버4
public class BJ9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();
            int N = Integer.parseInt(st.nextToken());
            for (int j = 0; j < N ; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            long sum = 0;
            for (int j = 0; j < list.size(); j++) {
                for (int k = j+1; k < list.size(); k++) {
                    int temp1 = list.get(j);
                    int temp2 = list.get(k);
                    if(temp1 >= temp2){
                        sum += GCD(temp1, temp2);
                    }
                    else if(temp2 > temp1){
                        sum += GCD(temp2, temp1);
                    }
                }
            }
            // System.out.println(Arrays.deepToString(visited));
            sb.append(sum).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
    public static int GCD(int a, int b){
        if(b == 0){
            return a;
        }
        else{
            return GCD(b , a % b);
        }
    }
}
/*
양의 정수 n개가 주어졌을 때, 가능한 모든 쌍의 GCD의 합을 구하는 프로그램을 작성하시오.
최대 공약수?
 */

/*
1
4 10 20 30 40



 */