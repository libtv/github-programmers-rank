package programmers.level0;

// https://school.programmers.co.kr/learn/courses/30/lessons/181927
// 마지막 두 원소
public class LastTwoElements {
    public static void main(String[] args) {

    }

    public int[] solution(int[] num_list) {

        if(num_list[num_list.length-1] > num_list[num_list.length-2]){

            int [] new_list = new int [num_list.length+1];
            for(int i = 0; i < num_list.length; i++){
                new_list[i] = num_list[i];
            }
            new_list[num_list.length] = num_list[num_list.length-1] - num_list[num_list.length-2];
            return new_list;
        }
        else {
            int [] new_list = new int [num_list.length+1];
            for(int i = 0; i < num_list.length; i++){
                new_list[i] = num_list[i];
            }
            new_list[num_list.length] = num_list[num_list.length-1]*2;
            return new_list;
        }
    }

}
