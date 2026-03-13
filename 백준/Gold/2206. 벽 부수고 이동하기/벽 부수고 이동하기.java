import java.io.*;
import java.util.*;

public class Main {
    static class node{
        int y;
        int x;
        int w;

        node(int y, int x, int w){
            this.y = y;
            this.x = x;
            this.w = w;
        }
    }

    static int [] dy = {-1, 1, 0, 0};
    static int [] dx = {0, 0, -1, 1};
    static int n;
    static int m;
    static int[][] map;
    static int[][][] dist;
    static boolean[][][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // y
        m = Integer.parseInt(st.nextToken()); // x

        map = new int[n][m];
        dist = new int[n][m][2];
        visited = new boolean[n][m][2];


        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        bfs();

        if(dist[n-1][m-1][0] == 0 && dist[n-1][m-1][1] == 0 ){
            System.out.println(-1);
        }else if(dist[n-1][m-1][0] == 0){
            System.out.println(dist[n-1][m-1][1]);
        }else if(dist[n-1][m-1][1] == 0){
            System.out.println(dist[n-1][m-1][0]);
        }else{
            System.out.println(Math.min(dist[n-1][m-1][0],dist[n-1][m-1][1]));
        }

    }

    public static void bfs(){
        Queue<node> q = new LinkedList<>();
        q.offer(new node(0, 0, 0));
        visited[0][0][0] = true;
        visited[0][0][1] = true;
        dist[0][0][0] = 1;
        dist[0][0][1] = 1;

        while(!q.isEmpty()){
            node cur = q.poll();
            int y = cur.y;
            int x = cur.x;
            int w = cur.w;

            for(int i = 0 ; i < 4 ; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m || visited[ny][nx][w]) continue;
                if(map[ny][nx] == 0){
                    dist[ny][nx][w] = dist[y][x][w] + 1;
                    visited[ny][nx][w] = true;
                    q.offer(new node(ny, nx, w));
                }else if(map[ny][nx] == 1 && w == 0){
                    dist[ny][nx][1] = dist[y][x][w] + 1;
                    visited[ny][nx][w] = true;
                    q.offer(new node(ny, nx, 1));
                }
            }
        }
    }
}