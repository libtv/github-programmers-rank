package programmers.level4;

/**
 * 징검다리
 * level4
 * binary search - parametric search
 */
import java.util.*;
public class SteppingStones {
    static int [] rock;
    static int size;
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        rock = new int [rocks.length + 2];
        rock[0] = 0;
        rock[rock.length - 1] = distance;
        for(int i = 1; i < rock.length - 1; i++){
            rock[i] = rocks[i-1];
        }
        int start = 1;
        int end   = distance;
        int answer = 0;
        while(start <= end){
            int mid = (start + end) / 2;
            int output = calculate(mid);
            if(output <= n){
                start = mid + 1;
                answer = mid;
            }
            else {
                end = mid - 1;
            }
        }
        return answer;
    }

    public static int calculate(long mid){
        int count = 0;

        if(rock[rock.length - 1] < mid) return rock.length;

        Stack<Integer> stack = new Stack<>();
        stack.push(rock[0]);
        for(int i = 1; i < rock.length; i++){
            if(rock[i] - stack.peek() >= mid){
                stack.push(rock[i]);
            }
            if(i == rock.length - 1 && rock[i] - stack.peek() < mid){
                stack.pop();
            }
            if(i == rock.length - 1 && stack.peek() != rock[i]){
                stack.push(rock[i]);
            }
        }
        return rock.length - stack.size();
    }
}
