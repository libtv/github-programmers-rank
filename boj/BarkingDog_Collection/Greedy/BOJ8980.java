package boj.BarkingDog_Collection.Greedy;

// 택배 골드1
import java.util.*;
import java.io.*;
public class BOJ8980 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n =  Integer.parseInt(st.nextToken()); int capacity = Integer.parseInt(st.nextToken());
        int m  = Integer.parseInt(br.readLine());
        ArrayList<int []> list = new ArrayList<>();
        while (m-->0){
            st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        // 0 start 1 end 2 용량
        Collections.sort(list, (o1,o2)->{
            if(o1[1]!=o2[1]) return o1[1] - o2[1];
            else{
                if(o1[0]!=o2[0]) return o1[0] - o2[0];
                else  return -(o1[2] - o2[2]);
            }
        });

        int answer = 0;
        int [] DP = new int[n+1];
        for (int[] ints : list) {
            boolean flag = true;
            int min = Integer.MAX_VALUE;
            for (int i = ints[1] - 1; i >= ints[0]; i--) {
                if(DP[i] >= capacity){
                    flag = false;
                    break;
                }
                min = Math.min(capacity - DP[i], min);
            }
            if(flag) {
                min = Math.min(min, ints[2]);
                answer += min;
                for (int i = ints[1] - 1; i >= ints[0]; i--) {
                    DP[i] += min;
                }
            }
        }
        System.out.println(answer);
    }
}
/*
6 60
5
1 2 30
2 5 70
5 6 60
3 4 40
1 6 40

1 2 30
2 5 20
3 4 40
5 6 60
-> 150

[1, 2, 30]
[3, 4, 40]
[2, 5, 70]
[1, 6, 40]
[5, 6, 60]

DP[1] = 30
DP[3] = 40

[2, 5, 70]

DP[4] DP[3] DP[2] 60 - 40 = 20

DP[1] = 30 DP[2] = 20 DP[3] = 60 DP[4] = 20





 for (int i = 1; i <= n; i++) {
            // 해당 마을에서 받는 택배
            while (!delivery.isEmpty() && delivery.peek()[0] == i){
                answer += delivery.peek()[1];
                cur -= delivery.peek()[1];
                delivery.poll();
            }
            // 다른 마을로 보내는 택배
            while (cnt < list.size() && list.get(cnt)[0] == i){
                 int [] temp = list.get(cnt);
                 if(cur >= capacity){
                     cnt++;
                     continue;
                 }
                 if(cur + temp[2] <= capacity){
                    delivery.add(new int[]{temp[1], temp[2]});
                    cur += temp[2];
                 }
                 else if(cur + temp[2] > capacity){
                     System.out.println("-----------------------");
                     System.out.println(i);
                     System.out.println(capacity - cur);
                     System.out.println("-----------------------");
                     delivery.add(new int[]{temp[1], capacity - cur});
                     cur = capacity;
                 }
                 cnt++;
            }
        }
        System.out.println(answer);
 */




