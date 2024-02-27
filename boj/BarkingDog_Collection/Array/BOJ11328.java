package org.example.boj.BarkingDog_Collection.Array;

// Strfry 브론즈2
import java.io.*;
import java.util.StringTokenizer;

public class BOJ11328 {
    static int [] a1;
    static int [] a2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (t-->0){
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            a1 = new int[26];
            a2 = new int[26];
            sb.append(strfry(a, b) ? "Possible" : "Impossible").append("\n");
        }
        System.out.println(sb);
    }
    public static boolean strfry(String a , String b){
        boolean flag = true;
        for (int i = 0; i < a.length() ; i++) {
            a1[a.charAt(i) - '0' - 49] += 1;
        }
        for (int i = 0; i < b.length(); i++) {
            a2[b.charAt(i) - '0' - 49] += 1;
        }
        for (int i = 0; i < 26 ; i++) {
            if(a1[i] != a2[i]){
                flag = false;
                break;
            }
        }
        return flag;
    }
}
