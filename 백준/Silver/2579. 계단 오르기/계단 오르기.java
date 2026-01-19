import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] sc = new int [n+1];

        for(int i = 1 ; i < n+1 ; i++){
            st = new StringTokenizer(br.readLine());
            sc[i] = Integer.parseInt(st.nextToken());
        }

        // 계단이 1~2개만 있다면 dp 로직사용했을때 런타임 오류 발생함
        if (n == 1) {
            System.out.println(sc[1]);
            return;
        }
        if (n == 2) {
            System.out.println(sc[1] + sc[2]);
            return;
        }

        int[][]dp = new int [n+1][3];
        dp[1][1] = sc[1];
        dp[2][1] = sc[2];
        dp[2][2] = sc[1] + sc[2];

        for(int i = 3 ; i < n+1 ; i++){
//            dp[i][1] = Math.max((dp[i-2][1] + sc[i]), (dp[i-1][1] + sc[i]));
//            2칸 전의 상태가 2연속인지 아닌지는 중요하지 않음 어차피 2칸 전에서 현재 상태로 온다면 초기화되기 때문..
//            그래서 위의 코드는 틀렸음!
            dp[i][1] = Math.max(dp[i-2][1], dp[i-2][2]) + sc[i];
            dp[i][2] = dp[i-1][1] + sc[i];
        }

        System.out.println(Math.max(dp[n][1], dp[n][2]));

    }
}