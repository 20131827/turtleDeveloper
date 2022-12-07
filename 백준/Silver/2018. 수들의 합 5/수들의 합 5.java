import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = 1;
        int sum = 1;

        int start =1;
        int end = 1;
        
        boolean flag = true;

        if(N == 1){
            System.out.println(1);
        }else {
            while (flag) {
                if (sum == N) {
                    count++;
                    end++;
                    sum+=end;
                } else if (sum > N) {
                    sum -= start;
                    start++;
                } else {
                    if (end == N) return;
                    else{
                        end++;
                        sum += end;
                    }
                }
                if (start + end != 0 && start == end) flag = false;
            }
            System.out.println(count);
        }
    }
}