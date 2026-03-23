import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] map;
    static int answer = Integer.MAX_VALUE;

    static class CCTV {
        int y, x, type;
        CCTV(int y, int x, int type) {
            this.y = y;
            this.x = x;
            this.type = type;
        }
    }

    static ArrayList<CCTV> list = new ArrayList<>();

    // 상, 우, 하, 좌
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    // CCTV별 방향 정의
    static int[][][] dir = {
            {},
            {{0},{1},{2},{3}},                 // 1번
            {{0,2},{1,3}},                     // 2번
            {{0,1},{1,2},{2,3},{3,0}},         // 3번
            {{0,1,2},{1,2,3},{2,3,0},{3,0,1}}, // 4번
            {{0,1,2,3}}                        // 5번
    };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] >= 1 && map[i][j] <= 5){
                    list.add(new CCTV(i, j, map[i][j]));
                }
            }
        }

        dfs(0, map);
        System.out.println(answer);
    }

    // CCTV 방향 선택
    public static void dfs(int depth, int[][] curMap){

        if(depth == list.size()){
            answer = Math.min(answer, getBlindSpot(curMap));
            return;
        }

        CCTV c = list.get(depth);

        for(int[] dSet : dir[c.type]){
            int[][] copyMap = copy(curMap);

            for(int d : dSet){
                watch(copyMap, c.y, c.x, d);
            }

            dfs(depth + 1, copyMap);
        }
    }

    // 감시 처리
    public static void watch(int[][] map, int y, int x, int d){
        int ny = y;
        int nx = x;

        while(true){
            ny += dy[d];
            nx += dx[d];

            if(ny < 0 || nx < 0 || ny >= n || nx >= m) break;
            if(map[ny][nx] == 6) break;

            if(map[ny][nx] == 0){
                map[ny][nx] = -1;
            }
        }
    }

    // 사각지대 계산
    public static int getBlindSpot(int[][] map){
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] == 0) count++;
            }
        }
        return count;
    }

    // map 복사
    public static int[][] copy(int[][] map){
        int[][] newMap = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            newMap[i] = map[i].clone();
        }
        return newMap;
    }
}