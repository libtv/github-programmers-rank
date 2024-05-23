package boj.BarkingDog_Collection.BinarySearch;

// 숫자 카드 실버5
import java.util.*;
import java.io.*;
public class BOJ10815 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int [] cards = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n ; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        int t = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-->0){

            int cur = Integer.parseInt(st.nextToken());
            if(Arrays.binarySearch(cards, cur) >= 0) sb.append(1);
            else sb.append(0);

            sb.append(" ");

        }
        System.out.println(sb);

    }
}
