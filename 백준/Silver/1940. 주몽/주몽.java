import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int arr [] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int count = 0;
        int i = 0;
        int j = arr.length-1;

        while (i < j){
            if(arr[i] + arr[j] < m){
                i++;
            }else if(arr[i] + arr[j] > m){
                j--;
            }else{
                count++;
                i++;
                j--;
            }
        }

        System.out.println(count);

    }
}