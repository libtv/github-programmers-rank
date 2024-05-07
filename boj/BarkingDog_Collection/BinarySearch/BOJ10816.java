package boj.BarkingDog_Collection.BinarySearch;

// 숫자 카드 2 실버4
import java.io.*;
import java.util.*;
public class BOJ10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int [] cards = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        System.out.println(Arrays.toString(cards));

        int t = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int target = Integer.parseInt(st.nextToken());

            int left = 0;
            int right = 0;

            int start = 0;
            int end   = n;
            while (start < end){
                int mid = (start + end) / 2;
                if(cards[mid] <= target){
                    start = mid + 1;
                }
                else end = mid;
            }
            right = end;

            start = 0;
            end   = n;
            while (start < end){
                int mid = (start + end) / 2;
                if(cards[mid] >= target){
                    end = mid;
                }
                // cards[mid] < target
                else start = mid + 1;
            }
            left = start;

            sb.append(right - left).append(" ");
        }
        System.out.println(sb);
    }
}
