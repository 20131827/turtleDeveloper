import java.io.*;
import java.util.*;
public class Main {
    static boolean map [][];
    static boolean visited [][];
    static int dx [] = {0, 0, -1 ,1};
    static int dy [] = {-1, 1, 0 ,0};
    static int N;
    static int M;


    public static void main(String[] args){
        try{
            BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken()); // 가로
            M = Integer.parseInt(st.nextToken()); // 세로

            map     = new boolean[M][N];
            visited = new boolean[M][N];

            for(int i = 0 ; i < M ; i++){
                String temp = br.readLine();
                for(int j = 0 ; j < N ; j++){
                    if(temp.charAt(j) == 'W'){ // B(적군) = false / W(내병사) = true
                        map[i][j] = true;
                    }
                }
            }

            int my  = 0;
            int you = 0;

            for(int i = 0 ; i < M ; i++){
                for(int j = 0 ; j < N ; j++){
                    int temp = 0;
                    if(!visited[i][j]){
                        temp = bfs(i, j, map[i][j]);
                    }
                    if(map[i][j]){
                        my  = my + (temp * temp);
                    }else{
                        you = you + temp * temp;
                    }
                }
            }

            System.out.println(my + " " + you);

        }catch(Exception e){
            e.printStackTrace();
        }

    }
    static int bfs(int i, int j, boolean flag){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        int result = 1;
        visited[i][j] = true;

        while(!q.isEmpty()){
            int current [] = q.poll();
            int cy = current[0];
            int cx = current[1];

            if(flag) {
                for (int a = 0; a < 4; a++) {
                    int my = cy + dy[a];
                    int mx = cx + dx[a];
                    if (my >= 0 && mx >= 0 && my < M && mx < N && !visited[my][mx] && map[my][mx]) {
                        q.offer(new int[]{my, mx});
                        visited[my][mx] = true;
                        result++;
                    }
                }
            }else{
                for(int a = 0 ; a < 4 ; a++){
                    int my = cy + dy[a];
                    int mx = cx + dx[a];
                    if(my >= 0 && mx >= 0 && my < M && mx < N && !visited[my][mx] && !map[my][mx]){
                        q.offer(new int[]{my, mx});
                        visited[my][mx] = true;
                        result++;
                    }
                }
            }
        }
        return result;
    }
}