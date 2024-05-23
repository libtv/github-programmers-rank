package boj.BarkingDog_Collection.Simulation;

/**
 * 스마트 택시 골드2
 * Simulation
 * 나중에 다시 풀어보기 -> 문맥 파악 실수로 오래 걸림
 */
import java.io.*;
import java.util.*;
public class BOJ19238 {
    static int n,m,f; // 영역의 크기 : n, 승객의 숫자 m, 연료의 량 f
    static int [][] map;
    static int [][] start; // 손님 출발지
    static int [] cur = new int[2]; // cur[0] 행 cur[1] 열  택시의 위치
    static boolean success = false;
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    static int [][] memo;

    static final int INF = 20 * 20 + 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        start = new int[n][n];
        memo = new int[m+2][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); // 0은 빈칸 1은 벽
                start[i][j] = map[i][j];
            }
        }
        st = new StringTokenizer(br.readLine());
        cur[0] = Integer.parseInt(st.nextToken()) - 1;  // x
        cur[1] = Integer.parseInt(st.nextToken()) - 1;  // y

        int cnt = 2;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken()) - 1;
            int sy = Integer.parseInt(st.nextToken()) - 1;
            int ex = Integer.parseInt(st.nextToken()) - 1;
            int ey = Integer.parseInt(st.nextToken()) - 1;
            start[sx][sy] = cnt;
            memo[cnt][0] = ex;
            memo[cnt][1] = ey;
            cnt++;
        }
        Simulation();
        if(success) System.out.println(f);
        else System.out.println(-1);

    }
    public static void Simulation(){
        // 현재 택시 위치에서 다음 위치 찾기 start로
        int [][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = INF;
            }
        }
        ArrayList<int[]> start_list = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();

        if(start[cur[0]][cur[1]] == 0){
            copy[cur[0]][cur[1]] = 0;
            q.add(new int[]{cur[0], cur[1], 0});
        }
        else if(start[cur[0]][cur[1]] > 1){ // 현재 택시 위치가 손님 시작 위치라면 bfs 필요x
            start_list.add(new int[]{cur[0], cur[1], 0});
        }
        while (!q.isEmpty()){ // 만약 시간초과 발생하면 개선해야 하는 부분 -> start위치를 최로 찾는 순간 해당 거리보다 더 큰 bfs는 중단
            int [] temp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + arx[i];
                int ny = temp[1] + ary[i];
                if(!validation(nx,ny) || map[nx][ny] == 1 || copy[nx][ny] <= temp[2] + 1) continue;
                copy[nx][ny] = temp[2] + 1;
                if(start[nx][ny] > 1){
                    start_list.add(new int[]{nx,ny, temp[2] + 1});
                }
                q.add(new int[]{nx,ny,temp[2] + 1});
            }
        }

        // 정렬 -> 최단거리 순서로 최단거리가 같으면 -> 행이 작은 순서대로 행이 같으면 열이 작은 순서대로
        Collections.sort(start_list, (o1,o2)->{
            if(o1[2] != o2[2]) return o1[2] - o2[2];
            else{
                if(o1[0] != o2[0]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

       if(start_list.isEmpty()) return;
       int [] start_arr = start_list.get(0);
       if(f - start_arr[2] < 0) return; // 남은 연료가 출발지 까지 가는 비용보다 작으면

        cur[0] = start_arr[0]; // 택시 위치 바꾸기
        cur[1] = start_arr[1];

        f -= start_arr[2]; // 연료 빼기
        int id = start[cur[0]][cur[1]]; // 손님 identity
        start[cur[0]][cur[1]] = 0;

        copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = INF;
            }
        }
        q.add(new int[]{cur[0], cur[1], 0});
        copy[cur[0]][cur[1]] = 0;
        int ex = memo[id][0];
        int ey = memo[id][1];
        int distance = -1;
        while (!q.isEmpty()){
            int [] temp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + arx[i];
                int ny = temp[1] + ary[i];
                if(!validation(nx,ny) || map[nx][ny] == 1 || copy[nx][ny] <= temp[2] + 1) continue;
                if(nx == ex && ny == ey){
                    distance = temp[2] + 1;
                    q.clear();
                    break;
                }
                else{
                    copy[nx][ny] = temp[2] + 1;
                    q.add(new int[]{nx,ny, temp[2] + 1});
                }
            }
        }
        if(f - distance < 0 || distance == -1) return;
        f += distance; // 연료 2배 채워짐
        cur[0] = ex;
        cur[1] = ey;
        m--;

        if(m == 0) success = true;
        else Simulation();
    }
    public static boolean validation(int nx, int ny){
        if(0 <= nx && 0 <= ny && nx < n && ny < n) return true;
        return false;
    }
}
/* 문제 설명

목표
택시 기사 최백준은 오늘 M명의 승객을 태우는 것이 목표

영역
백준이 활동할 영역은 N×N 크기의 격자 & 각 칸은 비어 있거나 벽이 놓여 있다

이동
택시가 빈칸에 있을 때, 상하좌우로 인접한 빈칸 중 하나로 이동할 수 있다
알고리즘 경력이 많은 백준은 특정 위치로 이동할 때 항상 최단경로로만 이동한다.
M명의 승객은 빈칸 중 하나에 서 있으며, 다른 빈칸 중 하나로 이동하려고 한다
여러 승객이 같이 탑승하는 경우는 없다. 백준은 한 승객을 태워 목적지로 이동시키는 일을 M번 반복
출발지에서만 택시에 탈 수 있고, 목적지에서만 택시에서 내릴 수 있다.

백준이 태울 승객을 고를 때는 현재 위치에서 최단거리가 가장 짧은 승객을 고른다.
그런 승객이 여러 명이면 그중 행 번호가 가장 작은 승객을, 그런 승객도 여러 명이면 그중 열 번호가 가장 작은 승객을 고른다.
택시와 승객이 같은 위치에 서 있으면 그 승객까지의 최단거리는 0이다

연료
연료는 한 칸 이동할 때마다 1만큼 소모된다.
한 승객을 목적지로 성공적으로 이동시키면, 그 승객을 태워 이동하면서 소모한 연료 양의 두 배가 충전
이동하는 도중에 연료가 바닥나면 이동에 실패하고, 그 날의 업무가 끝난다.
승객을 목적지로 이동시킨 동시에 연료가 바닥나는 경우는 실패한 것으로 간주하지 않는다

모든 승객을 성공적으로 데려다줄 수 있는지 알아내고, 데려다줄 수 있을 경우 최종적으로 남는 연료의 양을 출력하는 프로그램을 작성하시오.


 */