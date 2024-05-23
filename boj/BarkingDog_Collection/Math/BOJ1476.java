package boj.BarkingDog_Collection.Math;

// 날짜 계산 실버5

import java.io.*;
import java.util.*;
public class BOJ1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int max = 15 * 28 * 19;


        if(e == 15) e = 0;
        if(s == 28) s = 0;
        if(m == 19) m = 0;

        for (int i = 1; i <= max; i++) {
            if(i % 15 != e) continue;
            if(i % 28 != s) continue;
            if(i % 19 != m) continue;
            System.out.println(i);
            break;
        }

    }
}
/*
(1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19)

1  1  1 : 1년
...
1 16 16 : 16년

2 17 17 : 17년


1 % 15 = 1
1 % 28 = 1
1 % 19 = 1

1 16 16 =  16 % 15 = 1  16 % 28 = 16  16 % 19 = 16



 */