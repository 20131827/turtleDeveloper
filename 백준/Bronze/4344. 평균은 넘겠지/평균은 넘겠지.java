import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine()); // 테스트 케이스의 수
        int [] arr;

        StringTokenizer st;

        while (testCase > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int index = Integer.parseInt(st.nextToken()); // 학생의 수
            arr = new int[index];

            double sum = 0; // 성적 누적을 구하기 위함

            // 성적 입력 부분 [입력받으면서 동시에 누적 합을 구함]
            for (int i = 0; i < index; i++) {
                int value =Integer.parseInt(st.nextToken());
                arr[i] = value;
                sum += value; // 성적 누적 합!
            }

            double avr = sum / index; // 평균값
            double cnt = 0.0; // 평균을 넘는 학생의 수

            // 평균을 넘는 학새의 비율을 구하는 부분
            for (int i = 0; i < index; i++) {

                if(arr[i] > avr){
                    cnt++;
                }
            }
            // printf 에서 "%" 라는 문자를 출력을 하려면 %% 로 적어야함
            System.out.printf("%.3f%%\n",(cnt / index)*100);
            testCase--;
        }
    }
}