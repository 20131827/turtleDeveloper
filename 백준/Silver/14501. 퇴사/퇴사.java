import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<int[]> s = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            s.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        int[] dp = new int[n+1]; //dp[i] = i일 부터 일했을때 최대 금액

        // n일부터 시작해서 역으로 내려오자..!
        for(int i = n-1 ; i >= 0 ; i--){
            int time = s.get(i)[0];
            int pay = s.get(i)[1];

            // 일을 할 수 있는 경우
            if (i + time <= n) {
                dp[i] = Math.max(dp[i + 1], pay + dp[i + time]);
            } else {
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[0]);

    }
}