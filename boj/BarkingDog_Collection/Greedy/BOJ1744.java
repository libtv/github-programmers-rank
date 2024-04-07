package boj.BarkingDog_Collection.Greedy;

// 수 묶기 골드4
import java.util.*;
import java.io.*;
public class BOJ1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[3];  // 0 은 음수 1은 0 2는 양수
        int [] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(br.readLine());
            if(data[i] > 0) arr[2]++;
            else if(data[i] == 0) arr[1]++;
            else arr[0]++;
        }
        Arrays.sort(data);
        LinkedList<Integer> dq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            dq.addLast(data[i]);
        }
        int max = 0;
        while (!dq.isEmpty()){
            int cur = dq.pollLast();

            if(dq.isEmpty()){
                max += cur;
                break;
            }

            if(cur > 0){
                arr[2]--;
                if(arr[2] > 0){
                    if(dq.peekLast() * cur > dq.peekLast() + cur){
                        max += dq.pollLast() * cur;
                    }
                    else max += dq.pollLast() + cur;
                    arr[2]--;
                }
                else max += cur;
            }
            else if(cur == 0){
                arr[1]--;
                if(arr[0] > 0){ // minus가 남아 있다면?
                    if(arr[0] % 2 != 0){
                        dq.remove(arr[0] - 1);
                        arr[0]--;
                    }
                }
            }
            else{
                arr[0]--;
                if(arr[0] > 0){
                    if(arr[0] % 2 == 0){
                        max += cur;
                    }
                    else{
                        max += dq.get(arr[0] - 1) * cur;
                        dq.remove(arr[0] - 1);
                        arr[0]--;
                    }
                }
            }
        }
        System.out.println(max);
    }
}
/*
5
-1
0
-2
-10
5
answer = 25
 */