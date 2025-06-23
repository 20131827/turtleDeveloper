import java.io.*;
import java.util.*;

public class Main {
    static int [][]map;
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            map = new int [n][20];

            for(int i = 0 ; i < n ; i++){
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                for(int j = 0 ; j < 20 ; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0 ; i < n ; i++){
                int result = 0;
                for(int j = 0 ; j < 20 ; j++){
                    result += swap(map, i, j);
                }
                System.out.println(i+1 + " " + result);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static int swap (int[][]arr, int a, int b){
        int []a1 = arr[a];
        int cNum = arr[a][b]; // 현재 숫자

        int result = 0;
        while (b !=0){
            if(cNum > a1[b-1]) break;
            b--;
            map[a][b+1] = map[a][b];
            map[a][b] = cNum;
            result++;
        }

        return result;
    }
}