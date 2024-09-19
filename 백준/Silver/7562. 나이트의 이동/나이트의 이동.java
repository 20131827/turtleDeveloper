import java.io.*;
import java.util.*;
public class Main {
    static int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int dy[] = {1, 2, 2, 1, -1, -2, -2, -1};
    static int map[][];
    static boolean visited[][];
    static int start[];
    static int end[];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            start = new int[]{startY, startX};

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            end = new int[]{endY, endX};

            map = new int[l][l];
            visited = new boolean [l][l];

            if(start[0] == end[0] && start[1] == end[1]){
                System.out.println("0");
            }else{
                System.out.println(bfs(start, end));
            }
        }
    }

    static int bfs(int[] start, int[] end){
        visited[start[0]][start[1]] = true; // 최초 출발지 방문 처리

        Queue<int []> q = new LinkedList<>();
        q.offer(new int[]{start[0],start[1],0});

        while(!q.isEmpty()){
            int [] current = q.poll();
            int y = current[0];
            int x = current[1];
            int depth = current[2];

            if(y == end[0] && x == end[1]){
                return depth;
            }else{
                for(int i = 0 ; i < 8 ; i++){
                    int mx = x + dx[i];
                    int my = y + dy[i];
                    if(mx >= 0 && my >= 0 && mx < map[0].length && my < map[0].length && !visited[my][mx]){
                        visited[my][mx] = true;
                        q.offer(new int[]{my, mx, depth+1});
                    }
                }
            }
        }
        return -1;
    }
}