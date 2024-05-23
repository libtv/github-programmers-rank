package BarkingDog.YouTube_15_Sort_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// https://www.acmicpc.net/problem/1431
// 시리얼 번호 실버3
public class BJ1431 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        ArrayList<SerialNumber> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new SerialNumber(br.readLine()));
        }
        Collections.sort(list);
        // System.out.println((int)'A'); // 65
        // System.out.println((int)'Z'); // 90
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).number);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

class SerialNumber implements Comparable<SerialNumber>{
    String number;
    public SerialNumber(String Number){
        this.number = Number;
    }
    public int compareTo(SerialNumber SerialNumber){
        if(this.number.length() == SerialNumber.number.length()){
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < this.number.length(); i++) {
                int temp1 = (int)this.number.charAt(i);
                int temp2 = (int)SerialNumber.number.charAt(i);
                if(temp1 < 65 || 90 < temp1){
                    sum1 += Integer.parseInt(Character.toString(temp1));
                }
                if(temp2 < 65 || 90 < temp2){
                    sum2 += Integer.parseInt(Character.toString(temp2));
                }
            }
            if(sum1 == sum2){
                return this.number.compareTo(SerialNumber.number);
            }
            return (sum1-sum2);
        }
        return (this.number.length() - SerialNumber.number.length());
    }
}

/*
시리얼번호 A가 시리얼번호 B의 앞에 오는 경우는 다음과 같다.
A와 B의 길이가 다르면, 짧은 것이 먼저 온다.
만약 서로 길이가 같다면, A의 모든 자리수의 합과 B의 모든 자리수의 합을 비교해서 작은 합을 가지는 것이 먼저온다. (숫자인 것만 더한다)
만약 1,2번 둘 조건으로도 비교할 수 없으면, 사전순으로 비교한다. 숫자가 알파벳보다 사전순으로 작다.
 */