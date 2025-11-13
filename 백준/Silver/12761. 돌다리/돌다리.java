import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 스카이 콩콩
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int dong = Integer.parseInt(st.nextToken()); // 출발
        int joo = Integer.parseInt(st.nextToken());  // 도착

        final int MAX = 100000;

        // 항상 방문 배열의 크기는 MAX + 1
        boolean[] visited = new boolean[MAX + 1];
        int[] answer = new int[MAX + 1];

        Queue<Integer> q = new LinkedList<>();
        q.offer(dong);

        // 큐에 넣는순간 visited를 true해줘야함 -> 그래야 여러번 큐에 들어가는걸 방지할수있음
        visited[dong] = true;

        while(!q.isEmpty()) {
            int temp = q.poll();
            int [] arr={temp - 1,temp + 1, temp - a,temp + a, temp - b, temp + b, temp * a, temp * b}; // 8가지 action을 배열에 담았음
            for(int i = 0; i < 8; i++) {
                if(arr[i] >= 0 && arr[i] <= MAX && !visited[arr[i]]) {
                    visited[arr[i]] = true;
                    answer[arr[i]] = answer[temp] + 1;
                    q.add(arr[i]);

                    if(arr[i] == joo) { // 도착점 찾으면 바로 종료
                        System.out.println(answer[arr[i]]);
                        return;
                    }
                }
            }
        }

    }
}