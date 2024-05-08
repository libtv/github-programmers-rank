package boj.BarkingDog_Collection.BinarySearch;

// 공유기 설치 골드4
import java.io.*;
import java.util.*;
public class BOJ2110 {

    static int [] home;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(s.nextToken()); // 집
        int c = Integer.parseInt(s.nextToken()); // 공유기 개수

        home = new int[n];
        for (int i = 0; i < n; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(home);
        int st = 0;
        int en = Integer.MAX_VALUE;
        while (st < en){
            int mid = (st + en) / 2;   // 집 사이의 거리
            int count = calculate(mid);
            if(c <= count){
                st = mid + 1;
            }
            else en = mid;
        }
        System.out.println(en - 1);
    }
    public static int calculate(int input){ // 설치 가능한 공유기 수
        int cnt = 0;
        int last_idx = 0;
        for (int i = 0; i < home.length; i++) {
            if(last_idx == i){
                cnt++;
            }
            else{
                if(Math.abs(home[last_idx] - home[i]) >= input){
                    last_idx = i;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
/* 5 3

1 2 8 4 9


 */