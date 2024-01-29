package org.example.BarkingDog.YouTube_17_Greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// ATM 실버4
public class BJ11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N ; i++) {
             list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        int sum = 0;
        int answer = 0;
        for (int i = 0; i < N; i++) {
            sum += list.get(i);
            answer += sum;
        }
        System.out.println(answer);

    }
}
/*


 */