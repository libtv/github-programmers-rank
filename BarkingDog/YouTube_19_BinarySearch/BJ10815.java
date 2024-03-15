package BarkingDog.YouTube_19_BinarySearch;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 숫자 카드 실버5
public class BJ10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (n-->0){
            set.add(Integer.parseInt(st.nextToken()));
        }
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-->0){
            sb.append(set.contains(Integer.parseInt(st2.nextToken()))? 1 : 0).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다.
정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 가지고 있는지 아닌지를 구하는 프로그램을 작성하시오.
 */