import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
public class Main
{
    static int [] dx = {0, 1, 0, -1};
    static int [] dy = {1, 0, -1 ,0};
    static boolean visited[][];
    static ArrayList<Integer> [] arr;
    static int cnt = 0;
    static int n = 0;
    static int dfsCnt = 0;
    public static void main(String args[])
    {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken()); // 길이 n 정사각형
            visited = new boolean[n][n]; // 방문배열
            arr = new ArrayList[n]; // 그래프 데이터를 저장할 인접 리스트

            for(int i = 0; i < n ; i++){
                arr[i] = new ArrayList<>();
            }

            // 입력받은 데이터를 인접리스트에 저장
            for(int i = 0; i < n ; i++){
                Arrays.stream(br.readLine().split(""))
                        .mapToInt(Integer::parseInt)
                        .forEach(arr[i]::add);
            }

            ArrayList<Integer>ansArr = new ArrayList<Integer>();

            for(int i = 0; i < n ; i++){
                for(int j = 0 ; j < n ; j ++){
                    if(arr[i].get(j) != 0 && !visited[i][j]){
                        dfsCnt = 0;
                        cnt++;
                        ansArr.add(dfs(i, j, dfsCnt));
                    }
                }
            }
            System.out.println(cnt);

            Collections.sort(ansArr);

            for(Integer a : ansArr){
                System.out.println(a);
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    private static int dfs(int i, int j, int dfsCnt) {

        if(visited[i][j]){
            return 0;
        }else{
            dfsCnt++;
            visited[i][j] = true;
            for(int x = 0 ; x < 4 ; x++){
                int xx = dx[x] + i;
                int yy = dy[x] + j;
                if(xx >=0 && yy >=0 && n > xx && n > yy){
                    if(!visited[xx][yy] && arr[xx].get(yy)==1){

                        dfsCnt = dfs(xx, yy, dfsCnt);
                    }
                }
            }
        }
        return dfsCnt;
    }
}