import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[]dp = new int[n+1];
//        dp[i] = i를 1로 만드는 최소 연산 횟수

        dp[1] = 0; //1을 1로 만드는 최소 연산횟수 = 0
        for(int i = 2 ; i < n+1 ; i++){

            dp[i] = dp[i-1] + 1;

            if(i % 2 == 0){
                dp[i] = Math.min(dp[i], dp[i/2] +1 );
            }

            if(i % 3 == 0){
                dp[i] = Math.min(dp[i], dp[i/3] +1 );
            }
        }
        System.out.println(dp[n]);
    }
}