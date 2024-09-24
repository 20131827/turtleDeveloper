import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(search(arr, m));
    }
    public static int search(int arr[], int m){
        int min = Arrays.stream(arr).max().getAsInt();
        int max = 10000 * 100000;
        int result = 0;

        while(min <= max){
            int mid = (max + min) / 2;
            int cnt = cul(arr, mid);

            // 5번 인출로 해결해야하는데, 3번만에 해결하면 ? -> 돈을 덜뽑아야지? -> max값을 mid로 내려야함
            // 5번 인출로 해결해야하는데  5번만에 해결하면 ? -> 돈아낀다고 최소값을 구해야한다함 -> 그럼 max값 mid로 내려서 더 떨어트려도 되는지 보고? 똑같다? -> 그럼 result값 갱신
            // 5번 인출이 아니라 4번 인출해버렷다? -> 그럼 돈을 좀더 뽑아야함 -> min값을 max로 올려보고~? -> 반복..
            if(cnt <= m){
                result = mid;
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }

        return result;
    }
    public static int cul(int arr[], int mid){
        int cnt = 1;
        int midTemp = mid;

        for(int a : arr){
            midTemp -= a;
            if(midTemp < 0){
                cnt++;
                midTemp = mid - a;
            }
        }
        return cnt;
    }
}