package boj.BarkingDog_Collection.Floyd;

/**
 * 내일로 여행 골드3
 * Floyd
 */
import java.util.*;
import java.io.*;
public class BOJ13168 {
    static final int INF = 100000 * 100;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 도시의 수
        int r = Integer.parseInt(st.nextToken()); // 내일로 티켓 1인당 가격

        Map<String, Integer> city = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            city.put(st.nextToken(), i);
        }

        int t = Integer.parseInt(br.readLine()); // 여행할 도시의 수
        st = new StringTokenizer(br.readLine());
        Queue<Integer> plan = new LinkedList<>(); // 여행 순서
        for (int i = 0; i < t; i++) {
            plan.add(city.get(st.nextToken()));
        }

        int [][] r1 = new int[n][n]; // 내일로 티켓 산 가격
        int [][] r2 = new int[n][n]; // 내일로 티켓 사용 x

        // 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j) continue;
                r1[i][j] = INF;
                r2[i][j] = INF;
            }
        }

        int k = Integer.parseInt(br.readLine()); // k개의 교통수단
        while (k-->0){
            st = new StringTokenizer(br.readLine());
            String transport = st.nextToken();
            int s = city.get(st.nextToken());
            int e = city.get(st.nextToken());
            int cost = Integer.parseInt(st.nextToken()) * 2;

            // 내일로 티켓 : 무궁화호, ITX-새마을, ITX-청춘은 무료로 이용할 수 있으며, S-Train과 V-Train은 50% 할인된 가격으로 이용
            switch (transport){
                case "KTX" : {
                    if(r1[s][e] > cost){
                        r1[s][e] = cost;
                        r1[e][s] = cost;
                    }
                    if(r2[s][e] > cost){
                        r2[s][e] = cost;
                        r2[e][s] = cost;
                    }
                    break;
                }
                case "ITX-Saemaeul" : {
                    r1[s][e] = 0;
                    r1[e][s] = 0;
                    if(r2[s][e] > cost){
                        r2[s][e] = cost;
                        r2[e][s] = cost;
                    }
                    break;
                }
                case "ITX-Cheongchun" : {
                    r1[s][e] = 0;
                    r1[e][s] = 0;
                    if(r2[s][e] > cost){
                        r2[s][e] = cost;
                        r2[e][s] = cost;
                    }
                    break;
                }
                case "Mugunghwa" : {
                    r1[s][e] = 0;
                    r1[e][s] = 0;
                    if(r2[s][e] > cost){
                        r2[s][e] = cost;
                        r2[e][s] = cost;
                    }
                    break;
                }
                case "S-Train" : {
                    if(r1[s][e] > cost / 2){
                        r1[s][e] = cost / 2;
                        r1[e][s] = cost / 2;
                    }
                    if(r2[s][e] > cost){
                        r2[s][e] = cost;
                        r2[e][s] = cost;
                    }
                    break;
                }
                case "V-Train" : {
                    if(r1[s][e] > cost / 2){
                        r1[s][e] = cost / 2;
                        r1[e][s] = cost / 2;
                    }
                    if(r2[s][e] > cost){
                        r2[s][e] = cost;
                        r2[e][s] = cost;
                    }
                    break;
                }
                case "Subway" : {
                    if(r1[s][e] > cost){
                        r1[s][e] = cost;
                        r1[e][s] = cost;
                    }
                    if(r2[s][e] > cost){
                        r2[s][e] = cost;
                        r2[e][s] = cost;
                    }
                    break;
                }
                case "Bus" : {
                    if(r1[s][e] > cost){
                        r1[s][e] = cost;
                        r1[e][s] = cost;
                    }
                    if(r2[s][e] > cost){
                        r2[s][e] = cost;
                        r2[e][s] = cost;
                    }
                    break;
                }
                case "Taxi" : {
                    if(r1[s][e] > cost){
                        r1[s][e] = cost;
                        r1[e][s] = cost;
                    }
                    if(r2[s][e] > cost){
                        r2[s][e] = cost;
                        r2[e][s] = cost;
                    }
                    break;
                }
                case "Airplane" : {
                    if(r1[s][e] > cost){
                        r1[s][e] = cost;
                        r1[e][s] = cost;
                    }
                    if(r2[s][e] > cost){
                        r2[s][e] = cost;
                        r2[e][s] = cost;
                    }
                    break;
                }
                default: {
                    System.out.println("hi");
                    break;
                }
            }
        }
        // 플로이드 적용
        for (int l = 0; l < n; l++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(r1[i][j] > r1[i][l] + r1[l][j]){
                        r1[i][j] = r1[i][l] + r1[l][j];
                    }
                    if(r2[i][j] > r2[i][l] + r2[l][j]){
                        r2[i][j] = r2[i][l] + r2[l][j];
                    }
                }
            }
        }

        int sum1 = r * 2; // 내일로 티켓 o
        int sum2 = 0; // 내일로 티켓 x
        int start = plan.peek();
        while (!plan.isEmpty()){
            sum1 += r1[start][plan.peek()];
            sum2 += r2[start][plan.peek()];
            start = plan.peek();
            plan.poll();
        }
        System.out.println(sum1);
        System.out.println(sum2);

        if(sum1 < sum2) System.out.println("Yes");
        else System.out.println("No");
    }
}
