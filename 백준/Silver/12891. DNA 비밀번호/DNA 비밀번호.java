import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int strLength = Integer.parseInt(st.nextToken()); // 문자열의 길이
        int pwLength = Integer.parseInt(st.nextToken()); // 비밀번호 길이
        int cnt = 0; // 정답 개수
        char str[]; // 입력받은 문자열
        int cntArr [] = new int [4]; // 현재 문자열의 dna 포함 문자의 개수를 카운팅한 배열
        int dnaCheck [] = new int [4]; // dna의 최소 개수가 담긴 배열

        str = br.readLine().toCharArray(); // 문자열 입력받기

        st = new StringTokenizer(br.readLine()," ");

        for(int i = 0 ; i < 4 ; i++){ // dna 최소개수 담긴 배열 입력 받기
            dnaCheck[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = pwLength;

        while(end <= strLength){
            if(start == 0) {
                for (int i = 0; i <= pwLength - 1; i++) {
                    switch (str[i + start]) {
                        case 'A':
                            cntArr[0]++;
                            break;
                        case 'C':
                            cntArr[1]++;
                            break;
                        case 'G':
                            cntArr[2]++;
                            break;
                        case 'T':
                            cntArr[3]++;
                            break;
                    }
                }
            }else{
                switch (str[start-1]) {
                    case 'A':
                        cntArr[0]--;
                        break;
                    case 'C':
                        cntArr[1]--;
                        break;
                    case 'G':
                        cntArr[2]--;
                        break;
                    case 'T':
                        cntArr[3]--;
                        break;
                }
                switch (str[end-1]) {
                    case 'A':
                        cntArr[0]++;
                        break;
                    case 'C':
                        cntArr[1]++;
                        break;
                    case 'G':
                        cntArr[2]++;
                        break;
                    case 'T':
                        cntArr[3]++;
                        break;
                }
            }
            
            if(cntArr[0] >= dnaCheck[0] &&cntArr[1] >= dnaCheck[1] &&cntArr[2] >= dnaCheck[2] &&cntArr[3] >= dnaCheck[3]) cnt++;
            
            end++;
            start++;
        }

        System.out.println(cnt);

    }
}