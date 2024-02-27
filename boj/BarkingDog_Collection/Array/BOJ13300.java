package org.example.boj.BarkingDog_Collection.Array;

// 방 배정 브론즈2
import java.io.*;
import java.util.StringTokenizer;
public class BOJ13300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 학생 수
        int k = Integer.parseInt(st.nextToken()); // 한 방에 배정할 수 있는 최대 인원 수
        int [][] trip = new int[7][2];
        while (n-->0){
            // 0: 여자 1: 남자
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());
            trip[grade][sex] += 1;
        }
        int cnt = 0;
        for (int i = 1; i <= 6 ; i++) {
            for (int j = 0; j < 2; j++) {
                cnt += trip[i][j] / k;
                if(trip[i][j] % k == 0) continue;
                cnt ++;
            }
        }
        System.out.println(cnt);
    }
}
