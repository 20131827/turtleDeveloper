import java.io.*;
import java.util.*;

public class Main {

    static int K,W,H;
    static int [][][] dist;
    static int [][] map;
    static int [] dy = {-1, 1, 0, 0};
    static int [] dx = {0, 0, -1, 1};
    static int [] hdy = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int [] hdx = {-2, -1, 1, 2, -2, -1, 1, 2};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken()); // x
        H = Integer.parseInt(st.nextToken()); // y

        map = new int[H][W];
        dist = new int[H][W][K+1];

        for(int i = 0 ; i < H ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < W ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());

    }

    public static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,0});
        dist[0][0][0] = 1;


        while(!q.isEmpty()){
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            int cnt = cur[2];

            if(y == H-1 && x == W-1) return dist[y][x][cnt] - 1;

            for(int i = 0 ; i < 4 ; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny >= H || nx >=W) continue;

                if(map[ny][nx] == 0 &&dist[ny][nx][cnt] == 0){
                    dist[ny][nx][cnt] = dist[y][x][cnt] + 1;
                    q.offer(new int[]{ny, nx, cnt});
                }
            }

            if(cnt < K){
                for(int i = 0 ; i < 8 ; i++) {
                    int ny = y + hdy[i];
                    int nx = x + hdx[i];
                    if(ny < 0 || nx < 0 || ny >= H || nx >=W) continue;

                    if(map[ny][nx] == 0 && dist[ny][nx][cnt+1] == 0){
                        dist[ny][nx][cnt+1] = dist[y][x][cnt]+1;
                        q.offer(new int[]{ny, nx, cnt+1});
                    }
                }
            }
            // 여기서 이제 일반 상하좌우 움직임과, 말의 움직임이 K번 보다 적게 실행되었다면, 말의 움직임 까지 범위 유효성 을 검사하여
            // 통과했다면, 상화좌우 q에 offer하고, 말의 움직임도 q에 offer하고, 할때 q에 3번째 인자에 +1 해준다(그래야 말의 움직임을 카운팅 할수있음)
            // cnt가 K번보다 크거나 같을때는 말의 움직임은 q에 offer하지 않는다.


        }

        return -1;
    }
}