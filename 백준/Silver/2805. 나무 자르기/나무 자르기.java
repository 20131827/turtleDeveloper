import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        st.nextToken(); // 나무의 수는 필요 없어서 그냥 한번 버림
        int m = Integer.parseInt(st.nextToken());

        int [] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        System.out.println(search(arr, m));
    }

    public static int search(int [] arr, int m){
        int max = arr[arr.length -1]; // 최대값
        int min = 0; // 최소값
        int result = 0;

        while(min <= max){
          int mid = (max + min) / 2;
            long  tree = minus(arr, mid);

          if(tree >= m){
               result = mid;
                min = mid + 1;
          }else {
                max = mid - 1;
          }
        }
        return result;
    }
    public static long minus(int [] arr, int i){
        long  sum = 0;
        for(int a : arr){
            if(a > i){
                sum += a - i;
            }
        }
        return sum;
    }
}