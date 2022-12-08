import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);

        int cnt = 0;

        for(int K = 0 ; K < N ; K++){
            int start = 0;
            int end = N-1;
            while (start < end){
                if(arr[start] + arr[end] == arr[K]){
                    if(start == K || end == K){
                        if(start == K) start++;
                        else if (end == K) end--;
                    }else{
                        cnt++;
                        break;
                    }
                } else if(arr[start] + arr[end] > arr[K]){
                    end--;
                } else{
                    start++;
                }
            }
        }
        System.out.println(cnt);
    }
}