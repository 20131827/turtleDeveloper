import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main
{
    static int n, h, w;
    static int [] dx = {0, 1, 0, -1};
    static int [] dy = {1, 0, -1, 0};
    static boolean [][] visited;
    static int [][] map;
    static int [][] input;
    static int cnt;

    public static void main(String args[])
    {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();

             h = Integer.parseInt(st.nextToken()); // 높이
             w = Integer.parseInt(st.nextToken()); // 가로
             n = Integer.parseInt(st.nextToken()); // 도형의 개수

            visited = new boolean[h][w];
            map = new int[h][w];

            input = new int[n][4];

            for(int i = 0 ; i < n ; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    input[i][j] = Integer.parseInt(st.nextToken());
//                    input[i][j] = (j == 3 || j == 4) ? Integer.parseInt(st.nextToken()) - 1 : Integer.parseInt(st.nextToken()) - 1;
                }
            }

            for(int i = 0 ; i < n ; i++){
                int x = input[i][1];
                int y = input[i][0];
                int xx= input[i][3] - 1;
                int yy= input[i][2] - 1;
                for(int q = x ; q <= xx ; q++){
                    for(int t = y ; t <= yy ; t++){
                        map[q][t] = 1;
                    }
                }
            }
            ArrayList<Integer> ans_arr = new ArrayList<>();
            for(int i = 0 ; i < h ; i++) {
                for (int j = 0; j < w; j++) {
                    if(!visited[i][j] && map[i][j] ==0){
                        cnt =0;
                        dfs(i, j);
                        ans_arr.add(cnt);
                    }
                }
            }
            Collections.sort(ans_arr);
            for(int a : ans_arr){
                sb.append(a + " ");
            }
            System.out.println(ans_arr.size());
            System.out.println(sb);

        } catch(Exception e) {
            System.out.print(e);
        }
    }

    private static void dfs(int i, int j) {
        if(visited[i][j]){
            return;
        }else{
            visited[i][j] = true;
            cnt++;
            for(int a = 0; a < 4 ;a++){
                int xx = i + dx[a];
                int yy = j + dy[a];
                if(xx >= 0 && yy >= 0 && xx < h && yy < w && map[xx][yy] == 0 && !visited[xx][yy]){
                    dfs(xx, yy);
                }
            }
        }
    }
}