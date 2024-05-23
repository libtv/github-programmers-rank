package boj.BarkingDog_Collection.Math;

// 골드바흐 파티션 실버2
import java.io.*;
import java.util.*;
public class BOJ17103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        int [] list = new int[t];
        int max = 0;
        for (int i = 0; i < t; i++) {
            int input = Integer.parseInt(br.readLine());
            list[i] = input;
            if(max < input) max = input;
        }

        boolean [] visited = new boolean[max + 1];

        ArrayList<Integer> tmp = new ArrayList<>();
        for (int i = 2; i <= max; i++) {
            if(visited[i]) continue;
            tmp.add(i);
            if(i > max / i) continue;
            for (int j = i * i; j <= max; j+= i) {
                visited[j] = true;
            }
        }

        // int [] array = tmp.stream().mapToInt(Integer::intValue).toArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int target = list[i];
            int start = 2;
            int end   = target - 2;
            int cnt = 0;
            while (start <= end){
                if(!visited[start] && !visited[end]) cnt++;
                start++;
                end--;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);

    }
}
