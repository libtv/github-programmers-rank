package boj.BarkingDog_Review;

// 공주님의 정원                        시작 1:10pm 끝 2:12pm  1시간 2분 소요
import java.io.*;
import java.util.*;
    public class  BOJ_10_2457 {
        public static int [][] memo = new int[13][32];  // 월 일
        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine()); // 꽃들의 총 개수
            init();
            ArrayList<int []> list = new ArrayList<>(); // 0은 시작 1은 끝
            while (n-->0){
                StringTokenizer st = new StringTokenizer(br.readLine());
                list.add(new int[]{memo[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())],
                        memo[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]
                });
            }
            Collections.sort(list,(o1,o2)->{
                if(o1[1]!=o2[1]) return o2[1]-o1[1]; // 내림차순
                else return -(o1[0] - o2[0]);
            });
            Queue<int []> q = new LinkedList<>();
            for (int[] ints : list) {
                q.add(ints);
            }
            int target = memo[12][1];
            int next = 365;
            int count = 0;
            while (!q.isEmpty()){
                int [] temp = q.poll();
                if(temp[1] >= target){
                    next = Math.min(next, temp[0]);
                    if(next <= memo[3][1]){
                        count++;
                        System.out.println(count);
                        return;
                    }
                }
                else{
                    if(next < target){
                        count++;
                        if(next <= memo[3][1]){
                            System.out.println(count);
                            return;
                        }
                        else{
                            target = next;
                            if(temp[1] >= target){
                                next = temp[0];
                            }
                            else{
                                System.out.println(0);
                                return;
                            }
                        }
                    }
                }
            }
            System.out.println(0);
        }
        public static void init(){
            int cnt = 1;
            int [] arr = {0, 31,28,31,30,31,30,31,31,30,31,30,31};
            for (int i = 1; i <= 12; i++) {
                for (int j = 1; j <= arr[i]; j++) {
                    memo[i][j] = cnt;
                    cnt++;
                }
            }
        }
    }
/*
5월 8일 시작 -> 6월 13일에 지는 꽃 (5월 8일 ~ 6월 12일까지)

올해는 4, 6, 9, 11월은 30일까지 있고, 1, 3, 5, 7, 8, 10, 12월은 31일  2월은 28일까지만 있다

N개의 꽃들 중에서 다음의 두 조건을 만족하는 꽃들을 선택하고 싶다.

조건
공주가 가장 좋아하는 계절인 3월 1일부터 11월 30일까지 매일 꽃이 한 가지 이상 피어 있도록 한다.
정원이 넓지 않으므로 정원에 심는 꽃들의 수를 가능한 적게 한다.

첫째 줄에 선택한 꽃들의 최소 개수를 출력한다. 만약 두 조건을 만족하는 꽃들을 선택할 수 없다면 0을 출력한다.

 */