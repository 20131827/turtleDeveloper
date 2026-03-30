import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 물건의 수
        int k = Integer.parseInt(st.nextToken()); // 최대 무게

        ArrayList<int[]> arr = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken()); // 물건의 무게
            int v = Integer.parseInt(st.nextToken()); // 물건의 가치
            arr.add(new int[]{w,v});
        }

        int [] dp = new int[k+1]; // 무게가 7이라면 n[7]까지 되어야 함으로 +1 해줌
        //dp[i] = 무게 i일때 최대 가치

        for(int i = 0 ; i < n ; i++){
            int cw = arr.get(i)[0];
            int cv = arr.get(i)[1];
            for(int j = k ; j >= cw ; j--){ // 최대무게 보다 현재 확인중인 물건의 무게가 무거우면 종료되어야 하기 때문에 j >= cw 조건 사용
                dp[j] = Math.max(dp[j], dp[j-cw] + cv);
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 1; i < k+1 ; i++){
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

    }
}