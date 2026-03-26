import java.io.*;
import java.util.*;
public class Main {
    static boolean[][] visited;
    static int dist = 0;
    static int[] dy = {0,1,0,-1};
    static int[] dx = {1,0,-1,0};
    static int n,m;
    static int result = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];
        dfs(0,0);

    }
    public static void dfs(int y, int x){
        visited[y][x] = true;
        boolean flag = false;
        for(int i = 0 ; i < 4 ; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if(!visited[ny][nx]){
                flag = true;
            }
        }
        if(flag) {
            int ny = y + dy[dist];
            int nx = x + dx[dist];
            if (ny < 0 || nx < 0 || ny >= n || nx >= m || visited[ny][nx]) {
                if (dist == 3) {
                    dist = 0;
                } else {
                    dist++;
                }
                result++;
            }
            dfs(y + dy[dist], x + dx[dist]);
        }else{
            System.out.println(result);
        }

    }
}
