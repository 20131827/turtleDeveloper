//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//public class Main {
//    public static void main(String[] args) throws IOException {
//		/*
//		백준 [11021] - A + B - 7
//		[문제]
//		두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
//		[입력]
//		첫째 줄에 테스트 케이스의 개수 T가 주어진다.
//		각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
//		[출력]
//		각 테스트 케이스마다 "Case #x: "를 출력한 다음, A+B를 출력한다. 테스트 케이스 번호는 1부터 시작한다.
//		 */
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int start = Integer.parseInt(br.readLine());
//        StringTokenizer st;
//        StringBuilder sb = new StringBuilder();
//        int i = 0;
//
//        while(start > i) {
//            st = new StringTokenizer(br.readLine(), " ");
//            sb.append("Case #" + (i+1) + ": " + (Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())));
//            sb.append('\n');
//            i++;
//        }
//        System.out.println(sb.toString());
//    }
//}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//public class Main {
//    public static void main(String[] args) throws IOException {
//		/*
//		백준 [11022] - A + B - 8
//		[문제]
//		두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
//		[입력]
//		첫째 줄에 테스트 케이스의 개수 T가 주어진다.
//		각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
//		[출력]
//		각 테스트 케이스마다 "Case #x: A + B = C" 형식으로 출력한다. x는 테스트 케이스 번호이고 1부터 시작하며, C는 A+B이다.
//		 */
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int start = Integer.parseInt(br.readLine());
//        StringTokenizer st;
//        StringBuilder sb = new StringBuilder();
//        int i = 0;
//        int a;
//        int b;
//        while(start > i) {
//            st = new StringTokenizer(br.readLine(), " ");
//            a = Integer.parseInt(st.nextToken());
//            b = Integer.parseInt(st.nextToken());
//            sb.append("Case #" + (i+1) + ": " + a + " + " + b + " = "+ + (a+b));
//            sb.append('\n');
//            i++;
//        }
//        System.out.println(sb.toString());
//    }
//}


//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//public class Main {
//    public static void main(String[] args) throws IOException {
//		/*
//		백준 [2438] - 별 찍기 - 1
//		[문제]
//		첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
//		[입력]
//		첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
//		[출력]
//		첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
//		 */
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int start = Integer.parseInt(br.readLine());
//        br.close();
//
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 1; i <= start; i++) {
//            for (int j = 1; j <= i; j++) {
//                sb.append('*');
//            }
//            sb.append('\n');
//        }
//        System.out.print(sb);
//    }
//}


//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//public class Main {
//    public static void main(String[] args) throws IOException {
//		/*
//		백준 [2439] - 별 찍기 - 2
//		[문제]
//		첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
//        하지만, 오른쪽을 기준으로 정렬한 별(예제 참고)을 출력하시오.
//        [입력]
//		첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
//		[출력]
//		첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
//		 */
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int start = Integer.parseInt(br.readLine());
//        br.close();
//
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 1; i <= start; i++) {
//            for (int j = 1; j <= (start - i); j++) {
//                sb.append(' ');
//            }
//            for(int k = 1 ; k <= i ; k++){
//                sb.append("*");
//            }
//            sb.append('\n');
//        }
//        System.out.print(sb);
//    }
//}


//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//public class Main {
//    public static void main(String[] args) throws IOException {
//		/*
//		백준 [10871] - X보다 작은 수
//		[문제]
//		정수 N개로 이루어진 수열 A와 정수 X가 주어진다. 이때, A에서 X보다 작은 수를 모두 출력하는 프로그램을 작성하시오.
//        [입력]
//		첫째 줄에 N과 X가 주어진다. (1 ≤ N, X ≤ 10,000)
//        둘째 줄에 수열 A를 이루는 정수 N개가 주어진다. 주어지는 정수는 모두 1보다 크거나 같고, 10,000보다 작거나 같은 정수이다.
//		[출력]
//		X보다 작은 수를 입력받은 순서대로 공백으로 구분해 출력한다. X보다 작은 수는 적어도 하나 존재한다.
//		 */
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine()," ");
//
//        int n = Integer.parseInt(st.nextToken());
//        int x = Integer.parseInt(st.nextToken());
//        int v;
//        StringBuilder sb = new StringBuilder();
//        st = new StringTokenizer(br.readLine(), " ");
//        while(n > 0){
//            v = Integer.parseInt(st.nextToken());
//            if(v < x)
//                sb.append(v).append(' ');
//
//            n--;
//        }
//        System.out.println(sb);
//    }
//}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//public class Main {
//    public static void main(String[] args) throws IOException {
//		/*
//		백준 [10952] - A + B - 5
//		[문제]
//		두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
//        [입력]
//		입력은 여러 개의 테스트 케이스로 이루어져 있다.
//        각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
//        입력의 마지막에는 0 두 개가 들어온다.
//		[출력]
//		각 테스트 케이스마다 A+B를 출력한다.
//		 */
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        int n;
//        int x;
//
//        StringBuilder sb = new StringBuilder();
//
//        while(true){
//            st = new StringTokenizer(br.readLine()," ");
//            n = Integer.parseInt(st.nextToken());
//            x = Integer.parseInt(st.nextToken());
//            if((n + x) != 0){
//                sb.append(n+x).append('\n');
//            }else
//                break;
//        }
//        System.out.println(sb);
//    }
//}


//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//public class Main {
//    public static void main(String[] args) throws IOException {
//
//		/*
//		백준 [10951] - A + B - 4
//		[문제]
//		두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
//		[입력]
//		입력은 여러 개의 테스트 케이스로 이루어져 있다.
//        각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
//		[출력]
//		각 테스트 케이스마다 A+B를 출력한다.
//		 */
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        StringTokenizer st;
//        String str;
//
//        while( (str=br.readLine()) != null ) {
//                // while 조건에 str=br.readLine() 이렇게 안써주면.. 컴파일 에러 발생한다!
//            st = new StringTokenizer(str, " ");
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//            sb.append(a + b).append("\n");
//        }
//        System.out.println(sb.toString());
//    }
//}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//public class Main {
//    public static void main(String[] args) throws IOException {
//
//		/*
//		백준 [1110] - 더하기 사이클
//		[문제]
//		0보다 크거나 같고, 99보다 작거나 같은 정수가 주어질 때 다음과 같은 연산을 할 수 있다. 먼저 주어진 수가 10보다 작다면 앞에 0을 붙여 두 자리 수로 만들고,
//		각 자리의 숫자를 더한다. 그 다음, 주어진 수의 가장 오른쪽 자리 수와 앞에서 구한 합의 가장 오른쪽 자리 수를 이어 붙이면 새로운 수를 만들 수 있다. 다음 예를 보자.
//        26부터 시작한다. 2+6 = 8이다. 새로운 수는 68이다. 6+8 = 14이다. 새로운 수는 84이다. 8+4 = 12이다. 새로운 수는 42이다. 4+2 = 6이다. 새로운 수는 26이다.
//        위의 예는 4번만에 원래 수로 돌아올 수 있다. 따라서 26의 사이클의 길이는 4이다.
//        N이 주어졌을 때, N의 사이클의 길이를 구하는 프로그램을 작성하시오.
//		[입력]
//		첫째 줄에 N이 주어진다. N은 0보다 크거나 같고, 99보다 작거나 같은 정수이다.
//		[출력]
//		첫째 줄에 N의 사이클 길이를 출력한다.
//		 */
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine());
//        int cnt = 0;
//        int copy = N;
//        do {
//            N = ((N % 10) * 10) + (((N / 10) + (N % 10)) % 10);
//            cnt++;
//        } while (copy != N);
//
//        System.out.println(cnt);
//    }
//}


//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//
//		/*
//		백준 [10818] - 최소, 최대
//		[문제]
//		N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
//		[입력]
//		첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다. 모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다
//		[출력]
//		첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.
//		 */
//
//        /*
//            근데 배열을 굳이 써줄 필요가 있을까? 메모리만 잡아먹고, 배열의 원소 정렬에서 최악의 경우 시간복잡도가 N^2 이기 때문에 너무 불필요하게 시간을 낭비한다.
//            그러면 어떻게 하면 시간하고 메모리를 적게 낭비시킬까?
//            이에 대한 해결은 다음 두 가지를 통해 대부분 해결할 수 있다.
//            배열을 사용하지 않는다.
//            입력받은 문자를 즉시 비교한다. ( 그러면 시간복잡도가 N 으로 정렬할 필요 없어 시간을 단축시킬 수 있음 )
//         */
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine());
//
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//        int Min = Integer.parseInt(st.nextToken());
//        int Max = Min;
//
//        for (int i = 1; i < N; i++) {
//            int Num = Integer.parseInt(st.nextToken());
//            Min = Math.min(Min, Num);
//            Max = Math.max(Max, Num);
//        }
//
//        br.close();
//
//        System.out.println(Min + " " + Max);
//    }
//}



//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        /*
//		백준 [2562] - 최댓값
//		[문제]
//		9개의 서로 다른 자연수가 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 번째 수인지를 구하는 프로그램을 작성하시오.
//        예를 들어, 서로 다른 9개의 자연수
//        3, 29, 38, 12, 57, 74, 40, 85, 61
//        이 주어지면, 이들 중 최댓값은 85이고, 이 값은 8번째 수이다.
//		[입력]
//		첫째 줄부터 아홉 번째 줄까지 한 줄에 하나의 자연수가 주어진다. 주어지는 자연수는 100 보다 작다.
//		[출력]
//		첫째 줄에 최댓값을 출력하고, 둘째 줄에 최댓값이 몇 번째 수인지를 출력한다.
//		 */
//
//
//        /*
//        배열을 사용하는 방법 vs 배열 사용 안하는 방법!
//        스캐너사용하는것과 버퍼리더 사용하는것은 성능차이가 많이 나지만
//        내가 못해서 그런지 아직 배열 사용하는 부분에서는 성능 차이를 보이지는 않는다!
//         */
//
//        // 배열 사용하는 버전
////        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////        int arr[] = new int[9];
////
////        for (int i = 0; i < 9; i++) {
////            arr[i] = Integer.parseInt(br.readLine());
////        }
////
////        int max = 0;
////        int index = 0;
////
////        int cnt = 0;
////
////        for (int value : arr) {
////            cnt++;
////            if (value > max) {
////                max = value;
////                index = cnt;
////            }
////        }
////        System.out.println(max + "\n" + index);
//
////         배열 사용하지 않는 버전
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int max = 0;
//        int index = 0;
//
//        for(int i = 0; i< 9 ; i++){
//            int val = Integer.parseInt(br.readLine());
//
//            if(val > max){
//                max = val;
//                index = i + 1;
//            }
//        }
//        System.out.println(max + "\n" + index);
//
//    }
//}
//


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

		/*
		백준 [2577] - 숫자의 개수
		[문제]
		세 개의 자연수 A, B, C가 주어질 때 A × B × C를 계산한 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지를 구하는 프로그램을 작성하시오.
        예를 들어 A = 150, B = 266, C = 427 이라면 A × B × C = 150 × 266 × 427 = 17037300 이 되고, 계산한 결과 17037300 에는 0이 3번, 1이 1번, 3이 2번, 7이 2번 쓰였다.
		[입력]
		첫째 줄에 A, 둘째 줄에 B, 셋째 줄에 C가 주어진다. A, B, C는 모두 100보다 크거나 같고, 1,000보다 작은 자연수이다.
		[출력]
		첫째 줄에는 A × B × C의 결과에 0 이 몇 번 쓰였는지 출력한다. 마찬가지로 둘째 줄부터 열 번째 줄까지 A × B × C의 결과에 1부터 9까지의 숫자가 각각 몇 번 쓰였는지 차례로 한 줄에 하나씩 출력한다.
		 */


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int Min = Integer.parseInt(st.nextToken());
        int Max = Min;

        for (int i = 1; i < N; i++) {
            int Num = Integer.parseInt(st.nextToken());
            Min = Math.min(Min, Num);
            Max = Math.max(Max, Num);
        }

        br.close();

        System.out.println(Min + " " + Max);
        // TEST -- dev 분기된 브랜치 생성이 잘 되었는가?
    }
}