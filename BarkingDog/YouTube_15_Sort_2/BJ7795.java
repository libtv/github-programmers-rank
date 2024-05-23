package BarkingDog.YouTube_15_Sort_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// https://www.acmicpc.net/problem/7795
// 먹을 것인가 먹힐 것인가.. 실버3
public class BJ7795 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t ; i++) {
            String [] split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            ArrayList<Integer> A = new ArrayList<>();
            ArrayList<Integer> B = new ArrayList<>();
            String [] split2 = br.readLine().split(" ");
            for (int j = 0; j < a ; j++) {
                A.add(Integer.parseInt(split2[j]));
            }
            String [] split3 = br.readLine().split(" ");
            for (int j = 0; j < b ; j++) {
                B.add(Integer.parseInt(split3[j]));
            }
            Collections.sort(A);
            Collections.sort(B);
            int Bmax = Collections.max(B);

            int cnt = 0;
            for (int j = 0; j < a ; j++) { // 1 2 3 4          j = 1
                int temp = A.get(j);
                if(temp > Bmax){
                    cnt += (a - j) * b;
                    break;
                }
                for (int k = 0; k < b ; k++) {
                    int temp2 = B.get(k);
                    if(temp > temp2){
                        cnt++;
                    }
                    else{
                        break;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
/*
(1 ≤ N, M ≤ 20,000)  20000 * 20000 = 400000000 4초 2중 for문 xx

 */