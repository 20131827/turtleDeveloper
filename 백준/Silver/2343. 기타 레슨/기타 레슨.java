import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 강의 수
        int m = Integer.parseInt(st.nextToken()); // 블루레이 수

        int [] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 모든 강의시간이 담긴 배열

        search(arr, m);
    }

    public static void search(int[] arr, int m){
        int max = Arrays.stream(arr).sum();
        int min = Arrays.stream(arr).max().getAsInt();
//        int min = max / m; //  땡~~
        /*
            1 2 3 4 5 6 7 8 9가 있을때
            M이 1이면 전체의 합이 최소
            M이 9이면 9가 최소
            블루레이의 최소는 9 ~ 45 사이 값
        .*/
        int result = 0;

        while(min <= max){
            int mid = (max + min) / 2;
            int cnt = cul(arr, mid);
            //  계산한 개수가 제공된 개수보다 같다? -> 좀더 줄여볼까..? (최소값을 구해야하니까)
            //  계산한 개수가 제공된 개수보다 작다? -> 더 줄여서 개수부터 맞추자
            if(cnt <= m){
                result = mid;
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }

        System.out.println(result);
    }

    public static int cul(int[] arr, int mid){
        int cnt = 1; // 블루레이는 최소 1개

        int temp = mid;
        for(int a : arr){
            if(temp < a){
                cnt++;
                temp = mid;
            }
            temp -= a;
        }
        return cnt;
    }
}