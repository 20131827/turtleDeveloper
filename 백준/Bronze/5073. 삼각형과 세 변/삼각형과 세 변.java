import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            boolean flag = true;

            while(flag){
                st = new StringTokenizer(br.readLine());
                int [] arr = new int [3];
                arr [0] = Integer.parseInt(st.nextToken());
                arr [1] = Integer.parseInt(st.nextToken());
                arr [2] = Integer.parseInt(st.nextToken()); // 가장 긴 변
                Arrays.sort(arr);

                if(arr[0] + arr[1] + arr[2] == 0){
                    flag = false;
                }
                else if(arr[2] >= arr[0] + arr[1]){ // 가장긴 길이 보다 나머지 두 변의 합이 길지 않을때
                    System.out.println("Invalid");
                }else if(arr[0] == arr[1] && arr[1] == arr[2]){ // 세 변의 길이가 모두 같은 경우
                    System.out.println("Equilateral");
                }else if(arr[0] != arr[1] && arr[1] != arr[2]){ // 세 변의 길이가 모두 다른 경우
                    System.out.println("Scalene");
                }else if(arr[0] == arr[1] || arr[1] == arr[2] || arr[0] == arr[2]) { //두 변의 길이만 같은 경우
                    System.out.println("Isosceles ");
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}