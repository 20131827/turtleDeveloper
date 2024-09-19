import java.io.*;
import java.util.*;
public class Main {
    static int dx[] = {0, 0, -1 ,1};
    static int dy[] = {1, -1, 0, 0};
    static int map[][];
    static boolean visited[][];

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int temp = Integer.parseInt(st.nextToken());

            int result = 0;

            map = new int [y][x];
            visited = new boolean [y][x];

            for(int j = 0 ; j < temp ; j++){
                st = new StringTokenizer(br.readLine());
                int xx = Integer.parseInt(st.nextToken());
                int yy= Integer.parseInt(st.nextToken());
                map[yy][xx] = 1;
            }

            for(int a = 0 ; a < x ; a ++){
                for(int b = 0 ; b < y ; b++){
                    if(!visited[b][a] && map[b][a] == 1){
                        result++;
                        dfs(b, a);
                    }
                }
            }

            System.out.println(result);
        }
    }

    static void dfs(int y, int x){
        visited[y][x] = true;

        for(int i = 0 ; i < 4 ; i++){
            int my = y + dy[i];
            int mx = x + dx[i];
            // map[0].length -> 가로
            if(my >= 0 &&  mx >= 0 && mx < map[0].length && my < map.length && !visited[my][mx] && map[my][mx] == 1){
                dfs(my, mx);
            }
        }
    }
}