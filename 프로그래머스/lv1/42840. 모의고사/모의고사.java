import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public int[] solution(int[] answers) {
        int[] retArr = {};
        
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int ans1 = 0, ans2 =0, ans3 = 0;

        // 1, 2, 3 수포자의 점수를 구하는 과정
        for(int i = 0 ; i < answers.length ; i++){
            if (arr1[i % arr1.length] == answers[i]) ans1++;
            if (arr2[i % arr2.length] == answers[i]) ans2++;
            if (arr3[i % arr3.length] == answers[i]) ans3++;
        }

        // 최고 점수를 구하기 위함
        int max = Math.max(ans1, Math.max(ans2, ans3));

        ArrayList<Integer> list = new ArrayList<Integer>();
        if(max == ans1) list.add(1);
        if(max == ans2) list.add(2);
        if(max == ans3) list.add(3);

        retArr = new int[list.size()];

        for(int i = 0 ; i < list.size() ; i++){
            retArr[i] = list.get(i);
        }
        
        return retArr;
    }
}