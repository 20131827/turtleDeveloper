import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {0, 0, 0, 0, 1, -1};
    static int[] dc = {0, 0, -1, 1, 0, 0};
    static int[] dl = {-1, 1, 0, 0, 0, 0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int rowCnt = 0;
        while(true){
            if(rowCnt > 0) br.readLine(); // 테스트 케이스 간 빈줄
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) break;

            char[][][] arr = new char[L][R][C];
            boolean[][][] visited = new boolean[L][R][C];

            int sl = 0, sr = 0, sc = 0;
            int el = 0, er = 0, ec = 0;

            for(int l = 0; l < L ; l++){
                if (l > 0) br.readLine(); // 층 사이 빈 줄만
                for(int r = 0 ; r < R ; r++){
                    String line = br.readLine();
                    for(int c = 0 ; c < C ; c++){
                        arr[l][r][c] = line.charAt(c);
                        if(arr[l][r][c] == 'S'){
                            sl = l;
                            sr = r;
                            sc = c;
                        }else if(arr[l][r][c] == 'E'){
                            el = l;
                            er = r;
                            ec = c;
                        }
                    }
                }
            }

            Queue<int[]> q = new LinkedList<>();
            int cnt = 0;
            q.offer(new int[]{sl, sr, sc, cnt});
            visited[sl][sr][sc] = true;

            boolean flag = true;

            while(!q.isEmpty()){
                int[] temp = q.poll();
                int csl = temp[0];
                int csr = temp[1];
                int csc = temp[2];
                int time = temp[3];

                for(int i = 0 ; i < 6 ; i++){
                    int nsl = csl + dl[i];
                    int nsr = csr + dr[i];
                    int nsc = csc + dc[i];

                    if(nsl == el && nsr == er && nsc == ec) {
                        System.out.println("Escaped in " + (time + 1) + " minute(s).");
                        flag = false;
                        q.clear();     // BFS 즉시 종료
                        break;
                    }

                    if(nsl >= 0 && nsl < L && nsr >= 0 && nsr < R && nsc >= 0 && nsc < C && (arr[nsl][nsr][nsc] == '.' || arr[nsl][nsr][nsc] == 'E') && !visited[nsl][nsr][nsc]){
                        visited[nsl][nsr][nsc] = true;
                        q.offer(new int[]{nsl, nsr, nsc, time + 1});
                    }
                }
            }

            if(flag){
                System.out.println("Trapped!");
            }

            rowCnt++;
        }

    }
}