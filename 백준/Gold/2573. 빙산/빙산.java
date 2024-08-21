import java.io.*;
import java.util.*;
public class Main {
    static int [] dx = {0, 0, -1, 1};
    static int [] dy = {1, -1, 0, 0};
    static boolean [][] visited;
    static int [][] map;
    static int [][] copyMap;
    static int n;
    static int m;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로

        map = copyMap = new int[n][m];
        visited = new boolean [n][m];

        for(int i = 0 ; i < n ; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Queue q = new LinkedList<int[]>();

        for(int i = 0 ; i < n-1 ; i++){
            for(int j = 0 ; j < m-1 ; j++){
                if(map[i][j] != 0){
                    q.offer(new int[]{i, j});
                }
            }
        }

        int result = bfs(q);
        System.out.println(result);
    }
    static int bfs (Queue<int []> q){

        int step = 0;
        while(!q.isEmpty()){
            copyMap = new int[n][m];

            int size = q.size();// 현재 단계의 큐 크기

            for (int a = 0; a < size; a++) {
                int[] current = q.poll();
                int cy = current[0];
                int cx = current[1];
                int minus = 0;

                for (int i = 0; i < 4; i++) {
                    int my = cy + dy[i];
                    int mx = cx + dx[i];
                    if (my >= 0 && mx >= 0 && my < n && mx < m && map[my][mx] == 0) {
                        minus++;
                    }
                }
                copyMap[cy][cx] = Math.max(map[cy][cx] - minus, 0);
                if (copyMap[cy][cx] > 0) {
                    q.offer(new int[]{cy, cx});
                }
//                copyMap[cy][cx] -= minus;
//                if (copyMap[cy][cx] <= 0) {
//                    copyMap[cy][cx] = 0;
//                } else {
//                    q.offer(new int[]{cy, cx});
//                }
                
            }step ++;
            map = copyMap;
            int ea = 0;
            visited = new boolean[n][m];
            for(int i = 0 ; i < n-1 ; i++){
                for(int j = 0 ; j < m-1 ; j++){
                    if(map[i][j] != 0 && !visited[i][j]){
                        if(dfs(i, j)){
                            ea++;
                        }
                    }
                }
            }

            if(ea >= 2){
                return step;
            }
        }
        return 0; // 빙산이 두덩어리 이상이되지않고 모두 녹은경우
    }
    static boolean dfs(int y, int x){
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int my = y + dy[i];
            int mx = x + dx[i];
            if (my >= 0 && mx >= 0 && my < n && mx < m && map[my][mx] != 0 && !visited[my][mx]) {
                dfs(my, mx);
            }
        }
        return true;
    }
}