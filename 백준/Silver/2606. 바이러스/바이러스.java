import java.io.*;
import java.util.*;
public class Main {
    static int[][] arr;
    static boolean[]visited;
    static int result = 0;
    static int n, a ;
    public static void main(String args[]) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            n = Integer.parseInt(br.readLine()); // 컴퓨터의 수 (정점)
            a = Integer.parseInt(br.readLine()); // 연결된 컴퓨터 쌍의 수 (간선)

            arr = new int[n+1][n+1];
            visited = new boolean[n+1];

            int x, y;

            for (int i = 0; i < a; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                arr[x][y] = arr[y][x] = 1;              // 양방향 그래프 구현
            }


            dfs(1);

            System.out.println(result - 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void dfs(int a) {
        visited[a] = true;
        result++;
        for(int i = 1; i <= n; i++) {
            if (arr[a][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }
}