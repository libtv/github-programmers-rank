package programmers.level3;

/**
 * 입국심사
 * level3
 * 알고리즘 고득점 kit
 * 이분탐색 - 매개변수 탐색
 */
import java.util.*;
public class EntryScreening {
    static int [] time;
    static int size;
    public long solution(int n, int[] times) {
        size = times.length;
        time = Arrays.copyOf(times, size);
        long start = 0;
        long end = Long.MAX_VALUE / 100;
        while(start < end){   // lower_bound
            long mid = (start + end) / 2;
            long count = calculate(mid);
            if(n <= count){
                end = mid;
            }
            else start = mid + 1;
        }
        return start;
    }
    public static long calculate(long check){
        long sum = 0;
        for(int i = 0; i < size; i++){
            sum += check / time[i];
        }
        System.out.println(check);
        System.out.println(sum);
        return sum;
    }
}
