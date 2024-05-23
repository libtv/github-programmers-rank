package BarkingDog.YouTube_17_Greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

// 로프 실버4
public class BJ2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N ; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list); // 오름차순 정렬
        int size = N;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N ; i++) {
            max = Math.max(list.get(i) * (N-i), max);
        }
        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
하지만 여러 개의 로프를 병렬로 연결하면 각각의 로프에 걸리는 중량을 나눌 수 있다.
k개의 로프를 사용하여 중량이 w인 물체를 들어올릴 때, 각각의 로프에는 모두 고르게 w/k 만큼의 중량이 걸리게 된다.
각 로프들에 대한 정보가 주어졌을 때, 이 로프들을 이용하여 들어올릴 수 있는 물체의 최대 중량을 구해내는 프로그램을 작성하시오.
모든 로프를 사용해야 할 필요는 없으며, 임의로 몇 개의 로프를 골라서 사용해도 된다.
 */

/*
 10 15 20     10 * 3(3-0) > max(20)

 5  25 30     5 * 3 < max(30)
              25 * 2 > max(30)

 1 3 6 12
              1 * 4 < max(12)
              3 * 3 < 12
              6 * 2 == 12   12

 1 5 6 7      1 * 4 < 7
              5 * 3 = 15 > 7
              6 * 2 = 12 > 7

 1 5 14 15    5 * 3 = 15
              14 * 2 = 28
 */