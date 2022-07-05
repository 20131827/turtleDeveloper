import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
   		/*
		백준 [10250] - ACM 호텔
		[문제]

		[입력]

		[출력]

		 */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수
        StringBuffer sb = new StringBuffer();

        while (T != 0){
            st  = new StringTokenizer(br.readLine(), " ");
            int h = Integer.parseInt(st.nextToken()); // 호텔의 층 수
            int w = Integer.parseInt(st.nextToken()); // 각 층의 방 수 [사용 안하는 변수]
            int n = Integer.parseInt(st.nextToken()); // 몇 번째 손님

            System.out.println((n % h == 0) ? (h * 100) + (n / h) : (((n % h) * 100) + ((n / h) + 1)));

            T--;
        }
        br.close();
    }
}