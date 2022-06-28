import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int total = Integer.parseInt(br.readLine());
//
//        StringBuilder sb = new StringBuilder();
//
//        StringTokenizer st;
//
//        char[] charArr ;
//
//        int sco = 0; // 최종 점수
//        int sum = 0; // 누적 합산 계산 하기 위함
//        int Ocnt = 0; // 연속 정답 계산 하기 위함
//
//        for(int i = 0; i < total ; i++){
//            st = new StringTokenizer(br.readLine(), " ");
//            charArr = st.nextToken().toCharArray();
//            if(charArr[i] == 'O'){
//                Ocnt++;
//                for(int j = 0; j < Ocnt ; j++){
//                    sum += 1;
//                }
//                Ocnt = 0;
//                sco += sum;
//            }else{
//                sum = 0;
//            }
//            sb.append(sco).append("\n");
//            if(i == total) {
//                sb.append(sco);
//                System.out.println(sb.toString());
//            }
//        }
//
//        br.close();


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int test_case = Integer.parseInt(br.readLine());	//테스트 케이스

        String arr[] = new String[test_case];

        for (int i = 0; i < test_case; i++) {
            arr[i] = br.readLine();
        }

        br.close();
        for (int i = 0; i < test_case; i++) {

            int cnt = 0;	// 연속 정답 횟수
            int sum = 0;	// 누적 합산

            for (int j = 0; j < arr[i].length(); j++) {

                if (arr[i].charAt(j) == 'O') {
                    cnt++;
                } else {
                    cnt = 0;
                }
                sum += cnt;
            }

            sb.append(sum).append('\n');
        }

        System.out.print(sb);
    }
}