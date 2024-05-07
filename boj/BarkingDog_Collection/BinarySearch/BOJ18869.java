package boj.BarkingDog_Collection.BinarySearch;

// 멀티버스 2 골드5
import java.util.*;
import java.io.*;
public class BOJ18869 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        stringTokenizer = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int n = Integer.parseInt(stringTokenizer.nextToken());

        int [][] universe = new int[m][n];
        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                universe[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        // 좌표 압축이 필요하다.
        for (int i = 0; i < m; i++) {
            int [] temp = Arrays.copyOf(universe[i], universe[0].length);
            Arrays.sort(temp);
            for (int j = 0; j < n; j++) {
                int target = universe[i][j];
                int st = 0;
                int en = n - 1;
                while (st <= en){
                    int mid = (st + en) / 2;
                    if(temp[mid] == target){
                        universe[i][j] = mid;
                        break;
                    }
                    else if(temp[mid] > target){
                        en = mid - 1;
                    }
                    else st = mid + 1;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                boolean flag = true;
                for (int k = 0; k < n; k++) {
                    if(universe[i][k] != universe[j][k]){
                        flag = false;
                        break;
                    }
                }
                if(flag) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
