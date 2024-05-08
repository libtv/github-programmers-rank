package boj.BarkingDog_Collection.BinarySearch;

import java.io.*;
import java.util.*;

// 세 용액 골드3
public class BOJ2473 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] liquid = new int[n];
        StringTokenizer s = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            liquid[i] = Integer.parseInt(s.nextToken());
        }
        Arrays.sort(liquid);

        long min = Long.MAX_VALUE;
        int [] answer = new int[3];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long cur = liquid[i] + liquid[j];
                int st = 0;
                int en = n - 1;
                while (st <= en){
                    int mid = (st + en) / 2;
                    long temp = cur + liquid[mid];
                    if(min > Math.abs(temp)){
                        if(mid != i && mid != j){
                            min = Math.abs(temp);
                            answer[0] = liquid[i];
                            answer[1] = liquid[j];
                            answer[2] = liquid[mid];
                        }
                        else{
                            int left  = 0;
                            int right = 0;

                            int sx = 0;
                            int ex = n;
                            while (sx < ex){
                                int mx = (sx + ex) / 2;
                                if(liquid[mid] <= liquid[mx]){
                                    sx = mx + 1;
                                }
                                else ex = mx;
                            }
                            right = ex;

                            sx = 0;
                            ex = n;
                            while (sx < ex){
                                int mx = (sx + ex) / 2;
                                if(liquid[mid] > liquid[mx]){
                                    sx = mx + 1;
                                }
                                else ex = mx;
                            }
                            left = sx;
                            for (int k = left; k < right; k++) {
                                if(k != i && k != j && liquid[k] == liquid[mid]){
                                    min = Math.abs(temp);
                                    answer[0] = liquid[i];
                                    answer[1] = liquid[j];
                                    answer[2] = liquid[mid];
                                    break;
                                }
                            }
                        }
                    }
                    if(temp > 0){
                        en = mid - 1;
                    }
                    else if(temp < 0){
                        st = mid + 1;
                    }
                    else break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(answer);
        for (int i : answer) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
