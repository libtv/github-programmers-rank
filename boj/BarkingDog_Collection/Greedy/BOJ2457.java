package boj.BarkingDog_Collection.Greedy;

// 공주님의 정원 골드3
import java.util.*;
import java.io.*;
public class BOJ2457 {
    static int [][] memory = new int[13][32];
    static int [][] flower;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        calculate();
        flower = new int[n][2]; // 0은 시작 1은 끝
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s1 = Integer.parseInt(st.nextToken()); int s2 = Integer.parseInt(st.nextToken());
            int s3 = Integer.parseInt(st.nextToken()); int s4 = Integer.parseInt(st.nextToken());
            flower[i][0] = memory[s1][s2]; flower[i][1] = memory[s3][s4];
        }
        Arrays.sort(flower, (o1, o2) ->{
            if(o1[1]!=o2[1]) return -(o1[1] - o2[1]); // 제일 늦게 끝나는 순서로
            else return -(o1[0] - o2[0]);
        });
        // System.out.println(Arrays.deepToString(flower));

        int target = memory[12][1]; // 꽃이 지는 날이 최소 12월 1일 -> 335
        int [] visited = new int[n];
        int cnt = 0;
        boolean flag = false;
        int count = 0;
        while (cnt <= n - 1 && !flag){
            int min = 0;
            for (int i = cnt; i <= n - 1; i++) {
                if(visited[i] >= 2) continue;
                visited[i]++;
                int start = flower[i][0];
                int end   = flower[i][1];
                if(end >= target){
                    if(min == 0){
                        min = start;
                    }
                    else{
                        if(min > start){
                            min = start;
                        }
                    }
                }
                else{
                    cnt = i - 1;
                    break;
                }
            }
            if(min == 0) break;
            else{
                count++;
                if(min <= memory[3][1]){ // -> 60
                    flag = true;
                }
                else{
                    target = min;
                }
            }
        }
        if(flag) System.out.println(count);
        else System.out.println(0);
    }
    static void calculate(){
        int count = 1;
        int [] arr = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        for (int i = 1; i <= 12; i++) {
            for (int j = 1; j <= arr[i]; j++) {
                memory[i][j] = count;
                count++;
            }
        }
    }
}
/*
꽃은 모두 같은 해에 피어서 같은 해에 진다.
하나의 꽃은 피는 날과 지는 날이 정해져 있다.
예를 들어, 5월 8일 피어서 6월 13일 지는 꽃은 5월 8일부터 6월 12일까지는 꽃이 피어 있고, 6월 13일을 포함하여 이후로는 꽃을 볼 수 없다는 의미이다.

올해는 4, 6, 9, 11월은 30일까지 있고, 1, 3, 5, 7, 8, 10, 12월은 31일까지 있으며, 2월은 28일까지만 있다.

1. 공주가 가장 좋아하는 계절인 3월 1일부터 11월 30일까지 매일 꽃이 한 가지 이상 피어 있도록 한다.
2. 정원이 넓지 않으므로 정원에 심는 꽃들의 수를 가능한 적게 한다.


N개의 꽃들 중에서 위의 두 조건을 만족하는, 즉 3월 1일부터 11월 30일까지 매일 꽃이 한 가지 이상 피어 있도록 꽃들을 선택할 때,
선택한 꽃들의 최소 개수를 출력하는 프로그램을 작성하시오.



 */