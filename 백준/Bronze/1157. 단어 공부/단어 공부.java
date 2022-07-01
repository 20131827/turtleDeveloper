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
    }
}