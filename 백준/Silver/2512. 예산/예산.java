import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 지방의 수 (의미는 없으나 명시적 선언)
        int [] arr = Arrays.stream(br.readLine().split(" " )).mapToInt(Integer::parseInt).toArray(); // 지방 예산 배열
        int m = Integer.parseInt(br.readLine()); // 총 예산 금액

        System.out.println(search(arr, m));
    }
    public static long search (int []arr, int m){
        int max = Arrays.stream(arr).max().getAsInt(); // 최대값
        int min = 1; // 예산값 범위가 1부터 시작함
        int result = 0;
        long amt = 0;

        while(min <= max){
            int mid = (max + min) / 2; // 중간값
            amt = cal(arr, mid);

            if(amt > m){
                max = mid - 1;
            }else{
                result = mid;
                min = mid + 1;
            }

        }
        return result;
    }

    public static long cal (int []arr, int m){
        long sum = 0 ;
        for(int a : arr){
            sum += Math.min(a, m); // min을 사용하면 아래와 같음
        }
        return sum;
    }
}