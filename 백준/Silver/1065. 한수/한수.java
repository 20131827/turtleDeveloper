import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int han(int number) {

        int count = 0; // 한수의 개수

        if (number < 100) {
            return number;
        } else {
            count = 99;
            for (int i = 100; i <= number; i++) {
                int a = i / 100; // 백의자리
                int b = (i / 10) % 10; // 십의자리
                int c = i % 10; // 일의자리

                if ((a - b) == (b - c)) // 등차수열이 맞다면
                    count++;
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(han(Integer.parseInt(br.readLine())));
    }
}