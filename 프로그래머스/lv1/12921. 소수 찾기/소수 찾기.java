class Solution {
    public int solution(int n) {
        int answer = 0;
        int [] arr = new int[n+1];
        
        // 입력받은 숫자 +1 사이즈의 배열에 숫자들을 집어넣는 과정
        for(int i = 2 ; i <= n ; i++){
            arr[i] = i;
        } 
        
        for(int i = 2; i < Math.sqrt(n) ; i++){
            if(arr[i] == 0) continue;
            // 소수가 아닌 숫자들은 0으로 치환해버린다
            for(int j = i * i; j < arr.length; j += i) {
                arr[j] = 0;
            }
        } 
        
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] != 0)
                answer++;
        }
        
        
        
        

        
        return answer;
    }
}