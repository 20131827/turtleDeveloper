import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[]) throws IOException{
            BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken()); // 랜선 개수
            int n = Integer.parseInt(st.nextToken()); // 필요한 랜선 수
        
            int [] arr = new int [k];
            for(int i = 0 ; i < k ; i++){
                arr[i] = Integer.parseInt(br.readLine());
            }


            System.out.println(search(arr, n)); // n개를 만들 수 있는 랜선의 최대 길이
        }
        public static long search(int []arr, int n){

            long max = Arrays.stream(arr).max().getAsInt();
            long min = 1;
            long result = 0;


            while(min <= max){
                long mid = (max + min) / 2;
                long ea = cut(arr, mid);

                if(ea >= n){
                    result = mid;
                    min = mid + 1;
                }else{
                    max = mid -1;
                }
            }
            return result;
        }

        public static long cut(int[] arr, long cut){
            long sum = 0;

            for(int a : arr){
                    sum += a / cut;
            }

            return sum;
        }
    }