import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        Deque<Integer> que = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int now = arr[i];


            while (!que.isEmpty() && arr[que.peekLast()] > now) {
                que.removeLast();
            }

            // 값이아닌 인덱스를 넣었다
            que.offerLast(i);

            if (que.getFirst() < i - L + 1) {
                que.removeFirst();
            }

            sb.append(arr[que.peekFirst()] + " ");

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
