import java.io.*;
import java.util.*;
public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int [] dx = {0, 0, -1, 1, 1, 1, -1, -1};
    static int [] dy = {1, -1, 0, 0, 1, -1, 1, -1};
    static int result;
    static int h,w;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        h = sc.nextInt(); // 세로길이
        w = sc.nextInt(); // 가로길이

        map = new int[h][w];
        visited = new boolean[h][w];
        result = 0;

        for(int i = 0 ; i < h ; i++){   // map 입력받기
            for(int j = 0 ; j < w ; j++){
                map[i][j] = sc.nextInt();
            }
        }

        for(int i = 0 ; i < h ; i++){  // dfs 실행
            for(int j = 0 ; j < w ; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    dfs(i, j);
                    result++;
                }
            }
        }

        System.out.println(result);
    }
    static void dfs(int i, int j){
        if(!visited[i][j]){
            visited[i][j] = true;
            for(int a = 0 ; a < 8 ; a++) {
                int y = i + dy[a];
                int x = j + dx[a];
                if (x >= 0 && y >= 0 && x < w && y < h && map[y][x] == 1) {
                    dfs(y, x);
                }
            }
        }else{
            return;
        }
    }
}