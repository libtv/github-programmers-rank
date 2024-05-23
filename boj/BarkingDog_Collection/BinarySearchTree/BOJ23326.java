package boj.BarkingDog_Collection.BinarySearchTree;

import java.util.*;
import java.io.*;
// 홍익 투어리스트 골드3
public class BOJ23326 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        TreeSet<Integer> place = new TreeSet<>(); // 명소만 저장
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            if(Integer.parseInt(st.nextToken()) == 1){
                place.add(i);
            }
        }
        int cur = 1;
        StringBuilder sb = new StringBuilder();
        while (q-->0){
            st = new StringTokenizer(br.readLine());
            int ac = Integer.parseInt(st.nextToken());
            if(ac == 1){
                int p = Integer.parseInt(st.nextToken());
                if(place.contains(p)){
                    place.remove(Integer.valueOf(p));
                }
                else place.add(p);
            }
            else if(ac == 2){
                int m = Integer.parseInt(st.nextToken());
                cur += m;
                if(cur <= n) continue;
                else{
                    cur = cur % n == 0 ? n : cur % n;
                }
            }
            else{ // ac == 3
                if(place.isEmpty()){
                    sb.append(-1);
                }
                else{
                    Integer higher = place.ceiling(cur);
                    if(higher == null){
                        Integer ceiling = place.ceiling(1);
                        if(ceiling == null){
                            sb.append(-1);
                        }
                        else sb.append(n - cur + ceiling);
                    }
                    else{
                        sb.append(higher - cur);
                    }
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
/* 문제 설명

홍익대학교는 N개의 구역이 원형으로 배치된 모습이다.

1 ... N -> 1

홍익대학교에는 명소가 존재한다. 도현이는 알찬 투어를 위해 명소만을 방문하려 한다. 도현이는 1번 구역에서 시작

도현이를 위해 다음과 같은 쿼리를 수행하는 프로그램을 작성해보자.

1 i : i번 구역이 명소가 아니었으면 명소로 지정, 명소 였으면 지정이 풀린다. 1 ~ N

2 x : 도현이가 시계방향으로 x만큼 이동

3 : 도현이가 명소에 도달하기 위해 시계방향으로 최소 몇 칸 움직여야 하는 지 출력한다. 명소가 존재하지 않는 경우
-1을 출력한다.


 */