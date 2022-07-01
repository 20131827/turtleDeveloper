
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

		/*
		백준 [1157] - 단어 공부
		[문제]
		알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
		[입력]
		첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.
		[출력]
		첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
		 */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int []arr = new int[26];

        String text = br.readLine(); // 검사하게될 텍스트

        for(int i = 0 ; i < text.length() ; i++){
            int e = text.charAt(i);

            // 아스키코드 : a는 97 A는 65
            if(65 <= e && e <=90){ // 대문자로 입력받게 되었다면~
                arr[e-65]++;
            }else{ // 소문자로 입력받게 되었다면~
                arr[e-97]++;
            }
        }

        int max = -1; // 최대값을 구하기 위한 변수
        int po = 0; // 최대값의 인덱스를 저장하기 위한 변수

        for(int i = 0 ; i < arr.length ; i++){
            if (max < arr[i]){
                max = arr[i];
                po = i;
            }
        }

        Arrays.sort(arr); // 최대값을 구하기 위한 정렬!

        // 정렬하기전에 미리 최대값과 최대값의 인덱스를 저장해두었으니
        // 정렬한뒤 2번째로 큰 값과 미리 구한 최대값이 똑같다면
        // 최대값이 같은 녀석이 2개 이상이라는 뜻이된다!!
        if(max == arr[arr.length-2]){
            System.out.println("?");
        }else{
            System.out.print((char)(po+65));
        }

        /*
            아래의 방법대로 구현하는게 지금 아는 방법중 가장 성능이 뛰어나다
            굳이 문자열 변수를 만들지 말고 입력과 동시에 byte 값으로 반환하여 배열의 원소를 증가시키는 방법이다.
            그리고 문자열은 항상 영문자만 입력받기 때문에 조건문 또한 매우 간소화 시켰다.
            또한 int 값으로 저장한 뒤 마지막 출력에서만 캐스팅을 해주는 것으로 바꿀 것이다.
            그리고 문자열만 입력받기 때문에 BufferedReader 가 필요 없다.
            전의 포스팅에서 얘기하던 System.in.read() 로 입력받으면 된다.
        */

/*        int[] arr = new int[26]; // 영문자의 개수는 26개임


        int c = System.in.read();

        while (c > 64) {	// 공백을 입력받는 순간 종료됨

            if (c < 91) {
                arr[c - 65]++;
            } else {
                arr[c - 97]++;
            }
            c = System.in.read();
        }


        int max = -1;
        int ch = -2;	// ? 는 63 이다.

        for (int i = 0; i < 26; i++) {

            if (arr[i] > max) {
                max = arr[i];
                ch = i;
            } else if (arr[i] == max) {
                ch = -2;
            }
        }
        System.out.print((char) (ch+65));*/

    }
}
