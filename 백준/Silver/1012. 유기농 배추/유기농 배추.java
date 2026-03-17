import java.io.*;
import java.util.*;

public class Main {

    static int w, h;
    static boolean[][] visited;
    static int[][] map;
    static int result = 0;
    static int [] dy = {-1, 1, 0, 0};
    static int [] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int tc = 0 ; tc < t ; tc++){
            result = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken()); // x
            h = Integer.parseInt(st.nextToken()); // y
            int k = Integer.parseInt(st.nextToken()); // 배추의 위치

            visited = new boolean[h][w];
            map = new int[h][w];

            for(int i = 0 ; i < k ; i ++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[b][a] = 1;
            }

            for(int i = 0 ; i < h ; i++){
                for(int j = 0 ; j < w ; j++){
                    if(map[i][j] == 1 && !visited[i][j]){
                        dfs(i, j);
                        result++;
                    }
                }
            }

            System.out.println(result);

        }

    }

    public static void dfs(int y, int x){
        visited[y][x] = true;
        for(int i = 0 ; i < 4 ; i++){
            int ny = dy[i] + y;
            int nx = dx[i] + x;

            if(ny < 0 || nx < 0 || ny >= h || nx >= w) continue;

            if(!visited[ny][nx] && map[ny][nx] == 1) dfs(ny, nx);
        }
    }

}