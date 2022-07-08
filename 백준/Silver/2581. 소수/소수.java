import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static boolean prime[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        prime = new boolean[N + 1];	// 배열 생성
        get_prime();


        // 소수 합 및 최솟값
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i = M; i <= N; i++) {
            if(prime[i] == false) {	// false = 소수
                sum += i;
                if(min == Integer.MAX_VALUE) {	// 첫 소수가 최솟값임
                    min = i;
                }
            }
        }

        if(sum == 0) {	// 소수가 없다면
            System.out.println(-1);
        }
        else {
            System.out.println(sum);
            System.out.println(min);
        }

    }


    // 에라토스테네스 체 알고리즘
    public static void get_prime() {
        prime[0] = true;
        prime[1] = true;

        for(int i = 2; i <= Math.sqrt(prime.length); i++) {
            if(prime[i]) continue;	// 이미 체크된 배열일 경우 skip
            for(int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }

    }

/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    static int prime (int num){
        if(num == 1){
            return 0;
        }

        for(int i = 2; i <= Math.sqrt(num); i++) {
            // 해당 for문의 경우 100을 입력 받았다면 100의 루트값(제곱근) 10 까지만 검사를 하면 되기 때문에 효율이 위보다 좋음!
            if(num % i == 0) {
                return 0;
            }
        }

        // 위의 두 조건을 모두 통과하면 소수로 인정받을 수 있음
        return num;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        int[] arr = new int[(b - a)+1];
        int index = 0;
        for (int i = a; i <= b; i++) {
            if (prime(i) != 0) {
                arr[index] = i;
            }
            index++;
        }

        int total = 0; // 소수들의 합을 구하기 위함
        int min = 0; // 소수들의 최소값을 구하기 위함

        index = arr.length == 1 ? 0 : arr.length - 1;
        Arrays.sort(arr); // 배열을 오름차순으로 정렬해야 계산하기가 편하다! 시간복잡도도 더 좋아짐!

        while (arr[index] != 0) {
            total += arr[index];
            min = arr[index];

            index--;
            if(index < 0)
                break;
        }
        if((total + min) != 0)
            System.out.println(total + "\n" + min);
        else
            System.out.println(-1);
    }
}
*/
}
