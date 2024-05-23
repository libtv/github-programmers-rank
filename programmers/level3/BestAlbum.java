package programmers.level3;

// 코딩테스트 연습 해시 베스트앨범
import java.util.*;
import java.util.stream.*;
public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {

        HashMap<String, Long> entire = new HashMap<>();
        HashMap<String, ArrayList<int[]>> memo = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        int size = plays.length;
        for(int i = 0; i < size; i++){
            String name = genres[i];
            int play = plays[i];
            entire.put(name, entire.getOrDefault(name, 0L) + play);
            if(memo.containsKey(name)){
                memo.get(name).add(new int [] {i, play});
            }
            else{
                ArrayList<int []> temp = new ArrayList<>();
                temp.add(new int [] {i, play});
                memo.put(name, temp);
            }
        }

        List<Map.Entry<String, Long>> collect = entire.entrySet().stream().sorted((o1, o2) -> {
            return -(o1.getValue().compareTo(o2.getValue())); // 내림차순 정렬
        }).collect(Collectors.toList());


        for(int i = 0; i < entire.size(); i++){
            Map.Entry<String, Long> entry = collect.get(i);
            ArrayList<int[]> temp = memo.get(entry.getKey());
            Collections.sort(temp, (o1, o2) -> {
                return -(o1[1] - o2[1]);
            });
            for(int j = 0; j < temp.size(); j++){
                if(j == 2) break;
                int [] check = temp.get(j);
                list.add(check[0]);
            }
        }

        // 정답을 list -> array
        int[] answer = new int [list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
