import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[]dp = new int[n+1];

        st = new StringTokenizer(br.readLine());
        int[]arr = new int[n+1];
        for(int i = 1 ; i < n+1 ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i]는 항상 "i를 반드시 포함하는 상태"로 정의하라
        dp[1] = 1; // dp[i] = i번째 까지의 숫자중 가장 긴 증가 부분 수열 -> 잘못된 점화식
                   // dp[i] = i에서 끝나는 가장 긴 증가 부분 수열 길이

//        [10, 20, 3, 2, 1, 4]
        for(int i=2 ; i < n + 1 ; i++){
             dp[i] = 1 ; // 자기 자신 포함
             for(int j = 1; j < i ; j++){
                 if(arr[j] < arr[i]){
                     dp[i] = Math.max(dp[i], dp[j] + 1);
                 }
             }
        }
            //[10, 20, 3, 2, 1, 4]
        int max = 1;
        for(int i = 1 ; i < n+1 ; i++){
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}