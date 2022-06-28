import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        방법 1
        먼저 0부터 9까지 체크할 길이 10의 int 배열을 생성한다. (기본 int배열 초기값은 모두 0이다.)
        그리고 val 에다가 br.readLine() 으로 읽은 값을 곱해서 저장한다.
        그리고 String str 에다가 val 의 Int 형을 String 형으로 변환해준 뒤 for문을 통해 해당 문자열의 문자 값 - 48 (또는 -'0')을 추출해내 int 배열의 index 값을 1 증가시킨다.
        마지막으로 배열 원소에 저장된 모든 원소를 출력한다.
        */

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int[] arr = new int[10];
//
//        int val = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());
//
//        String str = String.valueOf(val);
//
//        for (int i = 0; i < str.length(); i++) {
//            arr[(str.charAt(i) - 48)]++;
//        }
//
//        for (int v : arr) {
//            System.out.println(v);
//        }

        /*
        방법 2
        몫, 나머지 연산을 통한 방법
        자리수 마다 나머지를 구해서 배열에 저장하는 방식
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int val = Integer.parseInt(br.readLine())*Integer.parseInt(br.readLine())*Integer.parseInt(br.readLine());
        int[] arr = new int[10];
        br.close();

        while(val!=0) {
            arr[val%10]++;
            val/=10;
        }

        for(int result : arr) {
            System.out.println(result);
        }
    }
}