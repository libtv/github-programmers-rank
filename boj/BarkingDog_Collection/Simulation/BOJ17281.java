package boj.BarkingDog_Collection.Simulation;

// ⚾ 골드4
import java.io.*;
import java.util.*;
public class BOJ17281 {
    static int n; static int [][] player; static int max;
    static int [] order = new int[9]; static boolean [] visited = new boolean[9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        player = new int[n][9];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                player[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        BackTracking(0);
        System.out.println(max);
    }
    public static void BackTracking(int cur){
        if(cur == 9){
            check();
            return;
        }
        if(cur == 3){
            order[cur] = 0;
            BackTracking(cur + 1);
        }
        else if(cur != 3){
            for (int i = 1; i < 9; i++) {
                if(!visited[i]){
                    visited[i] = true;
                    order[cur] = i;
                    BackTracking(cur + 1);
                    visited[i] = false;
                }
            }
        }
    }
    public static void check(){
        int score = 0;
        int cur   = 0;
        int base1 = 0; int base2 = 0; int base3 = 0;
        int out_count = 0;
        for (int i = 0; i < n; i++) {
            out_count = 0;
            base1 = 0; base2 = 0; base3 = 0;
            while (out_count != 3){
                int next = order[cur];
                int action = player[i][next];
                switch (action){
                    case 0 :{
                        out_count++;
                        break;
                    }
                    case 1 :{
                        if(base3 == 1){
                            base3 = 0; score++;
                        }
                        if(base2 == 1){
                            base2 = 0; base3 = 1;
                        }
                        if(base1 == 1){
                            base2 = 1;
                        }
                        base1 = 1;
                        break;
                    }
                    case 2 :{
                        if(base3 == 1){
                            base3 = 0; score++;
                        }
                        if(base2 == 1){
                            base2 = 0; score++;
                        }
                        if(base1 == 1){
                            base1 = 0; base3 = 1;
                        }
                        base2 = 1;
                        break;
                    }
                    case 3 :{
                        if(base3 == 1){
                            score++;
                        }
                        if(base2 == 1){
                            base2 = 0; score++;
                        }
                        if(base1 == 1){
                            base1 = 0; score++;
                        }
                        base3 = 1;
                        break;
                    }
                    case 4 :{ // 홈런
                        if(base1 == 1){
                            score++; base1 = 0;
                        }
                        if(base2 == 1){
                            score++; base2 = 0;
                        }
                        if(base3 == 1){
                            score++; base3 = 0;
                        }
                        score++;
                        break;
                    }
                }
                cur++;
                if(cur == 9) cur = 0;
            }
        }
        max = Math.max(max, score);
    }
}
