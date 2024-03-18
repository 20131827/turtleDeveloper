import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
public class Main
{
    static ArrayList<Character>[] arr;
    static ArrayList<Character>[] arr2;
    static boolean[][] visited;
    static int [] dx = {0, 1, 0, -1};
    static int [] dy = {1, 0, -1, 0};

    static int n = 0;

    public static void main(String args[])
    {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());


            // 방문배열 선언
            visited = new boolean[n][n];

            // 인접리스트 선언
            arr= new ArrayList[n];    // 일반인
            arr2 = new ArrayList[n];  // 색약
            // 인접리스트 선언
            for(int i = 0 ; i < n ; i++){
                arr[i] = new ArrayList<Character>();
                arr2[i] = new ArrayList<Character>();
            }



            for(int i = 0 ; i < n ; i++){
                //                st = new StringTokenizer(br.readLine());
                //                String temp = st.nextToken();
                // StringTokenizer 구분자로 문자열을 나눌때 사용하는 클래스이기 때문에 StringTokenizer 는 불필요 하다

                String temp = br.readLine();
                for(int j = 0 ; j < temp.length(); j++){
                    arr[i].add(temp.charAt(j));

                    char trans = 'R';
                    if(temp.charAt(j) == trans){
                        arr2[i].add('G');
                    }else{
                        arr2[i].add(temp.charAt(j));
                    }
                }
            }


            int [] ansArr = new int[2];
            for(int q = 0 ; q < 2 ; q++){
                visited = new boolean[n][n]; // 방문배열 초기화
                int cnt = 0;
                for(int i = 0 ; i < n ; i++){
                    for(int j = 0 ; j < n ; j ++){
                        if(!visited[i][j]){
                            cnt++;
                            if(q == 0){
                                dfs(i, j, arr[i].get(j), q);
                            }else{
                                dfs(i, j, arr2[i].get(j), q);
                            }

                        }
                    }
                }
                ansArr[q] = cnt;
            }
            System.out.println(ansArr[0]+ " " +ansArr[1]);


        } catch(Exception e) {
            System.out.println(e);
        }
    }

    private static void dfs(int i, int j, Character c, int flag) {
        if(visited[i][j]){
            return;
        }else{
            visited[i][j] = true;
            for(int a = 0 ; a < 4 ; a++){ // 상하좌우 움직임이니 4번반 반복하면된다. n번 넣는 실수 하지 말자..!
                int xx = i + dx[a];
                int yy = j + dy[a];
                if(xx >= 0 && xx < n && yy >= 0 && yy < n){
                    if(flag == 0){
                        if(arr[xx].get(yy).equals(c) && !visited[xx][yy]){
                            dfs(xx, yy, c, flag);
                        }
                    }else{
                        if(arr2[xx].get(yy).equals(c) && !visited[xx][yy]){
                            dfs(xx, yy, c, flag);
                        }
                    }

                }
            }

        }

    }
}