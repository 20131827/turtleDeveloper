import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

		/*
		백준 [2908] - 상수
		[문제]
		상근이의 동생 상수는 수학을 정말 못한다. 상수는 숫자를 읽는데 문제가 있다. 이렇게 수학을 못하는 상수를 위해서 상근이는 수의 크기를 비교하는 문제를 내주었다.
		상근이는 세 자리 수 두 개를 칠판에 써주었다. 그 다음에 크기가 큰 수를 말해보라고 했다.
        상수는 수를 다른 사람과 다르게 거꾸로 읽는다. 예를 들어, 734와 893을 칠판에 적었다면, 상수는 이 수를 437과 398로 읽는다.
        따라서, 상수는 두 수중 큰 수인 437을 큰 수라고 말할 것이다.
        두 수가 주어졌을 때, 상수의 대답을 출력하는 프로그램을 작성하시오.
		[입력]
		첫째 줄에 상근이가 칠판에 적은 두 수 A와 B가 주어진다. 두 수는 같지 않은 세 자리 수이며, 0이 포함되어 있지 않다.
		[출력]
		첫째 줄에 상수의 대답을 출력한다.
		 */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // reverse() : 문자열을 뒤집어 주는 메소드 입니다.
        int A = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
        int B = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());

        System.out.println(Math.max(A,B));

        /*BufferedReader 말고 가장 원시 입력인 System.in.read() 를 사용하는 방법이다.
        어차피 입력되는 수는 세 자릿수로 고정되어있기 때문에 더욱 빠르고 쉽게 짤 수 있다.
        그리고 read() 메소드는 한 자리씩 반환되기 때문에 문자열을 뒤집을 필요 없이 다음과 같은 수식으로 누적해주면 된다.*/

/*     int A = 0;
        int B = 0;

        A += System.in.read() - 48;
        A += (System.in.read() - 48)*10;
        A += (System.in.read() - 48)*100;

        System.in.read();	// 공백

        B += System.in.read() - 48;
        B += (System.in.read() - 48)*10;
        B += (System.in.read() - 48)*100;

        System.out.println(A > B ? A : B);*/

    }
}