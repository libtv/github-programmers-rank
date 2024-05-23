package boj.BarkingDog_Collection.BackTracking;

// 계란으로 계란치기 골드5
import java.io.*;
import java.util.*;
public class BOJ16987 {
    static int n; static int [][] eggs; static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 계란의 수
        StringTokenizer st;
        eggs = new int[n][2];
        for (int i = 0; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            eggs[i][0] = Integer.parseInt(st.nextToken()); // 0은 내구도
            eggs[i][1] = Integer.parseInt(st.nextToken()); // 1은 무게
        }
        BackTracking(0);
        System.out.println(answer);
    }
    public static void BackTracking(int cur){
        if(cur == n){
            int temp = 0;
            for (int i = 0; i < n ; i++) {
                if(eggs[i][0] <= 0) temp++;
            }
            answer = Math.max(answer, temp);
            return;
        }
        // 손에 든 계란이 깨졌거나
        if(eggs[cur][0] <= 0){
            BackTracking(cur + 1);
        }
        else{
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if(i == cur) continue;
                if(eggs[i][0] > 0){ // 깨지지 않은 계란
                    eggs[cur][0] -= eggs[i][1];
                    eggs[i][0] -= eggs[cur][1];
                    flag= false;
                    BackTracking(cur + 1);
                    eggs[i][0] += eggs[cur][1];
                    eggs[cur][0] += eggs[i][1];
                }
            }
            // 깨지지 않은 다른 계란이 없으면
            if(flag) BackTracking(cur + 1);
        }
    }
}
