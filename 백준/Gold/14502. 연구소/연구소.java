import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int[][] map;
    static int[][] selected = new int [3][2];
    static ArrayList<int[]> emptyPoint = new ArrayList<>();
    static int result = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];


        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++){
                int val = Integer.parseInt(st.nextToken());
                if(val == 0){
                    emptyPoint.add(new int[]{i, j});
                }
                map[i][j] = val;
            }
        }

        dfs(0,0);

        System.out.println(result);

    }

    public static void dfs(int now, int depth){
        if(depth == 3){
            bfs();
            return;
        }

        for(int i = now ; i < emptyPoint.size() ; i++){
            selected[depth] = emptyPoint.get(i);
            dfs(i+1, depth+1);
        }

    }

    public static void bfs(){
        int[][]tempMap = new int[n][m];
        for(int i = 0; i < n; i++){
            tempMap[i] = map[i].clone();
        }
        int[] n1 = selected[0];
        int[] n2 = selected[1];
        int[] n3 = selected[2];
        tempMap[n1[0]][n1[1]] = 1;
        tempMap[n2[0]][n2[1]] = 1;
        tempMap[n3[0]][n3[1]] = 1;

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(tempMap[i][j] == 2){
                    q.add(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];

            for(int i = 0 ; i < 4 ; i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;

                if(tempMap[ny][nx] == 0){
                    tempMap[ny][nx] = 2;
                    q.add(new int[]{ny, nx});
                }
            }
        }

        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(tempMap[i][j] == 0){
                    sum++;
                }
            }
        }

        result = Math.max(result, sum);

    }
}
