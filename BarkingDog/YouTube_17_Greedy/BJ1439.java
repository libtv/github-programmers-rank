package org.example.BarkingDog.YouTube_17_Greedy;

import java.io.*;

// 뒤집기 실버5
public class BJ1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int current = 2;
        int zero = 0;
        int one = 0;
        for (int i = 0; i < str.length(); i++) {
            if(i == 0){
                if(str.charAt(i) == '0'){
                    current = 0;
                    zero++;
                }
                else{
                    current = 1;
                    one++;
                }
            }
            else{
                if(current == 1 && str.charAt(i) == '0'){
                    zero++;
                    current = 0;
                }
                else if(current == 0 && str.charAt(i) == '1'){
                    one++;
                    current = 1;
                }
            }
        }
        bw.write(Integer.toString(one >= zero ? zero : one));
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
첫째 줄에 다솜이가 해야하는 행동의 최소 횟수를 출력한다.

적게 등장한 구간이 최소 횟수이다.


 */