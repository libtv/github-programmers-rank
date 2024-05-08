package boj.BarkingDog_Collection.BinarySearch;

// 좋다 골드4
import java.io.*;
import java.util.*;
public class BOJ1253_2 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] array = new int[n];
        StringTokenizer s = new StringTokenizer(br.readLine());

        for (int i = 0; i < n ; i++) {
            array[i] = Integer.parseInt(s.nextToken());
        }
        Arrays.sort(array);

        int sum = 0;
        boolean [] finish = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(finish[i] || i == j) continue;
                int target = array[i] - array[j];

                int st = 0;
                int en = n;
                int left = 0;
                int right = 0;

                while (st < en){
                    int mid = (st + en) / 2;
                    if(array[mid] <= target){
                        st = mid + 1;
                    }
                    else en = mid;
                }
                right = en;

                st = 0;
                en = n;
                while (st < en){
                    int mid = (st + en) / 2;
                    if(array[mid] < target){
                        st = mid + 1;
                    }
                    else en = mid;
                }
                left = st;

                for (int k = left; k < right; k++) {
                    if(k != i && k != j){
                        finish[i] = true;
                        sum++;
                        break;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
