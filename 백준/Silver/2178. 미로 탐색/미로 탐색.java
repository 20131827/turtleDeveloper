import java.io.*;
import java.util.*;

public class Main {

    static boolean [][] visited;
    static int [] dx = {0, 0, -1, 1};
    static int [] dy = {-1, 1, 0, 0};
    static int [][] map;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로

        visited = new boolean[n][m];
        map = new int [n][m];

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        bfs();

        System.out.println(map[n-1][m-1]);

    }

    public static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];

            for(int i = 0 ; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;

                if(!visited[ny][nx] && map[ny][nx] == 1){
                    visited[ny][nx] = true;
                    map[ny][nx] = map[y][x] + 1;
                    q.offer(new int[]{ny, nx});
                }
            }
        }
    }

}