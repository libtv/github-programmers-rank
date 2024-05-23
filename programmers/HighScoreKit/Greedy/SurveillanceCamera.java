package programmers.HighScoreKit.Greedy;

/**
 * 단속 카메라
 * greedy + sort
 * level3
 */
import java.util.*;
public class SurveillanceCamera {
    static ArrayList<int[]> list;
    public int solution(int[][] routes) {

        list = new ArrayList<>();

        int size = routes.length;
        for(int i = 0; i < size; i++){
            list.add(new int [] {routes[i][0], routes[i][1]});
        }

        /* 문제의 핵심
        정렬 기준을 진출 지점으로 먼저 해야한다.
        */
        Collections.sort(list, (o1,o2) ->{
            if(o1[1] != o2[1]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        TreeSet<Integer> camera = new TreeSet<>();
        for(int i = 0; i < size; i++){

            int [] temp = list.get(i);

            Integer output = camera.floor(temp[1]);
            if(output == null || output < temp[0]){
                camera.add(temp[1]);
            }
        }
        return camera.size();
    }
}
