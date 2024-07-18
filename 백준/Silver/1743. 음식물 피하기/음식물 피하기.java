import java.io.*;
import java.util.*;
public class Main {
    static int [] dx = {0, 0, -1, 1};
    static int [] dy = {-1, 1, 0, 0};
    static boolean [][] map;
    static boolean [][] visited;
    static int h;
    static int w;
    public static void main(String args[]) throws IOException{
        // 3(세로) 4(가로) 5(입력받을 쓰레기 좌표)
        // 입력받은 쓰레기중 가장 큰 쓰레기의 크기를 구하라(쓰레기는 상하좌우끼리 합쳐짐 대각선 x)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        int total = Integer.parseInt(st.nextToken());

        map = new boolean[h][w];
        visited = new boolean[h][w];

        // 각 좌표에 쓰레기 위치 입력
        for(int i = 0 ; i < total ; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1; // 좌표와 배열인덱스 싱크 맞추기 위함
            int x = Integer.parseInt(st.nextToken()) - 1; // 좌표와 배열인덱스 싱크 맞추기 위함
            map[y][x] = true;
        }

        int max = 0;
        int temp = 0;

        for(int i = 0 ; i < h ; i++){
            for(int j = 0 ; j < w ; j++){
                if(!visited[i][j] && map[i][j]){
                    temp = stackDfs(i, j);
                    if(temp > max){
                        max = temp;
                    }
                }
            }
        }
        System.out.println(max);
    }
    static int stackDfs(int y, int x){
        visited[y][x] = true;

        Stack <int[]> stack = new Stack<>();
        stack.push(new int[]{y, x});

        int size = 1;

        while(!stack.isEmpty()){
            int [] current = stack.pop();
            int cy = current[0];
            int cx = current[1];

            for(int i = 0 ; i < 4 ; i++){
                int my = cy + dy[i];
                int mx = cx + dx[i];
                if(my >= 0 && mx >= 0 && my < h && mx < w && !visited[my][mx] && map[my][mx]){
                    stack.push(new int[]{my, mx});
                    visited[my][mx] = true;
                    size++;
                }
            }
        }
        return size;
    }
}