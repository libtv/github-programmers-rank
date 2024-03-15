package BarkingDog.YouTube_18_Math;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// 거의 소수 골드5
public class BJ1456 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        ArrayList<Long> list = new ArrayList<>();  // 소수 저장하기
        ArrayList<Long> list2 = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(B); i++) { // 제곱근까지
            boolean flag = true;
            for (int j = 0; j < list2.size(); j++) {
                if(i % list2.get(j) == 0){
                    flag = false;
                }
            }
            if(flag){
                list2.add((long) i);
                if(i <= Math.sqrt(A)){
                    list.add((long) i);
                }
            }
        }
        int count1 = 0;
        for (int i = 0; i < list.size(); i++) {
            long temp = list.get(i);
            for (int j = 2; j <= 100; j++) {
                 if(Math.pow(temp , j) <= A){
                     count1++;
                 }
                 else{
                     break;
                 }
            }
        }
        int count2 = 0;
        for (int i = 0; i < list2.size(); i++) {
            long temp = list2.get(i);
            for (int j = 2; j <= 100; j++) {
                if(Math.pow(temp , j) <= B){
                    count2++;
                }
                else{
                    break;
                }
            }
        }
        System.out.println(count2 - count1);

    }

}
/*
어떤 수가 소수의 N제곱(N ≥ 2) 꼴일 때, 그 수를 거의 소수라고 한다.
두 정수 A와 B가 주어지면, A보다 크거나 같고, B보다 작거나 같은 거의 소수가 몇 개인지 출력한다.
1 10000000000 돌리니까 에러
예제는 다 통과

 */