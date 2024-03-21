import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, h, w;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] map;
    static int[][] input;
    static int cnt;

    public static void main(String args[]) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] dimensions = br.readLine().split(" ");
            h = Integer.parseInt(dimensions[0]); // 높이
            w = Integer.parseInt(dimensions[1]); // 가로
            n = Integer.parseInt(dimensions[2]); // 도형의 개수

            visited = new boolean[h][w];
            map = new int[h][w];

            input = new int[n][4];

            for (int i = 0; i < n; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < 4; j++) {
                    input[i][j] = Integer.parseInt(line[j]);
                }
            }

            for (int i = 0; i < n; i++) {
                int x = input[i][1];
                int y = input[i][0];
                int xx = input[i][3] - 1;
                int yy = input[i][2] - 1;
                for (int q = x; q <= xx; q++) {
                    for (int t = y; t <= yy; t++) {
                        map[q][t] = 1;
                    }
                }
            }
            
            StringBuilder sb = new StringBuilder();
            ArrayList<Integer> ansArr = new ArrayList<>();
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && map[i][j] == 0) {
                        cnt = 0;
                        dfs(i, j);
                        ansArr.add(cnt);
                    }
                }
            }
            Collections.sort(ansArr);
            for (int a : ansArr) {
                sb.append(a).append(" ");
            }
            System.out.println(ansArr.size());
            System.out.println(sb);

        } catch (Exception e) {
            System.out.print(e);
        }
    }

    private static void dfs(int i, int j) {
        if (visited[i][j]) {
            return;
        } else {
            visited[i][j] = true;
            cnt++;
            for (int a = 0; a < 4; a++) {
                int xx = i + dx[a];
                int yy = j + dy[a];
                if (isValid(xx, yy) && map[xx][yy] == 0 && !visited[xx][yy]) {
                    dfs(xx, yy);
                }
            }
        }
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < h && y < w;
    }
}