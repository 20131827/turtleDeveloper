import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Main
{
    static boolean visited[];//방문 배열
    static ArrayList<Integer> [] arr; // 그래프 데이터를 저장할 인접 리스트
    public static void main(String args[])
    {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken()); // 노드의 개수
            int e = Integer.parseInt(st.nextToken()); // 엣지의 개수

            // 방문배열, 인접리스트 초기화 (n+1 이유는 인덱스0을 사용해서 진행 시 헷갈려서)
            arr = new ArrayList[n+1];
            visited = new boolean[n+1];

            // 인접리스트 안에 (노드개수만큼)리스트 생성
            for(int i = 1 ; i < n+1 ; i++) {
                arr[i] = new ArrayList<Integer>();
            }


            for(int i = 0 ; i < e ; i++){  // 에지의 방향이 없기 떄문에 양방향으로 봐야함 ex) 1<-->2...
                st = new StringTokenizer(br.readLine());
                int si = Integer.parseInt(st.nextToken()); // 시작점
                int ei = Integer.parseInt(st.nextToken()); // 끝점
                // 엣지의 방향이 정해지지 않았기에 양방향으로 셋팅해야함
                arr[si].add(ei);
                arr[ei].add(si);
            }

            int cnt = 0 ; // dfs가 몇번 돌았는지? (돈 횟수가 연결요소의 개수와 동일함)

            for(int i = 1 ; i < n+1 ; i++){
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

    private static void dfs(int i) {
        if(visited[i]) {
            return;
        } else{
            visited[i] = true;
            for (int a : arr[i]) {
                if(!visited[a]){
                    dfs(a);
                }
            }
        }
    }


}