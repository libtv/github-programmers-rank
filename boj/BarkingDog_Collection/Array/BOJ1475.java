package org.example.boj.BarkingDog_Collection.Array;

// 방 번호 실버5
import java.io.*;
public class BOJ1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int [] arr = new int[10];
        for (int i = 0; i < input.length(); i++) {
            arr[input.charAt(i) - '0'] += 1;
        }
        int six = arr[6];
        int nine = arr[9];
        while (Math.abs(six - nine) > 1){
            if(six > nine){
                six--;
                nine++;
            }
            else{
                six++;
                nine--;
            }
        }
        arr[6] = six;
        arr[9] = nine;
        int max = 0;
        for (int i = 0; i <= 9 ; i++) {
            max = Math.max(arr[i], max);
        }
        System.out.println(max);
    }
}
