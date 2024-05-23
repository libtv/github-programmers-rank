package programmers.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// [PCCE 기출문제] 10번 / 데이터 분석
public class PCCE10 {
    public static void main(String[] args) {
        PCCE10 pcce10 = new PCCE10();
        int[][]data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        pcce10.solution(data, "date", 20300501, "remain");
    }
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

        int num;
        if(sort_by.equals("code")){
            num = 0;
        }
        else if(sort_by.equals("date")){
            num = 1;
        }
        else if(sort_by.equals("maximum")){
            num = 2;
        }
        else{
            num = 3;
        }
        // 무조건 오름차순

        List<Integer> check = new ArrayList<>();

        for (int i = 0; i < data.length; i++) {
            if (ext.equals("code")){
                if(data[i][0] < val_ext){
                    check.add(data[i][num]);
                }
            }
            else if(ext.equals("date")){
                if(data[i][1] < val_ext){
                    check.add(data[i][num]);
                }
            }
            else if(ext.equals("maximum")){
                if(data[i][2] < val_ext){
                    check.add(data[i][num]);
                }
            }
            else{
                if(data[i][3] < val_ext){
                    check.add(data[i][num]);
                }
            }
        }
        Collections.sort(check);
        int[][] answer = new int[check.size()][data[0].length];

        List<Integer> check2 = new ArrayList<>();

        // 인덱스값 찾기 해당
        for (int i = 0; i < check.size() ; i++) {
            for (int j = 0; j < data.length ; j++) {
                if(check.get(i) == data[j][num]){
                    check2.add(j);
                }
            }
        }
        // System.out.println(check2); 여기까지 확인  완료
        for (int i = 0; i < check.size() ; i++) { // 0, 1
            for (int j = 0; j < data[0].length ; j++) { // 0,1,2,3
                answer[i][j] = data[check2.get(i)][j]; //[2],[0]
            }
        }
        return answer;
    }
}
/*
AI 엔지니어인 현식이는 데이터를 분석하는 작업을 진행하고 있습니다.
데이터는 ["코드 번호(code)", "제조일(date)", "최대 수량(maximum)", "현재 수량(remain)"]으로 구성되어 있으며 현식이는 이 데이터들 중 조건을 만족하는 데이터만 뽑아서 정렬하려 합니다.
정렬한 데이터들이 담긴 이차원 정수 리스트 data와 어떤 정보를 기준으로 데이터를 뽑아낼지를 의미하는 문자열 ext
뽑아낼 정보의 기준값을 나타내는 정수 val_ext, 정보를 정렬할 기준이 되는 문자열 sort_by가 주어집니다.
data에서 ext 값이 val_ext보다 작은 데이터만 뽑은 후, sort_by에 해당하는 값을 기준으로 오름차순으로 정렬하여 return 하도록 solution 함수를 완성해 주세요. 단, 조건을 만족하는 데이터는 항상 한 개 이상 존재합니다.


 */