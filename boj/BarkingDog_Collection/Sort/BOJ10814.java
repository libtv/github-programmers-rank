package boj.BarkingDog_Collection.Sort;

// 나이순 정렬 실버5
import java.io.*;
import java.util.*;
public class BOJ10814 {
    static class compare implements Comparator<String []>{
        public int compare(String [] o, String [] o2){
            int temp1 = Integer.parseInt(o[0]);
            int temp2 = Integer.parseInt(o2[0]);
            if(temp1 > temp2) return 1;
            else if(temp1 == temp2) return 0;
            return -1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String []> list = new ArrayList<>();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new String[]{st.nextToken(), st.nextToken()});
        }
        Collections.sort(list, new compare());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n ; i++) {
            String [] temp = list.get(i);
            sb.append(temp[0]).append(" ").append(temp[1]).append("\n");
        }
        System.out.println(sb);
    }
}
