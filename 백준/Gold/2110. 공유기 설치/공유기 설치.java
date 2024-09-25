import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int [] arr = new int[n];

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        search(arr, c);
    }

    public static void search(int[] arr, int c){
        // 최대거리 = 좌표상의 거리가 가장 먼 집끼리의 거리
        // int max = arr[arr.length-1] - arr[0];
        int max = arr[arr.length - 1];
        int min = 1;
        int result = 1;

        // 1 2 4 8 9
        while(min <= max){
            int mid = (max + min) / 2;
            int cnt = cul(arr, mid, c);

            if(cnt >= c){
                result = mid;
                min = mid + 1;
            }else{
                max = mid - 1;
            }
        }
        System.out.println(result);
    }
    public static int cul(int[] arr, int mid, int c){
        int cnt = 1;
        int temp = arr[0]; // 최초 설치 위치
        for(int i = 1 ; i < arr.length ; i++){
            if(arr[i] - temp >= mid){
                cnt++;
                temp = arr[i];
            }
        }
        return cnt;
    }
}