import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int [] coin = new int[n];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            coin[i] = Integer.parseInt(st.nextToken());
        }

//        int [] dp = new int[k+1];
        long [] dp = new long[k+1]; // 무조건 int 보다 안정성을 위해 long을 사용하는게 좋음.. 특히 dp의 경우 조합 수가 많아질 우려가 항상 큼
                                    // 추가로 메모리 차이가 int나 long이나 차이가 사실상 없기 때문에 그냥 long을 습관화 하는게 좋음!
        dp[0] = 1; // dp[i] = i원을 만드는 경우의 수, 0원을 만드려면 동전을 하나도 쓰지않는 경우 1가지만 존재함

        // 동전의 개수만큼 1원~k원 까지 dp를 반복 update 진행
        for(int i = 0 ; i < n ; i++){
            int cost = coin[i];
            // 아래처럼 반복문 사용시 음수 인덱스 참조가능성 + cost 부터 시작해야할 값이 잘못 선정되어 불필요한 계산이 추가됨!!
//            for(int j = 1 ; j < k + 1 ; j++){
//                dp[j] += dp[j - cost];
//            }

            for(int j = cost ; j < k + 1 ; j++){
                dp[j] += dp[j - cost];
            }
        }

        System.out.println(dp[k]);

    }
}