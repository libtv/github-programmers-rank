package boj.BarkingDog_Collection.BinarySearch;

// 좌표 압축 실버2
import java.io.*;
import java.util.*;
public class BOJ18870 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] array = new int[n];
        Set<Integer> set = new HashSet<>();
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
            set.add(array[i]);
        }

        int [] arr = set.stream().sorted((o1, o2) -> {
            return o1.compareTo(o2);
        }).mapToInt(Integer::intValue).toArray();

        // 2 4 -10 4 -9
        // [-10,-9,2,4]

        StringBuilder sb = new StringBuilder();
        int size = arr.length;
        for (int i = 0; i < n; i++) {
            int target = array[i];
            int st = 0;
            int et = size - 1;
            while (st <= et){
                int mid = (st + et) / 2;
                if(arr[mid] == target){
                    sb.append(mid).append(" ");
                    break;
                }
                else if(arr[mid] > target){
                    et = mid - 1;
                }
                else{
                    st = mid + 1;
                }
            }
        }
        System.out.println(sb);
    }
}
