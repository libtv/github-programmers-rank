package boj.BarkingDog_Collection.TwoPointer;

import java.io.*;
import java.util.*;

// 소수의 연속합 골드3
public class BOJ1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        boolean [] visited = new boolean[input + 1];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i <= input; i++) {
            if(visited[i]) continue;
            list.add(i);
            for (long j = (long)i * i; j <= input; j+=i) {
                visited[(int)j] = true;
            }
        }

        if(list.isEmpty()){
            System.out.println(0);
            return;
        }

        int size = list.size();

        int st  = 0;
        int en  = 0;
        int sum = list.get(0);
        int cnt = 0;
        while (st <= en && en < size){
            if(sum == input){
                cnt++;
                en++;
                if(en == size) break;
                sum += list.get(en);
            }
            else if(sum > input){
                sum -= list.get(st++);
            }
            else if(sum < input){
                en++;
                if(en == size) break;
                sum += list.get(en);
            }
        }
        System.out.println(cnt);
    }
}
