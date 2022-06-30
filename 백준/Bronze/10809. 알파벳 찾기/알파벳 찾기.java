import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {

		/*
		백준 [10809] - 알파벳 찾기
		[문제]
		알파벳 소문자로만 이루어진 단어 S가 주어진다. 각각의 알파벳에 대해서, 단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.
		[입력]
		첫째 줄에 단어 S가 주어진다. 단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.
		[출력]
		각각의 알파벳에 대해서, a가 처음 등장하는 위치, b가 처음 등장하는 위치, ... z가 처음 등장하는 위치를 공백으로 구분해서 출력한다.
		만약, 어떤 알파벳이 단어에 포함되어 있지 않다면 -1을 출력한다. 단어의 첫 번째 글자는 0번째 위치이고, 두 번째 글자는 1번째 위치이다.
		 */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int []arr = new int[26]; // 알파벳의 위치를 저장할 배열

        for(int i = 0; i < arr.length; i++){ // 배열을 모두 -1로 초기화 시켜준다
            arr[i] = -1;
        }

        String str = br.readLine();
        // 문자 인코딩 값(=아스키코드 값과 동일)에 'a' 또는 97 을 빼주면 된다. ( a 는 10진수로 97 이라는 값에 대응된다.)
        // c라는 문자열의 위치는 2 라고 저장을 해야하는데 a = 97 c = 99 즉 99-97 = "2" 라는 인덱스에 i 값을 넣으면??
        // 입력받은 문자열의 i번째값이 abcdef....있는 배열에 맞춰저서 몇번째에 있는지 알게된다..
        // 말을 조리있게 풀어 쓰지 못했는데 디버그 걸어서 돌려보면 금방 이해할것이다!
        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);
            if(arr[ch - 'a'] == -1){ // -'a' 또는 -97을 해주면 된다!
                arr[ch - 'a'] = i;
            }
        }

        for(int val : arr) {	// 배열 출력
            System.out.print(val + " ");
        }
    }
}