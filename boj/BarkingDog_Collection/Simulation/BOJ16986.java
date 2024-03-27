package boj.BarkingDog_Collection.Simulation;

// 인싸들의 가위바위보 골드3
import java.io.*;
import java.util.*;
public class BOJ16986 {
    static int n, k; static int [][] info; // 상성 정보
    static int [][] data = new int[2][20];
    static int [] memo = new int[3]; // 승점 기록
    static int answer = 0; // 정답
    static boolean [] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 손동작의 수
        k = Integer.parseInt(st.nextToken()); // 필요한 승수

        info = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 2 ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 20; j++) {
                data[i][j] = Integer.parseInt(st.nextToken()) - 1;
            }
        }
        visited = new boolean[n];
        BackTracking(0, 0, 1, 0, 0);
        System.out.println(answer);
    }
    public static void BackTracking(int depth, int p1, int p2, int cnt1, int cnt2){
        if(answer == 1) return;
        if(memo[0] >= k  && memo[1] < k && memo[2] < k){ // 지우 우승!
            answer = 1;
            return;
        }
        for (int i = 1; i < 3; i++) { // 다른 누군가 이미 우승
            if(memo[i] >= k) return;
        }
        if(depth == 20) return; // 경기 끝

        if(p1 == 0){ // p2는 1 아니면 2
            int play = p2 == 1 ? data[p2-1][cnt1] : data[p2-1][cnt2]; // 상대 플레이어가 낸 동작
            int result = 0;
            // 지우 입장에서 ~
            for (int i = 0; i < n; i++) {
                if(visited[i]) continue;
                result = info[i][play];
                if(result == 2){ // 지우 승리
                    visited[i] = true;
                    memo[0]++;
                    BackTracking(depth + 1, 0, p2 == 1 ? 2 : 1, p2 == 1 ? cnt1 + 1 : cnt1, p2 == 2 ? cnt2 + 1 : cnt2);
                    memo[0]--;
                    visited[i] = false;
                }
                else{ // 지우 패배
                    visited[i] = true;
                    memo[p2]++;
                    BackTracking(depth + 1, 1, 2,  p2 == 1 ? cnt1 + 1 : cnt1, p2 == 2 ? cnt2 + 1 : cnt2);
                    memo[p2]--;
                    visited[i] = false;
                }
            }
        }
        else if(p2 == 0){
            int play = p1 == 1 ? data[p1-1][cnt1] : data[p1-1][cnt2]; // 상대 플레이어가 낸 동작
            int result = 0;
            for (int i = 0; i < n; i++) {
                if(visited[i]) continue;
                result = info[i][play];
                if(result == 2){ // 지우 승리
                    visited[i] = true;
                    memo[0]++;
                    BackTracking(depth + 1, 0, p1 == 1 ? 2 : 1,  p1 == 1 ? cnt1 + 1 : cnt1, p1 == 2 ? cnt2 + 1 : cnt2 );
                    memo[0]--;
                    visited[i] = false;
                }
                else{
                    visited[i] = true;
                    memo[p1]++;
                    BackTracking(depth + 1, 1, 2,  p1 == 1 ? cnt1 + 1 : cnt1, p1 == 2 ? cnt2 + 1 : cnt2);
                    memo[p1]--;
                    visited[i] = false;
                }
            }
        }
        else{
            p1 = 1;
            p2 = 2;
            int play1 = data[p1-1][cnt1]; int play2 = data[p2-1][cnt2];
            int result = info[play1][play2];
            if(result == 2){ // player1 승리
                memo[p1]++;
                BackTracking(depth + 1, 0, p1, cnt1 + 1, cnt2 + 1);
                memo[p1]--;
            }
            else{ // player2 승리
                memo[p2]++;
                BackTracking(depth + 1, 0, p2, cnt1 + 1, cnt2 + 1);
                memo[p2]--;
            }
        }
    }
}
