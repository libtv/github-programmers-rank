package boj.BarkingDog_Collection.BinarySearch;

// 수 찾기 실버4
import java.util.*;
import java.io.*;
public class BOJ1920_CollectionsBinarySearch {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> A = new ArrayList<>();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        while (n-->0){
            A.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(A);

        int t = Integer.parseInt(br.readLine());
        int [] array = new int[t];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < t; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t ; i++) {
            int target = array[i];
            int index = Collections.binarySearch(A, target);
            if(index >= 0) sb.append(1);
            else sb.append(0);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
