import java.io.*;
import java.util.*;
public class Main {
    static int [][][] map;
    static boolean [][][] visited;
    static int[][] move = { // h, x, y
        {1, 0, 0}, {-1, 0, 0}
        , {0, 0, 1}, {0, 0, -1}
        , {0, 1, 0}, {0, -1, 0}
    };
    static Queue<int[]> qq = new LinkedList<>();
    static int M, N, H;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        H = Integer.parseInt(st.nextToken()); // 높이

        map = new int [H][N][M];
        visited = new boolean [H][N][M];

        for(int i = 0 ; i < H ; i++){
            for(int j = 0 ; j < N ; j++) {
                st = new StringTokenizer(br.readLine());
                for (int z = 0; z < M; z++) {
                    int temp = Integer.parseInt(st.nextToken());
                    map[i][j][z] = temp;
                    if(temp == -1){
                        visited[i][j][z] = true;
                    }else if(temp == 1){
//                        qq.add(new ArrayList<>(Arrays.asList(i, j, z))); //왜이렇게 했을까.. 후...
                        qq.add(new int [] {i, j, z});
                        visited[i][j][z] = true; // 최초 방문처리를 꼭 bfs안에서 안해도된다..
                    }
                }
            }
        }

        int result = bfs(qq);
        System.out.println(result);

    }
    static int bfs(Queue<int[]> q){
        int depth = -1; //초기 깊이 설정

        while (!q.isEmpty()) {
            int size = q.size(); // 현재 단계의 큐 크기
            depth++;
            for (int i = 0; i < size; i++) {
                int[] c = q.poll();
                int ch = c[0], cn = c[1], cm = c[2];

                for (int j = 0; j < 6; j++) {
                    int mh = ch + move[j][0];
                    int mn = cn + move[j][1];
                    int mm = cm + move[j][2];
                    if (mh >= 0 && mh < H && mn >= 0 && mn < N && mm >= 0 && mm < M) {
                        if (!visited[mh][mn][mm] && map[mh][mn][mm] == 0) {
                            visited[mh][mn][mm] = true;
                            map[mh][mn][mm] = 1;
                            q.offer(new int[]{mh, mn, mm});
                        }
                    }
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int z = 0; z < M; z++) {
                    if (map[i][j][z] == 0) {
                        return -1; // 익지 않은 토마토가 남아있는 경우
                    }
                }
            }
        }
        return depth;
    }
}