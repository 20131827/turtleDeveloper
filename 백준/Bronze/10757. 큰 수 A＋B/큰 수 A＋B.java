import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
   		/*
		백준 [10757] - 큰 수 A + B
		[문제]
        두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
		[입력]
        첫째 줄에 A와 B가 주어진다. (0 < A,B < 1010000)
		[출력]
        첫째 줄에 A+B를 출력한다.
		 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        BigInteger a = new BigInteger(st.nextToken());
        BigInteger b = new BigInteger(st.nextToken());

        System.out.println(a.add(b));
    }
}