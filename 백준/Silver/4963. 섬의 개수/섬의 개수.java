import java.io.*;
import java.util.*;
public class Main {
    static boolean [][] visited;
    static int [] dx = {0, 0, -1, 1, 1, 1, -1, -1};
    static int [] dy = {-1, 1, 0, 0, 1, -1, 1, -1};
    static int w;
    static int h;
    static int arr[][];

    static int result;
    public static void main(String args[]) {
        try{

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


            while(true){
                int []wh = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

                w = wh[0];
                h = wh[1];

                if(w + h == 0){ // 0 0 입력 시 종료
                    break;
                }

                arr = new int[h][w];             // 입력받을 배열 초기화
                visited = new boolean[h][w];     // 방문배열 초기화
                result = 0;                      // 결과값 초기화

                for(int i = 0 ; i < h ; i++){
                    arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                }

                for(int i = 0 ; i < h ; i++){
                    for(int j = 0 ; j < w ; j++){
                        if(arr[i][j] == 1 && !visited[i][j]){
                            dfs(i, j);
                            result++;
                        }
                    }
                }
                System.out.println(result);

            }

        }catch(IOException e){
            e.printStackTrace();
        }

    }

    static void dfs(int a, int b){
        if(!visited[a][b]){
            visited[a][b] = true;
            for(int i = 0 ; i < 8 ; i++){
                int mx = a + dx[i];
                int my = b + dy[i];
                if(mx >= 0 && mx < h && my >= 0 && my < w){
                    if(arr[mx][my] == 1){
                        dfs(mx, my);
                    }
                }
            }
        }else{
            return;
        }
    }

}