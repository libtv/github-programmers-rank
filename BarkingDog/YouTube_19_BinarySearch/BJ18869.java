package BarkingDog.YouTube_19_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 멀티버스 2 골드5
public class BJ18869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int m = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);
        String[] universe = new String[m];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();
            Set<Integer> set = new TreeSet<>();
            for (int j = 0; j < n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                list.add(temp);
                set.add(temp);
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            int cnt = 0;
            for (int target : set) {
                map.put(target, cnt);
                cnt++;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(map.get(list.get(j)));
            }
            universe[i] = sb.toString();
        }
        int count = 0;
        // m = 3
        for (int i = 0; i < m-1; i++) {
            for (int j = i+1; j < m; j++) {
                if(universe[i].equals(universe[j]))
                    count++;
            }
        }
        System.out.println(count);
    }
}
/*
1 3 2
맨 처음은 무조건 0  1 < 3 이니까 1   3 > 2 이니까 0 이렇게 지도를 만든다. (문자열)

 */


/*
M개의 우주가 있고, 각 우주에는 1부터 N까지 번호가 매겨진 행성이 N개 있다.
두 우주 A와 B가 있고, 우주 A에 있는 행성의 크기는 A1, A2, ..., AN, 우주 B에 있는 행성의 크기는 B1, B2, ..., BN라고 하자.
두 우주의 행성 크기가 모든 1 ≤ i, j ≤ N에 대해서 아래와 같은 조건을 만족한다면, 두 우주를 균등하다고 한다.
 */