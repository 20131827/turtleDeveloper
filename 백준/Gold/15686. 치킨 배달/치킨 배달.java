
import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<int[]>hp = new ArrayList<>();
    static ArrayList<int[]>cp = new ArrayList<>();
    static int[] arr;
    static int n, m;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        for(int i = 1 ; i < n+1 ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j < n+1 ; j++){
                int val = Integer.parseInt(st.nextToken());
                if(val == 1){
                    hp.add(new int[]{i, j});
                }else if(val == 2){
                    cp.add(new int[]{i, j});
                }
            }
        }
        dfs(0, 0);
        System.out.println(result);
    }

    public static void dfs(int now, int depth) {
        // 조합부터 만들고 계산을 로직 분리하자..!
        if (depth == m) {
            calc();
            return;
        }
        for(int i = now ; i < cp.size() ; i++){
            arr[depth] = i;
            dfs(i + 1, depth + 1); // 중복없는 조합만들기..
        }
    }

    public static void calc(){
        int sum = 0;

        for(int[] house : hp){
            int min = Integer.MAX_VALUE;

            for(int i = 0 ; i < m ; i++){
                int[] chicken = cp.get(arr[i]);
                int dist = Math.abs(house[0] - chicken[0])
                        + Math.abs(house[1] - chicken[1]);
                min = Math.min(min, dist);
            }

            sum += min;
        }

        result = Math.min(result, sum);
    }

}