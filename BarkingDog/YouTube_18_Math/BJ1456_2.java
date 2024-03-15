package BarkingDog.YouTube_18_Math;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// 거의 소수 골드5
public class BJ1456_2 {

    static int max = 10000001;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();

        boolean DP [] = new boolean[max];
        ArrayList<Long> list = new ArrayList<>();
        ArrayList<Long> list2 = new ArrayList<>();

        for (int i = 2; i <= Math.sqrt(B); i++) {
             if(!DP[i]){
                 list.add((long)i);
                 if(i <= Math.sqrt(A)){
                     list2.add((long)i);
                 }
                 for (int j = 2; true; j++) {
                     if(i * j <= max-1){
                         DP[i * j] = true;
                     }
                     else{
                         break;
                     }
                 }
             }
        }
        int countB = 0;
        for (int i = 0; i < list.size(); i++) {
            long temp = list.get(i);
            int j = 2;
            while (Math.pow(temp , j) <= B){
                countB++;
                j++;
            }
        }
        int countA = 0;
        for (int i = 0; i < list2.size(); i++) {
            long temp = list2.get(i);
            int j = 2;
            while (Math.pow(temp , j) <= A){
                countA++;
                j++;
            }
        }
        // A가 거의 소수인지 아닌지?
        boolean flag = false;
        for (int i = 0; i < list2.size(); i++) {
            long temp = list2.get(i);
            int j = 2;
            while (Math.pow(temp , j) <= A){
                if(A == Math.pow(temp , j)){
                    flag = true;
                }
                j++;
            }
            if(flag){
                break;
            }
        }
        if(flag && A==B){
            System.out.println(1);
        }
        else if(!flag && A==B){
            System.out.println(0);
        }
        else if(flag && A!=B){
            System.out.println(countB-countA+1);
        }
        else{
            System.out.println(countB-countA);
        }

    }
}
// 8 16
// 8 9 16 3개

/*
if(A == B){ // 6퍼에서 -> 16퍼로 증가.. ㅋㅋ
            boolean flag = false;
            for (int i = 0; i < list2.size(); i++) {
                long temp = list2.get(i);
                int j = 2;
                while (Math.pow(temp , j) <= A){
                    if(A == Math.pow(temp , j)){
                        flag = true;
                    }
                    j++;
                }
                if(flag){
                    break;
                }
            }
            if(flag){
                System.out.println(1);
            }
            else if(!flag){
                System.out.println(0);
            }
        }
        else{
            System.out.println(countB - countA);
        }
 */