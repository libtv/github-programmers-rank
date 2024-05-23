package BarkingDog.YouTube_20_TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 회전초밥 실버1
public class BJ2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int [] arr = new int[n];
        int [] check = new int[d+1];
        for (int i = 0; i < n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0; // 무료 초밥 1개
        for (int i = 0; i < k; i++) {
            if(check[arr[i]] == 0){
                count++;
            }
            check[arr[i]]++;
        }
        if(check[c] == 0){
            count++;
        }
        int max = count;
        if(check[c] == 0){
            count--;
        }
        // 0 1 2 3
        for (int i = k; i < n + k ; i++) {
             int cur = i % n;
             if(check[arr[cur]] == 0){
                 count++;
             }
             check[arr[cur]]++;
             check[arr[i-k]]--;
             if(check[arr[i-k]] == 0){
                 count--;
             }
             if(check[c] == 0){
                 count++;
             }
             max = Math.max(count , max);
             if(check[c] == 0){
                count--;
             }
        }
        System.out.println(max);
    }
}
/*
회전 초밥 음식점에는 회전하는 벨트 위에 여러 가지 종류의 초밥이 접시에 담겨 놓여 있고,
손님은 이 중에서 자기가 좋아하는 초밥을 골라서 먹는다. 초밥의 종류를 번호로 표현할 때, 다음 그림은 회전 초밥 음식점의 벨트 상태의 예를 보여주고 있다.
벨트 위에는 같은 종류의 초밥이 둘 이상 있을 수 있다.

원래 회전 초밥은 손님이 마음대로 초밥을 고르고, 먹은 초밥만큼 식대를 계산하지만,
벨트의 임의의 한 위치부터 k개의 접시를 연속해서 먹을 경우 할인된 정액 가격으로 제공한다.

각 고객에게 초밥의 종류 하나가 쓰인 쿠폰을 발행하고,
1번 행사에 참가할 경우 이 쿠폰에 적혀진 종류의 초밥 하나를 추가로 무료로 제공한다.
만약 이 번호에 적혀진 초밥이 현재 벨트 위에 없을 경우, 요리사가 새로 만들어 손님에게 제공한다.

위 할인 행사에 참여하여 가능한 한 다양한 종류의 초밥을 먹으려고 한다.

k=4이고, 30번 초밥을 쿠폰으로 받았다고 가정하자.

(9, 7, 30, 2), (30, 2, 7, 9), (2, 7, 9, 25) 세 가지 경우가 있는데, 30번 초밥을 추가로 쿠폰으로 먹을 수 있으므로 (2, 7, 9, 25)를 고르면 5가지 종류의 초밥을 먹을 수 있다.

첫 번째 줄에는 회전 초밥 벨트에 놓인 접시의 수 N, 초밥의 가짓수 d, 연속해서 먹는 접시의 수 k, 쿠폰 번호 c가 각각 하나의 빈 칸을 사이에 두고 주어진다.
 단, 2 ≤ N ≤ 30,000, 2 ≤ d ≤ 3,000, 2 ≤ k ≤ 3,000 (k ≤ N), 1 ≤ c ≤ d이다.
 두 번째 줄부터 N개의 줄에는 벨트의 한 위치부터 시작하여 회전 방향을 따라갈 때 초밥의 종류를 나타내는 1 이상 d 이하의 정수가 각 줄마다 하나씩 주어진다.

 */

/*


 */