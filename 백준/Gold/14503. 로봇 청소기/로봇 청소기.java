import java.io.*;
import java.util.*;

public class Main {
    // 방향 배열: 북, 동, 남, 서
    static int[] dr = {-1, 0, 1, 0}; // 행 이동 (북 -> 동 -> 남 -> 서)
    static int[] dc = {0, 1, 0, -1}; // 열 이동 (북 -> 동 -> 남 -> 서)
    static int[][] map;
    static boolean[][] cleaned;
    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        map = new int[N][M];
        cleaned = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int cleanedCount = cleanRoom(r, c, d);
        System.out.println(cleanedCount);

        sc.close();
    }

    public static int cleanRoom(int r, int c, int d) {
        int cleanedCount = 0;
        boolean running = true;

        while (running) {
            // 1. 현재 칸 청소
            if (!cleaned[r][c]) {
                cleaned[r][c] = true;
                cleanedCount++;
            }

            boolean found = false;
            // 2. 현재 칸 주변 4칸 확인
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4; // 반시계 방향으로 90도 회전
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !cleaned[nr][nc] && map[nr][nc] == 0) {
                    // 3. 청소되지 않은 빈 칸이 있는 경우 한 칸 전진
                    r = nr;
                    c = nc;
                    found = true;
                    break;
                }
            }

            if (!found) {
                // 4. 청소되지 않은 빈 칸이 없는 경우
                int backDirection = (d + 2) % 4; // 뒤쪽 방향
                int backR = r + dr[backDirection];
                int backC = c + dc[backDirection];

                if (backR >= 0 && backR < N && backC >= 0 && backC < M && map[backR][backC] == 0) {
                    // 4-1. 한 칸 후진
                    r = backR;
                    c = backC;
                } else {
                    // 4-2. 뒤쪽이 벽이라 후진할 수 없으면 작동 멈춤
                    running = false;
                }
            }
        }

        return cleanedCount;
    }
}
