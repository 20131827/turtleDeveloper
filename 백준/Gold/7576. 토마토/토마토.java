import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int cnt = 0; // 익은토마토 개수
    static int totalCnt = 0; // 총 토마토 개수
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int xSize = Integer.parseInt(st.nextToken());
        int ySize = Integer.parseInt(st.nextToken());

        int [][] arr = new int[ySize][xSize];
        boolean [][] visited = new boolean[ySize][xSize];
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0 ; i < ySize ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < xSize ; j++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1){
                    cnt++;
                    totalCnt++;
                    arr[i][j] = temp;
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }else if(temp == 0){
                    totalCnt++;
                    arr[i][j] = temp;
                }else{
                    arr[i][j] = temp;
                    visited[i][j] = true;
                }
            }
        }

        if(cnt == totalCnt){
            System.out.println(0);
        }else{
            while (!q.isEmpty()){
                int [] temp = q.poll();
                int cy = temp[0];
                int cx = temp[1];

                for(int i = 0 ; i < 4 ; i++){
                    int ny = cy + dy[i];
                    int nx = cx + dx[i];
                    if(ny >= 0 && ny < ySize && nx >= 0 && nx < xSize && !visited[ny][nx] && arr[ny][nx] == 0){
                        visited[ny][nx] = true;
                        q.offer(new int[]{ny, nx});
                        arr[ny][nx] = arr[cy][cx] + 1;
                        cnt++;
                    }
                }

                if(cnt == totalCnt){
                    System.out.println(arr[cy][cx]);
                    break;
                }
            }
        }
        if(cnt != totalCnt){
            System.out.println(-1);
        }
    }
}