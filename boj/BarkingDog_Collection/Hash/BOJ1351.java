package boj.BarkingDog_Collection.Hash;

// 무한 수열 골드5
import java.util.*;
import java.io.*;
public class BOJ1351 {
    static HashMap<Long, Long> map = new HashMap<>();
    static long p,q;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        p = (long)Integer.parseInt(st.nextToken());
        q = (long)Integer.parseInt(st.nextToken());
        map.put(0L, 1L);
        map.put(1L, 2L);
        find(n);
        System.out.println(map.get(n));
    }
    public static void find(long target){
        if(map.containsKey(target)){
            return;
        }
        long sum = 0;
        long idx1 = target / p;
        long idx2 = target / q;
        if(map.containsKey(idx1)){
            sum += map.get(idx1);
        }
        else{
            find(idx1);
            sum += map.get(idx1);
        }

        if(map.containsKey(idx2)){
            sum += map.get(idx2);
        }
        else{
            find(idx2);
            sum += map.get(idx2);
        }
        map.put(target, sum);
    }
}
