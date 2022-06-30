import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {

		/*
		백준 [11720] - 숫자의 합
		[문제]
		N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
		[입력]
		첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.
		[출력]
		입력으로 주어진 숫자 N개의 합을 출력한다.
		 */


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();	// N 은 쓸모가 없으므로 입력만 받음

        int sum = 0;

        for(byte value : br.readLine().getBytes()) {
//          System.out.print(value - 48);
            sum += (value - '0');	// 또는 (value - 48)
        }

        System.out.print(sum);


        // 아래의 방법으로 물제를 해결하게되면 런타임 오류가 발생한다..
        // why? 70000000000000000000000000000000000000000000000000 
        // 와 같은 큰수가 들어오게되면 int형이 터저버리기 때문..ㅠㅠ

/*        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 입력받을 숫자의 자리수
        int result = 0; //  결과값

        int input = Integer.parseInt(br.readLine()); // 입력받는 숫자
        int temp = 0; // 자리값

        while (N > 0) {
            temp = input % 10;
            input /= 10;
            result += temp;
            N--;
        }
        System.out.println(result);*/

    }
}