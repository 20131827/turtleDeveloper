import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[]dp = new int[n+1];
//        dp[i] = i번째 까지의 수를 연속해서 사용했을때 최대값

        st = new StringTokenizer(br.readLine());

        int[]arr = new int[n+1];
        for(int i = 1 ; i < n+1 ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = arr[1];
        int max = dp[1];
        for(int i = 2 ; i < n+1 ; i++){
//            dp[i] = Math.max(dp[i-1], dp[i-1] + arr[i]); -> 이건.. 연속된 숫자를 뽑는게 아니게됨..! i개를 뽑았을때 최대합이라서 안됨..!
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            max = Math.max(max, dp[i]);
        }
        
        System.out.println(max);

    }
}