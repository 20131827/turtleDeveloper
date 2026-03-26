import java.io.*;
import java.util.*;
public class Main {
//    static boolean[][] visited;
    static int[][] visited;
    static int[][] map;
    static int[] dy = {0,1,0,-1};
    static int[] dx = {1,0,-1,0};
    static int n;
    static int result = 0;
    static int sharkSize = 2;
    static int bite_cnt = 0;
    static class fish implements Comparable<fish> {
    int y, x, dist;

    fish(int y, int x, int dist) { // 물고기의 y축, 물고기의 x축, 상어에서 물고기까지의 거리
        this.y = y;
        this.x = x;
        this.dist = dist;
    }
        @Override
        public int compareTo(fish f) {
            if (this.dist == f.dist) {
                if (this.y == f.y) {
                    return Integer.compare(this.x, f.x);
                } else {
                    return Integer.compare(this.y, f.y);
                }
            } else {
                return Integer.compare(this.dist, f.dist);
            }
        }
    }
//    static ArrayList<fish> f = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        visited = new int[n][n];

        int sy = 0;
        int sx = 0;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j= 0 ; j < n ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    sy = i;
                    sx = j;
                    map[i][j] = 0; // 상어위치를 제거해야함
                }
            }
        }

        bfs(sy,sx);
    }

    public static void bfs(int sy, int sx){
        visited[sy][sx] = 0;
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{sy, sx});
        PriorityQueue<fish> fq = new PriorityQueue<>();
        int minDist = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];

            // 처음 먹을 수 있는 물고기 거리보다 멀리있는 물고기는 탐색 할 필요가 없음!
            if(visited[y][x] > minDist) break;

            // 먹을 수 있는 물고기
            if(map[y][x] != 0 && map[y][x] < sharkSize){
                fq.offer(new fish(y,x,visited[y][x]));
                minDist = visited[y][x];
            }

            for(int i = 0 ; i < 4 ; i++){
                int ny = y+dy[i];
                int nx = x+dx[i];

                if(ny<0 || nx<0 || ny>= n || nx>=n) continue;
                if(visited[ny][nx] != 0 || (ny == sy && nx == sx)) continue;

                if(map[ny][nx] <= sharkSize){
                    // 아래 상어위치에 -1값을 넣는건 위험함 애초에 map에 입력받을때 상어 위치에 0으로 치환해둿음!!
                    visited[ny][nx] = visited[y][x] + 1;
                    q.offer(new int[]{ny, nx});
//                    if(map[y][x]!=9){ // 상어위치를 -1로 둿기 때문에 거리가 꼬이는걸 방지하기 위함
//                        visited[ny][nx] = visited[y][x] + 1;
//                    }else{
//                        visited[ny][nx] = 1;
//                    }
//                    q.offer(new int[]{ny, nx});
                }
            }
        }
//        System.out.println(Arrays.deepToString(visited));
//        for(fish v : f){
//            System.out.print("y : " + v.y + " ");
//            System.out.print("x : " + v.x + " ");
//            System.out.println("dist : " + v.dist);
//        }
        if(!fq.isEmpty()){
            fish bite_f = fq.poll();
            result += bite_f.dist;
            map[bite_f.y][bite_f.x] = 0; // 잡아먹은 물고기 위치로 상어 이동 (상어를 꼭 9로 나타낼 필요가 없음..! 그러면 계산이 어려워짐! (어차피 bfs(sy,sx) 넣으니까 상어 위치 식별가능!
            bite_cnt++;                  // 잡아먹은 물고기 횟수 증가
            if(bite_cnt == sharkSize){   // 상어크기만큼 먹었다면 상어크기 1 증가 및 잡아먹은 횟수 초기화
                sharkSize++;
                bite_cnt = 0;
            }
            visited = new int[n][n];     // 상어 위치가 변경되었으니, 거리도 초기화
            bfs(bite_f.y, bite_f.x); // 다시 거리별 물고기 탐색부터 start
        }else{ // 더이상 먹을 물고기가 없다면 result 출력..!
            System.out.println(result);
        }

    }

}