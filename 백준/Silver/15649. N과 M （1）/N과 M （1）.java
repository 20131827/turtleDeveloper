import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        visited = new boolean[N+1];
        arr = new int[M];

        dfs(0);

    }

    public static void dfs(int depth){
        if(depth == M){
            for(int i = 0 ; i < M ; i++){
                System.out.print(arr[i]+ " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1 ; i < N+1; i ++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }

    }

}
