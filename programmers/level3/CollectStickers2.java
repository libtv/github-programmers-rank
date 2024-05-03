package programmers.level3;

// 코딩테스트 연습 Summer/Winter Coding(~2018) 스티커 모으기(2)
public class CollectStickers2 {
    public int solution(int sticker[]) {
        int size = sticker.length;
        int max = 0;

        int result = 0;

        for(int i = 0; i < size; i++){
            result = Math.max(result, sticker[i]);
        }

        if(size <= 3) return result;

        // 첫 번째 원소를 사용하는
        int [][] DP1  = new int [size+1][2];  // 0은 이번 원소를 사용 1은 이번 원소 사용 x
        // 첫 번째 원소를 사용하지 않는
        int [][] DP2  = new int [size+1][2];

        DP1[1][0] = sticker[0];
        DP2[2][0] = sticker[1];

        for(int i = 3; i <= size; i++){
            if(i != size){
                DP2[i][0] = Math.max(DP2[i-1][1], Math.max(DP2[i-2][0], DP2[i-2][1])) + sticker[i-1];
                DP2[i][1] = Math.max(DP2[i-1][1], Math.max(DP2[i-1][0], Math.max(DP2[i-2][0], DP2[i-2][1])));
                max = Math.max(DP2[i][0], Math.max(max, DP2[i][1]));

                DP1[i][0] = Math.max(DP1[i-1][1], Math.max(DP1[i-2][0], DP1[i-2][1])) + sticker[i-1];
                DP1[i][1] = Math.max(DP1[i-1][1], Math.max(DP1[i-1][0], Math.max(DP1[i-2][0], DP1[i-2][1])));
                max = Math.max(DP1[i][0], Math.max(max, DP1[i][1]));
            }
            else{
                DP2[i][0] = Math.max(DP2[i-1][1], Math.max(DP2[i-2][0], DP2[i-2][1])) + sticker[i-1];
                DP2[i][1] = Math.max(DP2[i-1][1], Math.max(DP2[i-1][0], Math.max(DP2[i-2][0], DP2[i-2][1])));
                max = Math.max(DP2[i][0], Math.max(max, DP2[i][1]));
            }
        }

        return max;
    }
}
