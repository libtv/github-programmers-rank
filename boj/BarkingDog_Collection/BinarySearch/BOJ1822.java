package boj.BarkingDog_Collection.BinarySearch;

import java.io.*;
import java.util.*;

// 차집합 실버4
public class BOJ1822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int [] A = new int[a];
        int [] B = new int[b];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);

        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < a; i++) {
            int target = A[i];
            if(Arrays.binarySearch(B, target) < 0) answer.add(target);
        }

        StringBuilder sb = new StringBuilder();
        if(answer.size() == 0) System.out.println(0);
        else{
            sb.append(answer.size()).append("\n");
            for (Integer integer : answer) {
                sb.append(integer).append(" ");
            }
            System.out.println(sb);
        }

    }
}
