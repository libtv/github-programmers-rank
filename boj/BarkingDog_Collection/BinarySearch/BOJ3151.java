package boj.BarkingDog_Collection.BinarySearch;

// 합이 0 골드4
import java.util.*;
import java.io.*;
public class BOJ3151 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer s = new StringTokenizer(br.readLine());
        int [] student = new int[n];
        for (int i = 0; i < n ; i++) {
            student[i] = Integer.parseInt(s.nextToken());
        }
        Arrays.sort(student);

        long cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int target = -(student[i] + student[j]);
                int st = j + 1;
                int en = n;
                int left = 0;
                int right = 0;
                // upper
                while (st < en){
                    int mid = (st + en) / 2;
                    if(student[mid] > target){
                        en = mid;
                    }
                    else if(student[mid] <= target){
                        st = mid + 1;
                    }
                }
                right = en;
                st = j + 1;
                en = n;
                // lower
                while (st < en){
                    int mid = (st + en) / 2;
                    if(student[mid] < target){
                        st = mid + 1;
                    }
                    else if(student[mid] >= target){
                        en = mid;
                    }
                }
                left = st;
                cnt += (right - left);
            }
        }
        System.out.println(cnt);
    }
}
/*

6
-8 3 3 5 5 5

-8 3  5



 */