import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main
{
    static boolean visited[];//방문 배열
    static ArrayList<Integer> [] A; // 그래프 데이터를 저장할 인접 리스트
    public static void main(String args[])
    {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken()); //노드개수
            int m = Integer.parseInt(st.nextToken()); //에지개수

            visited = new boolean[n+1]; //방문 배열
            A = new ArrayList[n+1]; // 그래프 데이터를 저장할 인접 리스트

            for(int i = 1 ; i < n+1 ; i++){
                A[i] = new ArrayList<Integer>();
            }

            for(int i = 0 ; i < m ; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                A[s].add(e);
                A[e].add(s);
            }

            int cnt = 0;

            for(int i =1 ; i < n+1 ; i++){
                if(!visited[i]){
                    cnt++;
                    dfs(i);
                }
            }
            System.out.println(cnt);
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    private static void dfs(int v) {
        if(visited[v]){
            return;
        }else{
            visited[v] = true;
            for(int i : A[v]){
                if(!visited[i]){
                    dfs(i);
                }
            }
        }
    }

}