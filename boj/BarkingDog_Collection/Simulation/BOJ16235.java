package boj.BarkingDog_Collection.Simulation;

// 나무 재테크 골드3
import java.io.*;
import java.util.*;
public class BOJ16235 {
    static int n, m, k; static int [][] S2D2; static ArrayList<Integer>[][] age;
    static int [][] map;
    static int [] arx = {-1,-1,-1,0,0,1,1,1};
    static int [] ary = {-1,0,1,-1,1,-1,0,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // n * n 의 땅 크기
        m = Integer.parseInt(st.nextToken()); // m 개의 나무 ( 같은 크기의 칸에 여러 개의 나무가 심어져 있을 수 있다.)
        k = Integer.parseInt(st.nextToken()); // k년

        S2D2 = new int[n][n]; // 겨울에 양분을 추가하는 양을 기록
        age = new ArrayList[n][n]; // 나무의 나이 정보

        map  = new int[n][n]; // 땅의 양분 정보 (가장 처음에 양분은 모든 칸에 5만큼 들어있다.)
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], 5 );
        }

        for (int i = 0; i < n; i++) {  // 겨울에 양분을 추가하는 양을 저장
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n ; j++) {
                S2D2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                age[i][j] = new ArrayList<>();
            }
        }

        // 나무의 정보
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            age[x][y].add(Integer.parseInt(st.nextToken()));
        }
        /*
        System.out.println(Arrays.deepToString(map));
        System.out.println(Arrays.deepToString(S2D2));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(age[i][j].isEmpty()) continue;
                System.out.println(i + " " + j + " " +  age[i][j]);
            }
        }
        */

        int cnt = 1;
        while (cnt <= k){
            BFS();
            cnt++;
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer += age[i][j].size();
            }
        }
        System.out.println(answer);
    }
    public static void BFS(){
        int [][] copy = new int[n][n]; // 여름에 추가할 양분들

        // spring
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(age[i][j].isEmpty()) continue;
                Collections.sort(age[i][j]);
                int size = age[i][j].size();
                int cnt = 0;
                for (int l = 0; l < size; l++) {
                    int tree = age[i][j].get(cnt);
                    if(map[i][j] >= tree){
                        age[i][j].set(l, tree + 1);
                        map[i][j] -= tree;
                        cnt++;
                    }
                    else{
                        age[i][j].remove(cnt);
                        copy[i][j] += tree / 2;
                    }
                }
            }
        }
        // summer 여름에는 봄에 죽은 나무가 양분으로 추가
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] += copy[i][j];
            }
        }

        // fall 나무가 번식한다 나이가 5의 배수이면 인접한 8개의 칸에 나이가 1인 나무가
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(age[i][j].isEmpty()) continue;
                int size = age[i][j].size();
                for (int l = 0; l < size; l++) {
                    int tree = age[i][j].get(l);
                    if(tree % 5 == 0){
                        for (int o = 0; o < 8; o++) {
                            int nx = i + arx[o];
                            int ny = j + ary[o];
                            if(0 <= nx && 0 <= ny && nx < n && ny < n){
                                age[nx][ny].add(1);
                            }
                        }
                    }
                }
            }
        }

        // winter 겨울 S2D2가 양분을 추가한다.
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                map[i][j] += S2D2[i][j];
            }
        }

    }
}
/* 나무는 4계절을 보낸다.

처음 양분은 모든 칸에 5만큼 들어있다.

봄
나무가 자기의 나이만큼 양분을 먹고 나이가 1증가 각각의 나무는 나무가 있는 크기의 칸에 있는 양분만 먹는게 가능하다.
하나의 칸에 여러 개의 나무가 있다면 나이가 어린 나무부터 양분을 먹는다.
만약 땅에 양분이 부족해 자신의 나이만큼 양분을 먹을 수 없는 나무는 양분을 먹지 못하고 즉시 죽는다.

여름
봄에 죽은 나무가 양분으로 변하게 된다. 각각의 죽은 나무마다  나이를 2로 나눈 값이 나무에 있던 칸에 양분으로 추가된다.

가을
나무가 번식한다. 번식하는 나무는 나이가 5의 배수이며 인전합 8개의 칸에 나이가 1인 나무가 생긴다.

겨울
땅에 양분을 추가한다. 각 칸에 추가되는 양분의 양은 A[r][c]이고 입력으로 주어진다.

k년이 지난 후 상도의 땅에 살아있는 나무의 개수를 구하는 프로그램을 작성하자.

 */