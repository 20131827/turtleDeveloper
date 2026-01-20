import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int [] top = new int [size + 1];
            int [] bottom = new int [size + 1];
            int [][] dp = new int [size + 1][3];

            st = new StringTokenizer(br.readLine());
            for(int a = 1 ; a < size + 1 ; a++){
                top[a] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int a = 1 ; a < size + 1 ; a++){
                bottom[a] = Integer.parseInt(st.nextToken());
            }

            if(size == 1){
                System.out.println(Math.max(top[1], bottom[1]));
//                return; 여기서 리턴해버리면 다음 테스트케이스 진행을 못함.. continue를 사용하자..
                continue;
            }

            dp[1][0] = 0;
            dp[1][1] = top[1];
            dp[1][2] = bottom[1];

            for(int a = 2 ; a < size + 1 ; a++){
                dp[a][0] = Math.max(Math.max(dp[a-1][0], dp[a-1][1]), dp[a-1][2]);
                dp[a][1] = Math.max(dp[a-1][0] + top[a], dp[a-1][2] + top[a]);
                dp[a][2] = Math.max(dp[a-1][0] + bottom[a], dp[a-1][1] + bottom[a]);
            }

            System.out.println(Math.max(Math.max(dp[size][0], dp[size][1]), dp[size][2]));
        }
    }
}