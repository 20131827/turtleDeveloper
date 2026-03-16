import java.io.*;
import java.util.*;

public class Main {
    static int [] dy = {-1, 1, 0, 0};
    static int [] dx = {0, 0, -1, 1};
    static int [][] map;
    static int n,m;
    static int[][][] dist;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // y
        m = Integer.parseInt(st.nextToken()); // x

        map = new int[n][m];
        dist = new int[n][m][2]; // 벽을 뿌신 dist와 뿌시지 않은 dist 2가지를 동시에 진행해야함

        for(int i = 0 ; i < n ; i++){
            String temp = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        bfs();

        if(dist[n-1][m-1][0] == 0 && dist[n-1][m-1][1] == 0) System.out.println("-1");
            else if(dist[n-1][m-1][0] == 0) System.out.println(dist[n-1][m-1][1]);
            else if(dist[n-1][m-1][1] == 0) System.out.println(dist[n-1][m-1][0]);
            else System.out.println(Math.min(dist[n-1][m-1][0], dist[n-1][m-1][1]));

    }

    public static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0}); // y, x, 벽뿌시기 상태 3가지를 보내야함..
        dist[0][0][0] = 1;

        while(!q.isEmpty()){
            int [] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            int s = cur[2]; // 지금까지 벽뿌셨냐, 안뿌셨냐 상태값 저장

            for(int i = 0 ; i < 4 ; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;

                if(map[ny][nx]==0 && dist[ny][nx][s]==0){ // 이동가능하며, ny, nx에 방문하지 않았다면
                    dist[ny][nx][s] = dist[y][x][s] + 1;
                    q.offer(new int[]{ny,nx,s});
                }else if(map[ny][nx] == 1 && s == 0){ // 벽으로 막혀있고, 지금까지 벽을 뿌시지 않았다면
                    dist[ny][nx][1] = dist[y][x][s] + 1; 
                    q.offer(new int[]{ny, nx, 1});
                }
            }
        }

    }

}