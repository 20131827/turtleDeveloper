import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length/2;
        
        HashSet<Integer> a = new HashSet<>(nums.length);
        
        for(int i=0; i<nums.length; i++) {
			a.add(nums[i]);
		}
        
        if(n < a.size()){
            answer = n;
        }else{
            answer = a.size();
        }
        
        return answer;
        
        
    }
}