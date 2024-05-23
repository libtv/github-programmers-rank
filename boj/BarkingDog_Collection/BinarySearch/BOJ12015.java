package boj.BarkingDog_Collection.BinarySearch;

// 가장 긴 증가하는 부분 수열 2 골드2
import java.io.*;
import java.util.*;
public class BOJ12015 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(tokenizer.nextToken());
            if(list.get(list.size() - 1) < input){
                list.add(input);
                continue;
            }
            // 이분 탐색
            int st = 0;
            int en = list.size() - 1;
            while (st < en){
                int mid = (st + en) / 2;
                if(list.get(mid) > input){
                    en = mid;
                }
                else if(list.get(mid) < input){
                    st = mid + 1;
                }
                else if(list.get(mid) == input){
                    st = mid;
                    break;
                }
            }
            list.set(st, input);
        }
        System.out.println(list.size() - 1);
    }
}