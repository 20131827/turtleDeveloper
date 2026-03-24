import java.io.*;
import java.util.*;
public class Main {
    static int[]dy ={-1,1,0,0};
    static int[]dx ={0,0,-1,1};
    static int[][] map;
    static ArrayList<int[]> vPoint = new ArrayList<>();
    static int[][] arr;
    static int n,m;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        arr = new int[m][2];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                int val = Integer.parseInt(st.nextToken());
                if(val == 2){
                    vPoint.add(new int[]{i,j});
                }
                map[i][j] = val;
            }
        }

//        dfs(0,map);
        dfs(0,0);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

//    public static void dfs(int depth, int[][]curMap){
    public static void dfs(int now, int depth){

        if(depth == m){
//            System.out.println(Arrays.deepToString(arr));
            bfs();
            return;
        }

//        // map을 copy하자
//        int[][]copyMap = new int[n][n];
//        for(int i = 0 ; i < n ; i++){
//            copyMap[i] = curMap[i].clone();
//        }

        // 바이러스 위치 조합하자
        for(int i = now; i < vPoint.size() ; i++){
            // 조합을 어떻게 m개 만큼 저장하도록 하지..? 일단 배열에 넣어야하는데..
//            arr[depth] = vPoint.get(i);
            // 조합을 저장할 필요가 없는것같다, copyMap에 바이러스를 심어주면 될것같음..!
            // 아니다.. arr 2차원 배열에 넣긴해야겠다..
            arr[depth] = vPoint.get(i);
//            int[] point = vPoint.get(i);
//            System.out.println(i + " : "+Arrays.toString(point));
//            copyMap[point[0]][point[1]] = 2;
//            System.out.println(i + " : "+Arrays.deepToString(copyMap));
            dfs(i+1,depth+1);
        }

    }

    public static void bfs(){

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        int emptyCnt = 0;

        // 빈칸 개수 세기
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(map[i][j] == 0) emptyCnt++;
            }
        }

        for(int[] cur : arr){
            q.offer(new int[]{cur[0],cur[1],0});
            visited[cur[0]][cur[1]] = true;
        }

        int maxTime = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            int time = cur[2];

            for(int d = 0 ; d < 4 ; d++){
                int ny = y + dy[d];
                int nx = x + dx[d];

                if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                if(visited[ny][nx]) continue;
                if(map[ny][nx] == 1) continue;

                visited[ny][nx] = true;

                if(map[ny][nx] == 0){
                    emptyCnt--;
                    maxTime = time + 1;
                }

                q.offer(new int[]{ny,nx,time+1});
            }
        }

        if(emptyCnt == 0){
            result = Math.min(result, maxTime);
        }
    }

//    public static void bfs(){
//
//        Queue<int[]> q = new LinkedList<>();
//        for(int[] cur : arr){
////            System.out.println(Arrays.toString(cur));
//            q.offer(new int[]{cur[0],cur[1]});
//        }
//
//        // map 복사
//        int[][]copyMap = new int[n][n];
//        for(int i = 0 ; i < n ; i++){
//            copyMap[i] = map[i].clone();
//        }
//
//        while(!q.isEmpty()){
//            int[] cur = q.poll();
//            int y = cur[0];
//            int x = cur[1];
//
//            for(int i = 0 ; i < 4 ; i++){
//                int ny = y + dy[i];
//                int nx = x + dx[i];
//
//                if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
//
//                if(copyMap[ny][nx] == 0){
//                    copyMap[ny][nx] = copyMap[y][x] + 1;
//                    q.offer(new int[]{ny,nx});
//                }
//            }
//        }
//
////        System.out.println(Arrays.deepToString(copyMap));
//        int time = -1;
//        for(int i = 0 ; i < n ; i++){
//            for(int j = 0 ; j < n ; j++){
//                time = Math.max(time, copyMap[i][j]);
//                if(copyMap[i][j] == 0){
//                    time = Integer.MAX_VALUE;
//                }
//            }
//        }
//
//        if(time != Integer.MAX_VALUE){
//            result = Math.min(result, time);
//        }
//    }
}
