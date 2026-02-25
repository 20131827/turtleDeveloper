import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int n;
    static int [][] arr;
    static boolean [][]visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int temp = 0;
        int result = 0;

        for(int rain = 0 ; rain < 100 ; rain++){
            visited = new boolean[n][n];
            temp = 0;
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(arr[i][j] > rain && !visited[i][j]){
                        temp++;
                        dfs(i ,j, rain, arr);
                    }
                }
            }
            result = Math.max(temp, result);
        }
        System.out.println(result);

    }
    public static void dfs(int y, int x, int rain, int[][] arr){
        visited[y][x] = true;
        for(int i = 0 ; i < 4 ; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny >= 0 && nx >= 0 && ny < n && nx < n && !visited[ny][nx] && arr[ny][nx] > rain) {
                dfs(ny, nx, rain, arr);
            }
        }
    }
}