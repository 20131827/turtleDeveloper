import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()); // 태균
            int T = Integer.parseInt(st.nextToken()); // 상대

            Queue <int[]> q = new LinkedList<>();
            q.offer(new int[]{S, T, 0});

            while(!q.isEmpty()){
                int[] temp = q.poll();
                int tempS = temp[0];
                int tempT = temp[1];
                int tempR = temp[2];

                if(tempS == tempT){
                    System.out.println(tempR);
                    break;
                }

                if(tempS > tempT) continue;
                q.offer(new int[]{tempS * 2, tempT + 3, tempR + 1});
                q.offer(new int[]{tempS + 1, tempT, tempR + 1});

            }

        }
    }
}