import java.io.*;
import java.util.*;
public class Main {
    static int [][] map;
    static boolean [][] visited;
    static int [] dx = {0, 0, -1, 1, 1, 1, -1, -1};
    static int [] dy = {1, -1, 0, 0, 1, -1, 1, -1};
    static int y, x;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        map = new int [y][x];
        visited = new boolean [y][x];

        for(int i = 0 ; i < y ; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int result = 0;
        for(int i = 0 ; i < y ; i++){
            for(int j = 0 ; j < x ; j++){
                if(!visited[i][j] && map[i][j] == 1) {
                    dfs(i, j);
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    static void dfs(int i, int j){
        visited[i][j] = true;

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i, j});

        while(!stack.isEmpty()){
            int [] current = stack.pop();
            int yy = current[0];
            int xx= current[1];

            for (int a = 0; a < 8; a++) {
                int my = yy + dy[a];
                int mx = xx + dx[a];

                if( my >= 0 && mx >= 0 && my < y && mx < x && map[my][mx] == 1 && !visited[my][mx]){
                    visited[my][mx] = true;
                    stack.push(new int[]{my, mx});
                }
            }
        }

    }
}