import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int [] coinArr = new int[n];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            coinArr[i] = Integer.parseInt(st.nextToken());
        }

        int INF = 1000000000;
        int[] dp = new int[k + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        // 아래 코드로 문제 접근을 해버리면 dp가 틀어진다
        //        2 3
        //        2
        //        4
        // 위 반례를 입력하게되면 dp[3] = dp[3] = dp[1] + 1 = 1; 이딴게 나오는데 불가능한 상태다 이건..!

//        for(int i = 0 ; i < n ; i++){
//            int coin = coinArr[i];
//            for(int j = 1 ; j <= k ; j++){
//                if(j - coin < 0){
//                    continue;
//                }
//                else if(dp[j] != 0){
//                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
//                }else{
//                    dp[j] = dp[j - coin] + 1;
//                }
//
//            }
//        }

        for(int i = 0 ; i < n ; i++){
            int coin = coinArr[i];
            for(int j = coin ; j <= k ; j++){ // j = coin 으로 정의해야 불가능한 값을 계산하지 않는다..
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }

        if(dp[k] == INF){
            System.out.println("-1");
        }else{
            System.out.println(dp[k]);
        }
    }
}