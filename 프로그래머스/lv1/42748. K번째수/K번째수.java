import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
//         int[] answer = new int[commands.length];
        
//         for (int i = 0; i < commands.length; i++) {
//             int[] temp = array;
//             temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]); // i번째 부터 j번째 수 까지 배열을 자름
//             Arrays.sort(temp); // 오름차순 정렬
//             answer[i] = temp[commands[i][2] - 1];
//         }
        
//         return answer;
        int n = 0;
        int[] ret = new int[commands.length];

        while(n < commands.length){
            int m = commands[n][1] - commands[n][0] + 1;

            if(m == 1){
                ret[n] = array[commands[n++][0]-1];
                continue;
            }

            int[] a = new int[m];
            int j = 0;
            for(int i = commands[n][0]-1; i < commands[n][1]; i++)
                a[j++] = array[i];

            sort(a, 0, m-1);

            ret[n] = a[commands[n++][2]-1];
        }

        return ret;
    }

    void sort(int[] a, int left, int right){
        int pl = left;
        int pr = right;
        int x = a[(pl+pr)/2];

        do{
            while(a[pl] < x) pl++;
            while(a[pr] > x) pr--;
            if(pl <= pr){
                int temp = a[pl];
                a[pl] = a[pr];
                a[pr] = temp;
                pl++;
                pr--;
            }
        }while(pl <= pr);

        if(left < pr) sort(a, left, pr);
        if(right > pl) sort(a, pl, right);
    }
}