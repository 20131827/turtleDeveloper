import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        dfs(1, 0);
    }

    public static void dfs(int now, int depth){
        if(depth == m){
            for(int i = 0 ; i < m ; i++){
                System.out.print(arr[i]+ " ");
            }
            System.out.println();
            return;
        }

        for(int i = now; i < n + 1 ; i++){
            arr[depth] = i;
            dfs(i, depth+1);
        }
    }
}