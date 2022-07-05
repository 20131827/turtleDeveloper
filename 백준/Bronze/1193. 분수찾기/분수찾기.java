import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
   		/*
		백준 [1193] - 분수 찾기
		[문제]

		[입력]

		[출력]

		 */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        int t = 2; // 분모 분자의 합
        int num = 0;
        int preNum = 0;

        while (input > num) {
            num += (t - 1);
            t++;
            if (input > num) {
                preNum = num;
            }
        }
        if ((t % 2) == 0)
            System.out.println((input - preNum) + "/" + ((t - 1) - (input - preNum)));
        else
            System.out.println(((t - 1) - (input - preNum)) + "/" + (input - preNum));

    }
}