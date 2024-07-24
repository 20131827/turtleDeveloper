import java.io.*;
import java.util.*;
public class Main {
    static int [][] map;
    static boolean [] visited;
    static int [] result;
    static int n;
    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.valueOf(st.nextToken()); // 전체 사람의 수
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken()); // 촌수를 구할 대상자 a
            int b = Integer.valueOf(st.nextToken()); // 촌수를 구할 대상자 b
            st = new StringTokenizer(br.readLine());
            int m = Integer.valueOf(st.nextToken()); // 입력받을 부모자식 관계 개수

            map = new int [n+1][n+1];
            visited = new boolean [n+1];
            result = new int [n+1];
//            for(int i = 0 ; i < m ; i++){
//                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//            }

            for(int i = 0 ; i < m ; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.valueOf(st.nextToken()); // 자식
                int y = Integer.valueOf(st.nextToken()); // 부모
                map[x][y] = 1;
                map[y][x] = 1;
            }

            int out = bfs(a, b);

            System.out.println(out);

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    static int bfs (int x, int y) {
        Queue <Integer> q = new LinkedList<>();
        q.offer(x);
        visited[x] = true;
        result[x] = 0;

        while(!q.isEmpty()){
            int now = q.poll();
            if(now == y){
                return result[now];
            }

            for(int i = 0 ; i < map.length ; i++){
                if(map[now][i] == 1 && !visited[i]){
                    visited[i] = true;
                    q.offer(i);
                    result[i] = result[now] + 1;
                }
            }
        }
        return -1;
    }
}