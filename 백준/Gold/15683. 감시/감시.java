import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[][] map;
    static int result = Integer.MAX_VALUE;

    static class CCTV{
        int y,x,type;
        CCTV(int y, int x, int type){
            this.y = y;
            this.x = x;
            this.type = type;
        }
    }
    static ArrayList<CCTV> cList = new ArrayList<>();

    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int[][][] dir = {
            {},
            {{0},{1},{2},{3}},
            {{0,1},{2,3}},
            {{0,3},{3,1},{1,2},{0,2}},
            {{0,2,3},{0,1,3},{1,2,3},{0,1,2}},
            {{0,1,2,3}}
    };
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(1 <= map[i][j] && map[i][j] <= 5){
                    cList.add(new CCTV(i, j, map[i][j]));
                }
            }
        }

        dfs(0, map);
        System.out.println(result);

    }

    public static void dfs(int depth, int[][] curMap){
        if(depth == cList.size()){
//            for(int i = 0 ; i < n ; i++){
//                System.out.println(Arrays.toString(curMap[i]));
//            }
            calc(curMap);
            return;
        }

        CCTV c = cList.get(depth);

        for(int[]dset : dir[c.type]){
            int[][]copyMap = new int[n][m];

            for(int i = 0 ; i < n ; i++){
                copyMap[i] = curMap[i].clone();
//                System.out.println(Arrays.toString(copyMap[i]));
            }

            watch(c.y, c.x, dset, copyMap);

            dfs(depth+1, copyMap);
        }

    }

    public static void watch(int y, int x, int[] set, int[][]copyMap){

        for(int d : set){
            int ny = y;
            int nx = x;
            while(true){
                ny += dy[d];
                nx += dx[d];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) break;
                if(copyMap[ny][nx] == 6) break;

                if(copyMap[ny][nx] == 0){
                    copyMap[ny][nx] = -1;
                }
            }
        }
    }

    public static void calc(int[][] curMap){
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(curMap[i][j] == 0){
                    sum++;
                }
            }
        }
        result = Math.min(sum, result);
    }

}