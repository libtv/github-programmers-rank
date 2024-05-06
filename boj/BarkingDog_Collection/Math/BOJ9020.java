package boj.BarkingDog_Collection.Math;

// 골드바흐의 추측 실버2
import java.io.*;
public class BOJ9020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        int [] list = new int[t];

        int max = 0;

        for (int i = 0; i < t; i++) {
            list[i] = Integer.parseInt(br.readLine());
            if(max < list[i]) max = list[i];
        }

        // 에라토스테네스 체
        boolean [] visited = new boolean[max + 1];

        for (int i = 2; i <= max; i++) {
            if(visited[i]) continue;
            for (int j = i * i; j <= max; j+=i) {
                visited[j] = true;
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int target = list[i];
            int start = 2;
            int end   = target - 2;
            int a = 0;
            int b = 0;
            while (start <= end){
                if(!visited[start] && !visited[end]){
                    a = start;
                    b = end;
                }
                start++;
                end--;
            }
            sb.append(a).append(" ").append(b).append("\n");
        }
        System.out.println(sb);
    }
}
