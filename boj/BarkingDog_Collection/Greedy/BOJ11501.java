package boj.BarkingDog_Collection.Greedy;

// 주식 실버2
import java.io.*;
import java.util.*;
public class BOJ11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트케이스 수
        StringBuilder sb = new StringBuilder();
        while (t-->0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int [] stock = new int[n];
            for (int i = 0; i < n; i++) {
                stock[i] = Integer.parseInt(st.nextToken());
            }
            int max = stock[n-1];
            long profit = 0;
            for (int i = n - 1; i >= 0; i--) {
                if(stock[i] > max)      max = stock[i];
                else if(stock[i] < max) profit += max - stock[i];
            }
            sb.append(profit).append("\n");
        }
        System.out.println(sb);
    }
}
/*

홍준이는 요즘 주식에 빠져있다.
그는 미래를 내다보는 눈이 뛰어나, 날 별로 주가를 예상하고 언제나 그게 맞아떨어진다.
매일 그는 아래 세 가지 중 한 행동을 한다.

1. 주식 하나를 산다.
2. 원하는 만큼 가지고 있는 주식을 판다.
3. 아무것도 안한다.

예를 들어 날 수가 3일이고 날 별로 주가가 10, 7, 6일 때, 주가가 계속 감소하므로 최대 이익은 0이 된다.
그러나 만약 날 별로 주가가 3, 5, 9일 때는 처음 두 날에 주식을 하나씩 사고, 마지막날 다 팔아 버리면 이익이 10이 된다.

 */