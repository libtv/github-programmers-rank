package boj.BarkingDog_Collection.Greedy;

// 멀티탭 스케줄링
import java.io.*;
import java.util.*;
public class BOJ1700 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int capacity = Integer.parseInt(st.nextToken()); // 멀티탭 구멍의 개수
        int num      = Integer.parseInt(st.nextToken()); // 전기 용품의 총 사용 횟수
        int [] use   = new int[num+1];
        int [] sequence = new int[num];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            int input = Integer.parseInt(st.nextToken());
            sequence[i] = input;
            use[input]++;
        }
        boolean [] visited = new boolean[num+1];
        int cnt   = 0;
        int count = 0;
        ArrayList<int []> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int target = sequence[i];
            if(visited[target]){
                for (int j = 0; j < list.size(); j++) {
                    int [] ints = list.get(j);
                    if(ints[0] == target){
                        ints[1]--;
                        use[target]--;
                        break;
                    }
                }
            }
            else{
                if(list.size() + 1 <= capacity){
                    use[target]--;
                    visited[target] = true;
                    list.add(new int[]{target, use[target]});
                }
                else{
                    use[target]--;
                    visited[target] = true;
                    count++;
                    boolean find = false; // <- 남은 사용 횟수가 0인 장비
                    int idx = 0;
                    int max = 0;
                    for (int j = 0; j < list.size(); j++) {
                        int [] get = list.get(j);
                        if(get[1] == 0){
                            find = true;
                            visited[get[0]] = false;
                            idx = j;
                            break;
                        }
                        else{
                            for (int k = i+1; k < num; k++) {
                                if(sequence[k] == get[0]){
                                    if(max < k){
                                        max = k;
                                        idx = j;
                                    }
                                    break;
                                }
                            }
                        }
                    }
                    if(find){
                        list.remove(idx);
                    }
                    else{
                        visited[list.get(idx)[0]] = false;
                        list.remove(idx);
                    }
                    list.add(new int[] {target, use[target]});
                }
            }
            System.out.println(target);
            for (int[] ints : list) {
                System.out.println(Arrays.toString(ints));
            }
        }
        System.out.println(count);
    }
}
/*
키보드                1
헤어드라이기           2
핸드폰 충전기          3
디지털 카메라 충전기    4
키보드                1
헤어드라이기           2

--> I need more info 만약 남은 횟수가 같다고 하면 어떤걸 멀티탭에서 빼야할까?



 */