package BarkingDog.YouTube_28_Floyd;

import java.util.*;
import java.io.*;
// 가운데에서 만나기 골드4
public class BJ21940 {
    static final int max = 9999999;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [][] city = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j){
                    city[i][j] = 0;
                    continue;
                }
                city[i][j] = max;
            }
        }

        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            city[A][B] = Math.min(city[A][B], T);
        }

        int c = Integer.parseInt(br.readLine());
        ArrayList<Integer> friends = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        while (c-->0){
            friends.add(Integer.parseInt(st.nextToken()));
        }
        // 플루이드 알고리즘
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    city[i][j] = Math.min(city[i][j], city[i][k] + city[k][j]);
                }
            }
        }
        // System.out.println(Arrays.deepToString(city));
        // System.out.println(friends);
        int min = Integer.MAX_VALUE;
        int [] ans = new int[n+1];
        Arrays.fill(ans, - 1);
        for (int i = 1; i <= n; i++) {
            boolean flag = true;
            int sum = 0;
            for (int j = 0; j < friends.size(); j++) {
                int tar = friends.get(j);
                if(city[i][tar] == max || city[tar][i] == max){
                    flag = false;
                    break;
                }
                sum = Math.max(sum, city[i][tar] + city[tar][i]);
            }
            if(flag){
                min = Math.min(min, sum);
                ans[i] = sum;
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if(min == ans[i])
                pq.add(i);
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()){
            sb.append(pq.poll()).append(" ");
        }
        System.out.println(sb);
    }
}
/*
준형이는 내일 친구들을 만나기로 했다. 준형이와 친구들은 서로 다른 도시에 살고 있다.
도시를 연결하는 도로는 일방 통행만 있어서 A -> B , B -> A 가는 시간이 다를 수 있다.
준형이와 친구들은 아래 조건을 만족하는 도시 X를 선택하여 거기서 만나려고 한다.

왕복시간은 자신이 살고 있는 도시에서 도시 X로 이동하는 시간과 도시 X에서 다시 자신이 살고 있는 도시로 이동하는 시간을 합한 것이다.
준형이와 친구들이 도로를 이용하여 갈 수 있는 도시만 선택한다.
준형이와 친구들의 왕복시간들 중 최대가 최소가 되는 도시 X를 선택한다.
준형이와 친구들이 이동할 수 있는 도시가 최소한 하나 이상이 있음을 보장한다.
 */
