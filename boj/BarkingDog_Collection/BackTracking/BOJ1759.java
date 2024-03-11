package org.example.boj.BarkingDog_Collection.BackTracking;

// 암호 만들기 골드5
import java.io.*;
import java.util.*;
public class BOJ1759 {
    static int l; static int c; static String [] answer; static String [] arr;
    static HashSet<String> set1 = new HashSet<>(); // a, i, e, o, u
    static HashSet<String> set2 = new HashSet<>(); // 나머지
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken()); c = Integer.parseInt(st.nextToken());
        answer = new String[l]; arr = new String[c];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c ; i++) {
            arr[i] = st.nextToken();
            if(arr[i].equals("a") || arr[i].equals("i") || arr[i].equals("e") || arr[i].equals("o") || arr[i].equals("u"))
                 set1.add(arr[i]);
            else set2.add(arr[i]);
        }
        Arrays.sort(arr); // 사전식 정렬
        sb = new StringBuilder();
        BackTracking(0, 0, 0, 0);
        System.out.println(sb);
    }
    public static void BackTracking(int depth, int cur, int cnt1, int cnt2){
        if(depth == l || cur == c){
            if(depth == l && cnt1 >=1 && cnt2 >= 2){
                for (int i = 0; i < l ; i++) {
                    sb.append(answer[i]);
                }
                sb.append("\n");
            }
            return;
        }
        for (int i = cur; i < c; i++) {
            answer[depth] = arr[i];
            BackTracking(depth + 1, i + 1, set1.contains(answer[depth])? cnt1 + 1 : cnt1, set2.contains(answer[depth])? cnt2 + 1 : cnt2 );
        }
    }
}
