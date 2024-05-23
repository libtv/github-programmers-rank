package boj.BarkingDog_Collection.BinarySearch;

/**
 * 휴게소 세우기 골드4
 */
import java.io.*;
import java.util.*;
public class BOJ1477 {
    static int n,m,l;
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        if(n != 0){
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int idx = Integer.parseInt(st.nextToken());
                list.add(idx);
            }
        }
        list.add(0);
        list.add(l);
        Collections.sort(list);
        int start = 1;
        int end   = l;
        while (start < end){
            int mid = (start + end) / 2;
            int output = search(mid);
            if(output <= m){
                end = mid;
            }
            else start = mid + 1;
        }
        System.out.println(start);
    }
    public static int search(int dis){
        int count = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            int check = list.get(i + 1) - list.get(i);
            count += check / dis;
            if(check % dis == 0) count--;
        }
        return count;
    }
}
