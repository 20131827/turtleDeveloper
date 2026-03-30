import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 행/열 크기 (N x N)
        int k = Integer.parseInt(br.readLine()); // 찾고 싶은 K번째 수

        long left = 1;                  // 가능한 최소 값
        long right = (long) n * n;      // 가능한 최대 값 (n*n까지 가능)

        // 이분탐색 시작 (값을 기준으로 탐색)
        while(left <= right){
            long mid = (left + right) / 2; // 후보 값 (이 값이 K번째 수가 될 수 있는지 확인)
            long cnt = 0; // mid 이하 숫자의 개수

            // 핵심: mid 이하 숫자가 몇 개인지 세기 -> 2중for문 사용하는 순간 메모리 초과로 실패..!
            for(int i = 1; i <= n; i++){
                // i행: i, 2i, 3i ... ni
                // i*j ≤ mid → j ≤ mid / i
                // → i행에서 mid 이하 개수 = mid / i

                // 단, 한 행에는 최대 n개밖에 없으므로 min 처리
                cnt += Math.min(n, mid / i);
            }

            // 판단 로직
            if(cnt >= k){
                // mid 이하 숫자가 k개 이상이다
                // → mid는 K번째 수가 될 수 있는 "후보"
                // → 더 작은 값도 가능한지 탐색 (최소값 찾기)
                right = mid - 1;
            } else {
                // mid 이하 숫자가 k개보다 부족하다
                // → K번째 수는 더 큰 값이어야 함
                left = mid + 1;
            }
        }

        // left가 K번째 수 -> (count ≥ k를 만족하는 최소 값)
        System.out.println(left);
    }
}