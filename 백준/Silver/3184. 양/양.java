import java.io.*;
import java.util.*;
public class Main {
    static int [] dx = {0, 0 ,-1 , 1};
    static int [] dy = {1, -1 ,0 , 0};
    static char [][]map;
    static boolean [][] visited;
    static int w = 0;
    static int h = 0;
    // 선언할떄 int w, h = 0; 이렇게 하면 h는 0으로 초기화 되고 w는 초기화 되지 않음*주의
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
        int ro = 0;
        for(int i = 0 ; i < h ; i++){
            for(int j = 0 ; j < w ; j++){
                // 문자 비교는 ==, != 을 사용하며 ' '으로 감싸야함..! 더블커텐션은 문자열임(" ")
                if(!visited[i][j] && (map[i][j] == 'v' || map[i][j] == 'o')){
                    temp = stackDfs(i, j);
                    rv += temp[0]; // 늑대
                    ro += temp[1]; // 양
                }
            }
        }

        System.out.println(ro + " " + rv);
    }
    static int[] stackDfs(int y, int x){
        visited[y][x] = true;

        Stack <int []>stack = new Stack<>();
        stack.push(new int[]{y, x});

        // o = 양, v = 늑대
        int o = 0;
        int v = 0;

        while(!stack.isEmpty()){
            int [] cuArr = stack.pop();
            int cy = cuArr[0];
            int cx = cuArr[1];
            if(map[cy][cx] == 'o'){
                o++;
            }else if(map[cy][cx] == 'v'){
                v++;
            }
            for(int i = 0 ; i < 4 ; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if(ny >= 0 && nx >= 0 && ny < h && nx < w && !visited[ny][nx] && map[ny][nx] != '#'){
                    visited[ny][nx] = true;
                    stack.push(new int[]{ny, nx});
                }
            }
        }

        // 'o'는 양, 'v'는 늑대
        if(v < o){
            v = 0;
        }else{
            o = 0;
        }
        return new int[] {v, o}; 
    }
}