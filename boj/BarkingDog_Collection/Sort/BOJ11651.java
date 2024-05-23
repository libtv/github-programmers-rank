package boj.BarkingDog_Collection.Sort;

// 좌표 정렬하기2 실버5
import java.io.*;
import java.util.*;
public class BOJ11651 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<int []> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] > o2[1])return 1;
                else if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                else return -1;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n ; i++) {
            int [] temp = list.get(i);
            sb.append(temp[0]).append(" ").append(temp[1]).append("\n");
        }
        System.out.println(sb);
    }
}
