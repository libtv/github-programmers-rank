package boj.BarkingDog_Review;

// 멀티탭 스케줄링
import java.io.*;
import java.util.*;
public class BOJ_13_1700 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 멀티탭 구멍의 개수
        int k = Integer.parseInt(st.nextToken()); // 전기용품 사용횟수

        int [] memo = new int[k+1];               // 물건의 사용횟수

        st = new StringTokenizer(br.readLine());
        int [] sequence = new int[k];             // 물건의 사용 순서
        for (int i = 0; i < k; i++) {
            int item = Integer.parseInt(st.nextToken());
            sequence[i] = item;
            memo[item]++;
        }
        int count = 0;
        ArrayList<int []> Multitap = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int item = sequence[i];
            memo[item]--;

            boolean isAlready = false;      // 이미 멀티탭에 있으면?
            for (int[] ints : Multitap) {
                if(ints[0] == item){
                    ints[1]--;              // 남은 사용횟수 줄여주기
                    isAlready = true;
                    break;
                }
            }

            if(isAlready) continue;

            if(Multitap.size() + 1 <= n){    // 멀티탭에 공간이 있다면?
                Multitap.add(new int[]{item, memo[item]});
            }
            else{  // 멀티탭에 남은 공간이 없다면?

                count++;

                // 남은 사용횟수가 0인 아이템 찾기 + 없다면 사용 타이밍이 가장 늦는 아이텀 찾기
                int target = 0;
                int length = 0;
                boolean flag = false;
                for (int j = 0; j < n; j++) {
                    int [] temp = Multitap.get(j);
                    if(temp[1] == 0){
                        Multitap.remove(j);
                        Multitap.add(new int[]{item, memo[item]});
                        flag = true;
                        break;
                    }
                    for (int l = i + 1; l < k; l++) {
                        if(sequence[l] == temp[0]){
                            if(length < l){
                                length = l;
                                target = j;
                            }
                            break;
                        }
                    }
                }
                if(flag) continue;
                Multitap.remove(target);
                Multitap.add(new int[]{item, memo[item]});
            }
        }
        System.out.println(count);
    }
}
