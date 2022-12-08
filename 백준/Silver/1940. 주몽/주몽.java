import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int start = 0, end = 1, count = 0;

        if (N == 1) {
            System.out.println(1);
        } else {
            while (start != arr.length-1) {
                if (arr[start] + arr[end] == M) {
                    count++;
                    if(end != arr.length-1)end++;
                    else{
                        start++;
                        if(start != arr.length-1) end = start + 1;
                    }
                } else if (end != arr.length-1) {
                    end++;
                }
                else {
                    start++;
                    if(start != arr.length-1) end = start + 1;
                }
            }
            System.out.println(count);
        }
    }
}