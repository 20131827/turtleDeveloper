import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int [] dist = new int[100001]; // 재방문 하여 메모리 터지는걸 방지하기 위한 visited배열 + cnt 하기 위한 배열
        Arrays.fill(dist, -1);

        Queue<Integer> q  = new LinkedList<>();
        q.offer(s);
        dist[s] = 0; // 시작할떄 바로 0으로 치환해줘야 계산이 편함

        while(!q.isEmpty()){
            int cs = q.poll();
            if(cs == d){
                System.out.println(dist[cs]);
                return;
            }

            int[] next = {cs+1, cs-1, cs*2};
            for(int n : next){
                if(0 <= n && n <= 100000 &&dist[n] == -1){
                    dist[n] = dist[cs]+1;
                    q.offer(n);
                }
            }

        }


    }
}