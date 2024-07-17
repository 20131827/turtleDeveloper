import java.io.*;
import java.util.*;
public class Main {
    static int [] dx = {0, 0 ,-1 , 1};
    static int [] dy = {1, -1 ,0 , 0};
    static char [][]map;
    static boolean [][] visited;
    static int w = 0;
    static int h = 0;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        map = new char[h][w];
        visited = new boolean[h][w];

        for(int i = 0 ; i < h ; i++){
            String text = br.readLine();
            for(int j = 0 ; j < w ; j++){
              map[i][j] = text.charAt(j);
            }
        }
        int [] temp = new int[2];
        int rv = 0;
        int rk = 0;
        for(int i = 0 ; i < h ; i++){
            for(int j = 0 ; j < w ; j++){
                if(!visited[i][j] && (map[i][j] == 'v' || map[i][j] == 'k')){
                     temp = stackDfs(i, j);
                     rv += temp[0];
                     rk += temp[1];
                }
            }
        }

        System.out.println(rk + " " + rv);
    }
    static int[] stackDfs(int y, int x){
        visited[y][x] = true;

        Stack <int []>stack = new Stack<>();
        stack.push(new int[]{y, x});

        // v = 늑대, k = 양
        int v = 0;
        int k = 0;

        while(!stack.isEmpty()){
            int [] cuArr = stack.pop();
            int my = cuArr[0];
            int mx = cuArr[1];
            if(map[my][mx] == 'v'){
                v++;
            }else if(map[my][mx] == 'k'){
                k++;
            }
            for(int i = 0 ; i < 4 ; i++) {
                int ny = my + dy[i];
                int nx = mx + dx[i];
                if(ny >= 0 && nx >= 0 && ny < h && nx < w && !visited[ny][nx] && map[ny][nx] != '#'){
                    visited[ny][nx] = true;
                    stack.push(new int[]{ny, nx});
            }
//                my += dy[i];
//                mx += dx[i];
//                if(my >= 0 && mx >= 0 && my < h && mx < w && !visited[my][mx] && map[my][mx] != '#'){
//                    visited[my][mx] = true;
//                    stack.push(new int[]{my, mx});
//                }
            }
        }
        if(v < k){
            v = 0;
        }else{
            k = 0;
        }
        return new int[] {v, k};
    }
}