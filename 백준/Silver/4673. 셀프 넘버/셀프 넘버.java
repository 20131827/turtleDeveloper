import java.io.IOException;

public class Main {

    public static int dn (int number){
        int sum = number;

        while(number != 0){
            sum = sum + (number % 10); // 가장 오른쪽 자리수
            number = number/10;	// 10을 나누어 가장 오른쪽 자리수를 없앤다
        }
        return sum; // 들어온 number 값의 모든 자리수를 더한값이 sum이다. 즉! 생성자가 있는 수 = sum [셀프넘버가 아닌수]
    }

    public static void main(String[] args) throws IOException {
		/*
		백준 [4673] - 셀프 넘버
		[문제]

		[입력]

		[출력]

		 */
        StringBuilder sb = new StringBuilder();

        boolean[] check = new boolean[10001]; // 유효범위가 1~10000 이기때문
        for(int i = 1; i < 10001 ; i++){
            int n = dn(i);

            if(n < 10001){
                check[n] = true;
            }
        }


        for (int i = 1; i < 10001; i++) {
            if (!check[i]) {	// 값이 false인 인덱스 = 생성자가 없는 수
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);
    }
}