package boj.BarkingDog_Collection.Simulation;

// 톱니바퀴 골드5
import java.io.*;
import java.util.*;
public class BOJ14891 {
    static LinkedList<Integer>[] dq;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dq = new LinkedList[4];
        for (int i = 0; i < 4; i++) {
            dq[i] = new LinkedList<>();
            String [] split = br.readLine().split("");
            for (int j = 0; j < 8; j++) { // 0이면 N극 false 1이면 S극 true
                dq[i].add(Integer.parseInt(split[j]));
            }
        }
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        // 0: 12시  / 2:  3시  / 6 : 9시
        while (n-->0){
            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken()) - 1;
            int how    = Integer.parseInt(st.nextToken());
            int cur = how;
            ArrayList<int[]> list = new ArrayList<>();
            list.add(new int[]{target, how});
            for (int i = target; i > 0; i--) {
                if(dq[i].get(6)==dq[i - 1].get(2)){
                    break;
                }
                cur *= -1;
                list.add(new int[]{i - 1, cur});
            }
            cur = how;
            for (int i = target; i < 3 ; i++) { // 3시랑 9시 비교
                if(dq[i].get(2)==dq[i + 1].get(6)){
                     break;
                }
                cur *= -1;
                list.add(new int[]{i + 1, cur});
            }
            for (int i = 0; i < list.size(); i++) {
                int [] temp = list.get(i);
                if(temp[1] == 1){
                    dq[temp[0]].offerFirst(dq[temp[0]].pollLast());
                }
                else{
                    dq[temp[0]].offerLast(dq[temp[0]].pollFirst());
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < 4 ; i++) {
            if(i == 0 && dq[i].peekFirst() == 1){
                sum += 1;
            }
            if(i == 1 && dq[i].peekFirst() == 1){
                sum += 2;
            }
            if(i == 2 && dq[i].peekFirst() == 1){
                sum += 4;
            }
            if(i == 3 && dq[i].peekFirst() == 1){
                sum += 8;
            }
        }
        System.out.println(sum);

    }
}
