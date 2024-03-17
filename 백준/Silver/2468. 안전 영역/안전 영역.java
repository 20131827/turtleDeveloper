import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
public class Main
{
    static int [][] map;
    static boolean [][] visited;
//    static int cnt;
    static int [] dx = {0, 1, 0, -1};
    static int [] dy = {1, 0, -1, 0};

    static int n = 0;

    public static void main(String args[])
    {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken()); // n x n 사이즈의 정사각형

            visited = new boolean[n][n];
            map = new int[n][n];

            int max = 0; // 최대 높이 저장변수

            // map 배열에 데이터 저장
            for (int i = 0; i < n; i++) {
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int rowMax = Arrays.stream(map[i]).max().orElse(Integer.MIN_VALUE); // 각 행의 최댓값 구하기 (Steam 사용법 찾아봐야한다..)
                max = Math.max(max, rowMax); // 최댓값 갱신
            }

//            System.out.println(max);

            int cnt = 0;
            ArrayList<Integer> ansArr = new ArrayList<>();

            for(int a = 0; a <= max ; a++){
                cnt = 0;
                visited = new boolean[n][n]; // 방문배열 초기화 해줘야 정상작동함..
                for (int i = 0; i < n; i++) {
                    for(int j = 0; j < n; j++){
                        if(!visited[i][j] && map[i][j] > a){
                            cnt++;
                            dfs(i, j, a);
                        }
                    }
                }
                ansArr.add(cnt);
            }

            // 만약 안전영역이 1 이하라면? 1출력 (비가 안올경우)
            // 아니라면 안전영역 출력

//            for(int i = 0 ; i < ansArr.toArray().length -1; i++){
//            }
            int ans = Collections.max(ansArr);
            System.out.println(ans == 0 ? 1 : ans);


        } catch(Exception e) {
//            System.out.println(e);
        }
    }

    private static void dfs(int i, int j, int a) { // x좌표, y좌표, 비의 높이

//        if(i < 0 || j < 0 || i >= n || j >= n || visited[i][j] || map[i][j] <= a){
        if(visited[i][j] || map[i][j] <= a){
            return;
        }else{
            visited[i][j] = true;
            for(int m = 0 ; m < 4 ; m++){
                int xx = i + dx[m];
                int yy = j + dy[m];
                if( xx >= 0 && yy >= 0 && xx < n && yy < n) {
                    if (map[xx][yy] > a) {
                        dfs(xx, yy, a);
                    }
                }
            }

        }
    }

}
