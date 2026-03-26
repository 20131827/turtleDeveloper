import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[]arr = new int[n];
        Arrays.fill(arr,1);
        
        for(int val : lost){
            arr[val-1] -= 1;
        }
        for(int val : reserve){
            arr[val-1] += 1;
        }
        
        // System.out.println(Arrays.toString(arr));
        
        for(int i = 0 ; i < n ; i++){
            if(arr[i] == 0){
                if(i-1 >= 0 && arr[i-1] == 2){
                    arr[i-1]--;
                    arr[i]++;
                }else if(i+1 < n && arr[i+1] == 2){
                    arr[i+1]--;
                    arr[i]++;
                }
            }
        }
        // System.out.println(Arrays.toString(arr));
        for(int i = 0 ; i < n ; i++){
            if(1 <= arr[i]){
                answer++;
            }
        }
        
        return answer;
    }
}