package boj.BarkingDog_Collection.DP;

// LCS 골드5
import java.io.*;
import java.util.*;
public class BOJ9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String o1 = br.readLine();
        String o2 = br.readLine();
        int [][] DP = new int[o1.length()+1][o2.length()];
        for (int i = 1; i <= o1.length(); i++) {
            char temp = o1.charAt(i-1);
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < o2.length(); j++) {
                if(o2.charAt(j) == temp) list.add(j);
            }
            int start = 0;
            int max = 0;
            for (int j = 0; j < list.size(); j++) {
                int get = list.get(j);
                for (int k = start; k < get; k++) {
                    if(max < DP[i-1][k]) max = DP[i-1][k];
                }
                DP[i][get] = max + 1;
                start = get;
            }
            for (int j = 0; j < o2.length(); j++) {
                if(DP[i][j] == 0){
                    DP[i][j] = DP[i-1][j];
                }
            }
        }
        int max = 0;
        for (int i = o2.length() - 1; i >=0; i--) {
            if(max < DP[o1.length()][i]) max = DP[o1.length()][i];
        }
        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
        br.close();
    }
}
