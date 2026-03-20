import java.io.*;
import java.util.*;

public class Main {
    static int[] arr, map;
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k == 0) break;

            map = new int[k];
            arr = new int[6];
            for(int i = 0 ; i < k ; i++){
                map[i] =  Integer.parseInt(st.nextToken());
            }

            dfs(0,0);
            System.out.println();
        }

    }

    public static void dfs(int now, int depth){
        if(depth == 6){
            for(int i = 0 ; i < 6 ; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = now ; i < k ; i++){
            arr[depth] = map[i];
            dfs(i+1, depth+1);
        }
    }

}