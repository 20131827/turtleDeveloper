import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//
//        for(int i = 0 ; i < T ; i++){
//            int temp = Integer.parseInt(sc.next());
//            int [] dp = new int[temp];
//            if(temp < 3){
//                System.out.println(1);
//                continue;
//            }
//            dp[0] = 1;
//            dp[1] = 1;
//            dp[2] = 1;
//            for(int j = 3 ; j < temp ; j++){
//                dp[j] = dp[j-3] + dp[j-2];
//            }
//            System.out.println(dp[temp-1]);

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        // dp를 여러번 만들 이유가 전혀 없다 한번만 만들어놓고 꺼내서 사용하자
        long [] dp = new long[101]; // 여기서 int형을 사용하면 틀린다.. N값이 작다고 한들, 해당문제에서는 j값이 21억을 훨씬 넘어감..
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= 100; i++) {
            dp[i] = dp[i-3] + dp[i-2];
        }

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            System.out.println(dp[N]);
        }

    }
}