import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 사람의 수
        int n = Integer.parseInt(br.readLine());
        // 인출에 걸리는 시간
        int []arr = new int[n];
        // 삽입정렬 시 사용하기 위한 임시 배열
        int []temp = new int[n];

        // 인출에 걸리는 시간을 배열로 옮겨담기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < arr.length ; i++){
            int m = Integer.parseInt(st.nextToken());
            arr[i] = m;
            temp[i] = m;
        }

        for(int i = 1 ; i < arr.length ; i++){
            int idx = i;
            // 삽입할 값(해당 변수를 사용하지 않으면 shift 할때 기존값을 모름
            int insertValue = arr[i];

            // 삽입할 index 찾기
            for(int j = i-1 ; j >= 0 ; j--){
                if(arr[i] < arr[j]){
                    idx = j;
                }
            }

            // 삽입위치 뒤의 값들 shift
            for(int x = i ; x > idx; x--){
                arr[x] = arr[x-1];
            }
            arr[idx] = insertValue;
        }

        // 정렬 완료된 배열
//        System.out.println(arr);

        // 누적합을 구하기 위한 합배열 생성
        int []s = new int[arr.length];

        s[0] = arr[0];
        for(int i = 1 ; i < s.length ; i++){
            s[i] = s[i-1] + arr[i];
        }

        // 합배열 완성
//        System.out.println(s);

        int sum = 0;
        for(int i = 0 ; i < s.length ; i++){
            sum+= s[i];
        }

        System.out.println(sum);

    }
}


