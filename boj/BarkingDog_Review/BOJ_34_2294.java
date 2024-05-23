package boj.BarkingDog_Review;

// 동전2
import java.io.*;
import java.util.*;
public class BOJ_34_2294 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 동전의 개수
        int k = Integer.parseInt(st.nextToken()); // 가치의 합 k
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(br.readLine());
            if(set.contains(cur)) continue;
            set.add(cur);
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        int [] DP = new int[k+1];
        Arrays.fill(DP, Integer.MAX_VALUE / 1000);
        for (int i = 0; i < list.size(); i++) {
            int cur = list.get(i);
            if(cur > k) continue;
            DP[cur] = 1;
            for (int j = 1; j <= k; j++) {
                if(j - cur >= 0){
                    DP[j] = Math.min(DP[j], DP[j - cur] +  1);
                }
            }
        }
        System.out.println(DP[k] == Integer.MAX_VALUE / 1000 ? -1 : DP[k]);
    }
}
/*

n가지 종류의 동전이 있다.
이 동전들을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다.
그러면서 동전의 개수가 최소가 되도록 하려고 한다.
각각의 동전은 몇 개라도 사용할 수 있다.

첫째 줄에 사용한 동전의 최소 개수를 출력한다. 불가능한 경우에는 -1을 출력한다.


 */