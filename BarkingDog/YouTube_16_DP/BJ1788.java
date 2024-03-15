package BarkingDog.YouTube_16_DP;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Scanner;

// 피보나치 수의 확장 실버3
public class BJ1788 {
    static final long cnt = 1000000000;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();
        HashMap<Integer, Long> map = new HashMap<>();
        map.put(0, Long.valueOf(0));
        map.put(1, Long.valueOf(1));
        if(n > 0){
            for (int i = 2; i <= n; i++) {
                map.put(i, (map.get(i-1) + map.get(i-2)) % cnt);
            }
            if(map.get(n) == 0){
                bw.write(Integer.toString(0));
                bw.write("\n");
                bw.write(Integer.toString(0));
            }
            else{
                bw.write(Integer.toString(1));
                bw.write("\n");
                bw.write(Long.toString(map.get(n)));
            }
        }
        else if(n == 0){
            bw.write(Integer.toString(0));
            bw.write("\n");
            bw.write(Integer.toString(0));
        }
        else if(n < 0){
            map.put(-1, Long.valueOf(1));
            for (int i = -2; i >=n; i--) {
                map.put(i, (map.get(i+2) - map.get(i+1)) % cnt);
            }
            if(map.get(n) == 0){
                bw.write(Integer.toString(0));
                bw.write("\n");
                bw.write(Long.toString(Math.abs(map.get(n))));
            }
            else if(map.get(n) < 0){
                bw.write(Integer.toString(-1));
                bw.write("\n");
                bw.write(Long.toString(Math.abs(map.get(n))));
            }
            else{
                bw.write(Integer.toString(1));
                bw.write("\n");
                bw.write(Long.toString(Math.abs(map.get(n))));
            }
        }
        bw.flush();
        bw.close();
        /*
        F(n) > 0 : 1
        F(n) = 0 : 0
        F(n) < 0 : -1
        둘째 줄에는 F(n)의 절댓값을 출력
         */
    }
}
/*
n = 1
F(1)  = F(0) + F(-1)
F(-1) = 1

F(0) = F(-1) + F(-2)
F(0) = 0 = 1 + (-1)

F(-2) = -1
F(-1) = F(-2) + F(-3) = 1  = -1

F(-2) = F(-3) + F(-4)
 */