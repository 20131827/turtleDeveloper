import java.io.*;
import java.util.*;
public class Main {
    static ArrayList<Integer>[] map ;
    static boolean []visited;

    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.valueOf(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int startIndex = Integer.parseInt(st.nextToken());

            // 정점의 개수만큼
            map = new ArrayList[n+1];
            visited = new boolean [n+1];

            for(int i = 0 ; i < map.length ; i++){
                map[i] = new ArrayList<>();
            }

            // 입력단
            for(int i = 0 ; i < m ; i++){
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                // 양방향 간선 입력받기
                map[x].add(y);
                map[y].add(x);
            }

            // 작은값 순서대로 정렬
            for(int i = 0 ; i < map.length ; i++) {
                Collections.sort(map[i]);
            }

            dfs(startIndex);
            visited = new boolean [n+1];
            System.out.println("");
            bfs(startIndex);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    static void dfs(int a){
        visited[a] = true;
        System.out.print(a + " ");
        for(int i : map[a]){
            if(!visited[i]){
                dfs(i);
            }
        }
    }

    static void bfs(int a){
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        q.offer(map[a]);

        visited[a] = true;
        System.out.print(a + " ");

        while(!q.isEmpty()){
            for(int i : q.poll()){
                if(!visited[i]) {
                    visited[i] = true;
                    System.out.print(i + " ");
                    q.offer(map[i]);
                }
            }
        }
    }
}