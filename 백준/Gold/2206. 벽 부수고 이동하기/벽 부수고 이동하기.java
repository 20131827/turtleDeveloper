import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int y, x, w;

        Node(int y, int x, int w) {
            this.y = y;
            this.x = x;
            this.w = w;
        }
    }

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int n, m;
    static int[][] map;
    static int[][][] dist;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dist = new int[n][m][2];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs();

        int a = dist[n-1][m-1][0];
        int b = dist[n-1][m-1][1];

        if(a == 0 && b == 0) System.out.println(-1);
        else if(a == 0) System.out.println(b);
        else if(b == 0) System.out.println(a);
        else System.out.println(Math.min(a, b));
    }

    static void bfs() {

        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(0,0,0));
        dist[0][0][0] = 1;

        while(!q.isEmpty()){

            Node cur = q.poll();

            int y = cur.y;
            int x = cur.x;
            int w = cur.w;

            for(int i=0;i<4;i++){

                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny<0 || nx<0 || ny>=n || nx>=m) continue;

                // 1️⃣ 빈칸 이동
                if(map[ny][nx] == 0 && dist[ny][nx][w] == 0){

                    dist[ny][nx][w] = dist[y][x][w] + 1;
                    q.offer(new Node(ny,nx,w));

                }

                // 2️⃣ 벽 부수기
                if(map[ny][nx] == 1 && w == 0 && dist[ny][nx][1] == 0){

                    dist[ny][nx][1] = dist[y][x][0] + 1;
                    q.offer(new Node(ny,nx,1));

                }
            }
        }
    }
}