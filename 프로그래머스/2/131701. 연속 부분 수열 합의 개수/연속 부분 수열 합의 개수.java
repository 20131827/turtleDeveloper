import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        int answer = 0;        
        
        // 순환하는 배열처럼 보이기 위해 2배로 배열 만들어주기
        int[] arr = new int[n * 2];
        for(int i = 0; i < n * 2; i++){
            arr[i] = elements[i % n];
        }        
        
        Set<Integer> set = new HashSet<>();
        
        for(int len = 1; len <= n; len++){
            int left = 0;
            int right = 0;    
            int sum = 0;
            // 초기 윈도우
            while(right < len){
                sum += arr[right];
                right++;
            }
            
            set.add(sum);
            
            // 오른쪽 포인트 < 배열길이 + 만들길이 
            // 2자리 만드려면, while(오른쪽포인트 < 7) 이라서, 오른쪽 포인트가 6까지만 됨!
            // 오른쪽 포인트가 7이 되는 순간, 이미 들럿던 위치라 중복임~ 그래서 위 조건으로 반복함
            while(right < n + len){
                sum += arr[right];
                sum -= arr[left];
                set.add(sum);
                
                right++;
                left++;
            }
        }
        
        answer = set.size();
        return answer;
    }
}