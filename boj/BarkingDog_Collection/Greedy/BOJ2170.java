package boj.BarkingDog_Collection.Greedy;

// 선 긋기 골드5
import java.io.*;
import java.util.*;
public class BOJ2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<int []> list = new ArrayList<>();
        while (n-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        Collections.sort(list, (o1, o2) ->{
            if(o1[0] != o2[0]) return o1[0]-o2[0];
            else return o1[1]-o2[1];
        });
        int sum = 0;
        int min = 0;
        int max = 0;
        boolean first = true;
        for (int[] ints : list) {
            if(first){
                sum += ints[1] - ints[0];
                min = ints[0];
                max = ints[1];
                first = false;
                continue;
            }
            int start = ints[0];
            int end   = ints[1];
            if(min <= start && end <= max){
                continue;
            }
            if(min <= start && start <= max && max < end){
                sum += end - max;
                max = end;
            }
            else if(max < start){
                sum += end - start;
                min = start;
                max = end;
            }
        }
        System.out.println(sum);
    }
}
