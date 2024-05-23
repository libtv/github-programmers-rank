package boj.BarkingDog_Collection.Sort;

import java.io.*;
import java.util.*;
// 시리얼 번호 실버3
public class BOJ1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }
        Collections.sort(list, new Comparator<String>(){
            public int compare (String o1, String o2){
                if(o1.length() != o2.length()) return o1.length()-o2.length();
                else{
                    int sum1 = 0; int sum2 = 0;
                    for (int i = 0; i < o1.length(); i++) {
                        int temp = o1.charAt(i) - '0';
                        if(0 <= temp && temp <= 9) sum1 += temp;
                    }
                    for (int i = 0; i < o2.length(); i++) {
                        int temp = o2.charAt(i) - '0';
                        if(0 <= temp && temp <= 9) sum2 += temp;
                    }
                    if(sum1 != sum2) return sum1 - sum2;
                    else{
                        return o1.compareTo(o2);
                    }
                }
            }
        });
        list.stream().forEach(System.out::println);
    }
}
