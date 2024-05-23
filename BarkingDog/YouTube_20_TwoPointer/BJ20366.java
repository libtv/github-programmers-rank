package BarkingDog.YouTube_20_TwoPointer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 같이 눈사람 만들래? 골드3
public class BJ20366 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long [] snow = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N ; i++) {
            snow[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(snow);
        long min = Long.MAX_VALUE;
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                long sum = snow[i] + snow[j];
                int start = 0;
                int end = N - 1;
                while(start < end){
                    if(start == i || start == j){
                        start++;
                        continue;
                    }
                    else if(end == i || end == j){
                        end--;
                        continue;
                    }
                    long temp = snow[start] + snow[end];
                    min = Math.min(min , Math.abs(temp - sum));
                    if(temp > sum){
                        end--;
                    }
                    else if(temp < sum){
                        start++;
                    }
                    else if(temp == sum){
                        flag = true;
                        break;
                    }
                }
                if(flag){
                    break;
                }
            }
            if(flag){
                break;
            }
        }
        System.out.println(min);
    }
}
/*
언니 엘자와 동생 안나에게는 N개의 눈덩이가 있다. 각 눈덩이 i (1 ≤ i ≤ N)의 지름은 Hi 이다.
하나의 눈사람은 두 개의 눈덩이로 구성되며, 눈덩이 하나를 아래에 두고 그 눈덩이보다 크지 않은 다른 눈덩이를 쌓아올리는 방식으로 만들 수 있다.
이때, 눈사람의 키는 두 눈덩이 지름의 합과 같다.

엘자와 안나는 눈덩이 N개 중 서로 다른 4개를 골라서 눈사람을 각각 1개씩, 총 2개를 만들려고 한다.
두 자매는 두 눈사람의 키의 차이가 작을수록 두 눈사람의 사이가 좋을 것이라고 믿는다.
우리는 엘자와 안나가 가장 사이좋은 두 눈사람을 만들기 위해서 도와주려고 한다.

 */