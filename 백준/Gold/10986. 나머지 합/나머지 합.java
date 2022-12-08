import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long result = 0;
        st = new StringTokenizer(br.readLine(), " ");

        // 나머지가 같은 인덱스를 카운팅 하기 위함
        long[] cnt = new long[M];
        long [] arr = new long[N+1];

        for(int i = 1 ; i <= N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long [] S = new long[N + 1];

        for(int i = 1 ; i <= N ; i++){
            S[i] = (S[i-1] + arr[i]) % M;
            if(S[i] % M == 0) result++;
            cnt[(int) S[i]]++;
        }

        long temp = 0L;

        for(int i = 0 ; i < cnt.length ; i++){
            if(cnt[i] != 0){
                temp += (cnt[i] * (cnt[i]-1)) / 2;
            }
        }
        System.out.println(result + temp);
    }
}