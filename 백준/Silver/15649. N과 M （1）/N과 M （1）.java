import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static int[] map;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        map = new int[m];

        dfs(0);

    }

    public static void dfs(int depth) {
        if(depth == m){
            for(int data : map){
                System.out.print(data + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 1 ; i < n+1; i++){
            if(!visited[i]){
                visited[i] = true;
                map[depth] = i;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }

}

