package BarkingDog.YouTube_17_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 주식 실버2
public class BJ11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T ; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for (int j = 0; j < N ; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int max = 0;
            long profit = 0;
            for (int j = N-1; j >=0 ; j--) {
                if(arr[j] > max){
                    max = arr[j];
                }
                else{
                    profit += max - arr[j];
                }
            }
            System.out.println(profit);
        }
    }
}
/*
주식 하나를 산다.
원하는 만큼 가지고 있는 주식을 판다.
아무것도 안한다.

홍준이는 미래를 예상하는 뛰어난 안목을 가졌지만, 어떻게 해야 자신이 최대 이익을 얻을 수 있는지 모른다.
따라서 당신에게 날 별로 주식의 가격을 알려주었을 때, 최대 이익이 얼마나 되는지 계산을 해달라고 부탁했다.




 */