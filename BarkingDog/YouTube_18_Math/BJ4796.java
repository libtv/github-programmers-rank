package BarkingDog.YouTube_18_Math;

import java.io.*;
import java.util.StringTokenizer;

// 캠핑 브론즈1
public class BJ4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        while (true){
            int sum = 0;
            cnt ++;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken()); // 사용 가능 날짜
            int P = Integer.parseInt(st.nextToken()); // 연속되는 날짜
            int V = Integer.parseInt(st.nextToken()); // 휴가 기간
            if(L == 0 && P == 0 && V == 0){
                break;
            }
            sum += (V / P) * L;
            V = V % P;
            if(V <= L){
                sum += V;
            }
            else{
                sum += L;
            }
            sb.append("Case").append(" ").append(cnt).append(":").append(" ").append(sum).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
캠핑장은 연속하는 20일 중 10일동안만 사용할 수 있습니다.
강산이는 이제 막 28일 휴가를 시작했다. 이번 휴가 기간 동안 강산이는 캠핑장을 며칠동안 사용할 수 있을까?

연속하는 8일중에 5일만 사용가능
20 / 8 = 16... 4


 */