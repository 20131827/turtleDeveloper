import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
   		/*
		백준 [2775] - 부녀회장이 될테야
		[문제]
        평소 반상회에 참석하는 것을 좋아하는 주희는 이번 기회에 부녀회장이 되고 싶어 각 층의 사람들을 불러 모아 반상회를 주최하려고 한다.
        이 아파트에 거주를 하려면 조건이 있는데, “a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다” 는 계약 조항을 꼭 지키고 들어와야 한다.
        아파트에 비어있는 집은 없고 모든 거주민들이 이 계약 조건을 지키고 왔다고 가정했을 때, 주어지는 양의 정수 k와 n에 대해 k층에 n호에는 몇 명이 살고 있는지 출력하라.
        단, 아파트에는 0층부터 있고 각층에는 1호부터 있으며, 0층의 i호에는 i명이 산다.
		[입력]
        첫 번째 줄에 Test case의 수 T가 주어진다. 그리고 각각의 케이스마다 입력으로 첫 번째 줄에 정수 k, 두 번째 줄에 정수 n이 주어진다
		[출력]
        각각의 Test case에 대해서 해당 집에 거주민 수를 출력하라.
		 */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

        int arr [][] = new int[15][15];

        // 각층의 1호실에 1값을, 0층에 각호실에 i값을 넣는 작업
        for(int i = 0; i < 15 ; i ++){
            arr[i][0] = 1;
            arr[0][i] = i+1;
        }
        // 반복문을 사용하지 않고 2차원 배열 값을 문자열로 쉽게 출력할 수 있는 함수! Arrays.deepToString()
//        System.out.println(Arrays.deepToString(arr));

        for(int i = 1; i < 15 ; i ++){
            for(int j = 1; j < 15 ; j++){
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }
        // 반복문을 사용하지 않고 2차원 배열 값을 문자열로 쉽게 출력할 수 있는 함수! Arrays.deepToString()
//        System.out.println(Arrays.deepToString(arr));

        while (T != 0){
            int a = Integer.parseInt(br.readLine()); // 몇층
            int b = Integer.parseInt(br.readLine()); // 몇호
            
            // 층은 0층부터 있으나, 호실은 1호실 부터 있기 떄문!
            System.out.println(arr[a][b-1]);
            T--;
        }
        br.close();
    }
}