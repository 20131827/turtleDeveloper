import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static boolean prime(int num){
        // 1 은 소수가 아니다.
        if(num == 1)
            return false;

        // 2 ~ Number-1 까지 중 나누어 떨어지는 약수가 있는지 판별
        // Number = 2 의 경우는 자연스럽게 for문을 검사하지 않게 됨
//        for(int i = 2; i < num; i++) {
//            // 해당 for문의 경우 num값 만큼 계~~~속 검사를 해야해서 효율이 좋지못함!
//            if(num % i == 0) return false;
//
//        }

        for(int i = 2; i <= Math.sqrt(num); i++) {
            // 해당 for문의 경우 100을 입력 받았다면 100의 루트값(제곱근) 10 까지만 검사를 하면 되기 때문에 효율이 위보다 좋음!
            if(num % i == 0) return false;
        }

        // 위 두 조건에 걸리지 않으면 소수다.
        return true;
    }
    public static void main(String[] args) throws IOException {
   		/*
		백준 [1978] - 소수 찾기
		[문제]
        주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
		[입력]
        첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
		[출력]
        주어진 수들 중 소수의 개수를 출력한다.
		 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수 (어차피 안씀)
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int result = 0;
        while (st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            if (prime(num)) {
                result++;
            }
            T--;
        }
        br.close();
        System.out.println(result);

    }
}