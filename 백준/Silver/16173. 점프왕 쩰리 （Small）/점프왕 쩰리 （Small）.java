import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static boolean result = false;
    static int[][] arr;
    static int n;

    public static void main(String args[]) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());

            // 방문배열 n 크기만큼 초기화
            visited = new boolean[n][n];

            // 2차원 배열로 입력값 저장
            arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                arr[i] = temp;
            }

            dfs(0, 0);
            System.out.println(result ? "HaruHaru" : "Hing");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void dfs(int i, int j) {
        // 범위를 벗어난 경우나 이미 방문한 경우 종료
        if (i >= n || j >= n || visited[i][j]) {
            return;
        }

        // 승리 조건 확인
        if (arr[i][j] == -1) {
            result = true;
            return;
        }

        // 방문 표시
        visited[i][j] = true;

        // 현재 위치에서 이동할 칸 수
        int jump = arr[i][j];
        if (jump == 0) {
            return; // 더 이상 이동할 수 없으면 종료
        }

        // 오른쪽으로 이동
        if (j + jump < n) {
            dfs(i, j + jump);
        }

        // 아래로 이동
        if (i + jump < n) {
            dfs(i + jump, j);
        }
    }
}