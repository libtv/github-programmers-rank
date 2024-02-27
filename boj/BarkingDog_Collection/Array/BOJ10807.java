package org.example.boj.BarkingDog_Collection.Array;

// 개수 세기 브론즈5
import java.io.*;
import java.util.StringTokenizer;
public class BOJ10807 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr1 = new int[101];
        int [] arr2 = new int[101];
        while (n-->0){
            int input = Integer.parseInt(st.nextToken());
            if(input >= 0){
                arr1[input] += 1;
            }
            else{
                arr2[-input] += 1;
            }
        }
        int check = Integer.parseInt(br.readLine());
        if(check >= 0) System.out.println(arr1[check]);
        else System.out.println(arr2[-check]);
    }
}
