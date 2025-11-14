import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int [] arr = new int[n + 1];
        boolean [] visited = new boolean[n +1 ];

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <=n ; i++){
            arr[i] = Integer.parseInt(st.nextToken()); // 이동 가능거리 입력
        }

        st = new StringTokenizer(br.readLine());
        int cur = Integer.parseInt(st.nextToken()); // 현재위치

        Queue<Integer> q = new LinkedList<>();
        q.offer(cur);
        visited[cur] = true;

        int cnt = 0 ;
        while(!q.isEmpty()){
            int temp = q.poll();
            cnt++;

            int l = temp - arr[temp];
            int r = temp + arr[temp];

            if(l >= 1 && !visited[l]){
                visited[l] = true;
                q.offer(l);
            }

            if(r <= n && !visited[r]){
                visited[r] = true;
                q.offer(r);
            }
        }
        System.out.println(cnt);
    }
}