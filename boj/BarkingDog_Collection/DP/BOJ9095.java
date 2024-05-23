package boj.BarkingDog_Collection.DP;

// 1,2,3 더하기 실버3
import java.io.*;
public class BOJ9095 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int [] DP = new int[12]; // n은 양수이며 11보다 작다.
        DP[1] = 1; DP[2] = 2; DP[3] = 4;
        while (t-->0){
            int n = Integer.parseInt(br.readLine());
            if(n <= 3){
                System.out.println(DP[n]);
                continue;
            }
            for (int i = 4; i <= n; i++) {
                DP[i] = DP[i-1] + DP[i-2] + DP[i-3];
            }
            System.out.println(DP[n]);
        }
    }
}
// 정수 n을 1, 2, 3의 합으로 나타내는 방법의 개수
/*

1 = 1 -> 1
2 = 2, (1,1) -> 2
3 = 3, (2,1), (1,1,1) ,(1,2) -> 4
4 = 7

왜 7이 나올까?
DP[3] -> DP[4] = DP[3]에서  1씩 추가하는 방법
DP[2] -> DP[4] = DP[2]에서  2씩 추가하는 방법
DP[1] -> DP[4] = DP[1]에서  3씩 추가하는 방법

-> DP[1]  1 + 3 = 4  1개

-> DP[2]  2 + 2 = 4 , 1 + 1 + 2 = 4 2개

-> DP[3]  3 + 1 = 4 , 2 + 1 + 1 = 4 , 1 + 1 + 1 + 1 = 4, 1 + 2 + 1 = 4 4개

1 + 2 + 4 = 7개

 */