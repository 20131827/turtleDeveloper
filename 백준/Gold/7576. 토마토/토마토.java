import java.io.*;
import java.util.*;

public class Main {
    static int [] dy = {-1, 1, 0, 0};
    static int [] dx = {0, 0, -1, 1};
    static int n;
    static int m;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken()); // x
        n = Integer.parseInt(st.nextToken()); // y

        map = new int[n][m];

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    q.offer(new int[]{i, j});
                }
            }
        }

        bfs(q);
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] == 0){
                    System.out.println(-1);
                    return;
                }else{
                    result = Math.max(result, map[i][j]);
                }
            }
        }

        System.out.println(result-1);

    }

    public static void bfs(Queue<int[]> q){

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];

            for(int i = 0 ; i < 4 ; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if(map[ny][nx] == 0){
                    map[ny][nx] = map[y][x] + 1;
                    q.offer(new int[]{ny, nx});
                }
            }
        }

    }
}