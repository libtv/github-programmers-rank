package org.example.BarkingDog.YouTube_22_BST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

// 홍익 투어리스트 골드3
public class BJ23326 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]); // 구역의 개수
        int Q = Integer.parseInt(split[1]); // 쿼리의 개수
        TreeSet<Integer> set = new TreeSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if(n == 1){
                set.add(i + 1);
            }
        }
        int cur = 1;
        StringBuilder sb = new StringBuilder();
        while(Q-->0){
            String [] split2 = br.readLine().split(" ");
            if(split2.length == 1){ // 3
                if(set.isEmpty()){
                    sb.append("-1").append("\n");
                }
                else{
                    Integer check = set.ceiling(cur);
                    if(check != null){
                        sb.append(check - cur).append("\n");
                    }
                    else if(check == null){
                        Integer check2 = set.ceiling(1);
                        sb.append((N - cur) + check2).append("\n");
                    }
                }
            }
            else{
                int command = Integer.parseInt(split2[0]);
                if(command == 1){
                    int temp = Integer.parseInt(split2[1]);
                    if(set.contains(temp)){      // 명소였다면 지정이 풀린다.
                        set.remove(Integer.valueOf(temp));
                    }
                    else if(!set.contains(temp)){ // 명소로 지정
                        set.add(temp);
                    }
                }
                else if(command == 2){
                    long temp = Long.parseLong(split2[1]);
                    temp = temp + cur;
                    int check = (int)(temp % N);
                    if(check == 0){
                        cur = N;
                    }
                    else{
                        cur = check;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
/*
도현이는 홍익 투어리스트가 되어 홍익대학교를 견학하려고 한다.
홍익대학교는 N 개의 구역이 원형으로 배치된 모습이다.

1 -> (시계방향) -> .. N -> 1
홍익대학교에는 명소가 존재한다. 도현이는 알찬 투어를 위해 명소만을 방문하려 한다. 도현이는 1번 구역에 서있다.

1. i번 구역이 명소가 아니었으면 명소로 지정되고 명소였다면 지정이 풀리게된다. 1 <= i <= N
2. 도현이가 시계방향으로 X만큼 이동한다. (1 <= X <= 10^9)
3. 도현이가 명소에 도달하기 위해 시계방향으로 최소 몇 칸 움직여야 하는지 출력한다. 명소가 존재하지 않는 경우 -1 출력

명소라면 1 명소가 아니면 0

1000000000
 */