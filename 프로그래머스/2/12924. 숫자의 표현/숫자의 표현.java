import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = i+1;
        }
        // System.out.println(Arrays.toString(arr));
        int sum = 0;
        int left = 0;
        int right = 0;
        while(true){
            // System.out.println(sum);
            if(sum >= n){ // sum이 k 이상이다 -> left-- 헤야함
                if(sum == n){
                    answer++;
                }
                sum -= arr[left];                
                left++; // 바보처럼 sum-한다고 좌표까지 --하면 안된다잉~
            }else{ // sum이 k보다 작다 -> right++ 해야함
                if(right == n) break; // 인덱스 접근전에 무조건 check하는 습관을 들이자
                sum += arr[right];
                right++;                
            }
        }
        return answer;
    }
}