import java.io.*;
import java.util.*;
public class Main {
    static int [] dx = {0, 0, -1, 1};
    static int [] dy = {-1, 1, 0, 0};
    static int [][] map;
    static boolean [][] visited;
    static int h = 0;
    static int w = 0;
    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        map = new int[h][w];
        visited = new boolean[h][w];

        for(int i = 0 ; i < h ; i++){
            String input = br.readLine();
            for(int j = 0 ; j < w ; j++) {
                int temp = input.charAt(j) == '1' ? 1 : 0;
                map[i][j] = temp;
            }
        }

        bfs(0, 0);
        System.out.println(map[h-1][w-1]);
    }

    static void bfs(int a, int b){
        Queue<int []> q = new LinkedList<>();
        q.offer(new int[]{a,b});
        visited[0][0] = true;

        while(!q.isEmpty()){
            int[] currentMap = q.poll();
            int y = currentMap[0];
            int x = currentMap[1];

            for(int i = 0 ; i < 4 ; i++){
                int my = y + dy[i];
                int mx = x + dx[i];
                if (my >= 0 && mx >= 0 && my < h && mx < w && !visited[my][mx] && map[my][mx] == 1) {
                    visited[my][mx] = true;
                    map[my][mx] = map[y][x] +1;
                    q.offer(new int[]{my, mx});
                }
            }

        }
    }
}