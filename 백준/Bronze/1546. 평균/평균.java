import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        방법 1
        가장 기본적인 방법이라 할 수 있겠다.
        먼저 배열에 모든 원소를 입력받아 저장하고 Arrays 패키지에 있는 sort() 를 사용하여 정렬을 한다.
        그러면 오름차순으로 정렬이 되고 최댓값은 배열의 마지막 원소가 된다.
        또한 주의해야 할 점이 오차범위가 있기 때문에 반드시 연산 할 때 최소한 자료형 1개 이상은 double 형으로 써야한다.
        그러면 자동 형변환이 되면서 자료형이 큰 쪽으로 (int 에서 double) 변환이 되기 때문이다.
        이 코드에서는 배열과 sum 을 double 형으로 해줬다.
        *** String에서 double 형으로 바꾸려면 Double.parseDouble() 을 사용해야한다.
        */
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        double arr[] = new double[Integer.parseInt(br.readLine())];
//
//        StringTokenizer st = new StringTokenizer(br.readLine()," ");
//
//        for(int i = 0; i < arr.length; i++) {
//            arr[i] = Double.parseDouble(st.nextToken());
//        }
//
//        double sum = 0;
//        Arrays.sort(arr);
//
//        for(int i = 0; i < arr.length; i++) {
//            sum += ((arr[i] / arr[arr.length - 1]) * 100);
//        }
//        System.out.print(sum / arr.length);

        
        /*
        방법 2
        배열을 사용하지 않고 입력받고나서 조건문을 사용해 최댓값을 구하고,
        sum 에 value 값을 더해준다.
        그리고 굳이 매번 하나의 value 마다 (value/max)*100 을 해주면서
        sum 에 더해주는 것 보다는 마지막에 한번에 연산한 값을 출력해주는게 연산을 덜 할 것이다. (이때 sum 이 double이라 연산값 또한 double 로 형변환 되어 반환된다.)
        예로들어 3, 7, 6, 2 라는 값을 입력받았을때
        (3/7)*100 + (7/7)*100 + (6/7)*100 + (2/7)*100 이렇게 하나
        ((3+7+6+2) / 7)*100 을 하나 값은 같기 때문에 상관이 없다.
        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int se = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int max = -1; // (입력받을 값이 0보다 크거나 같기 때문)
        double sum = 0;

        for (int i = 0; i < se; i++) {
            int value = Integer.parseInt(st.nextToken());

            if(value > max) {
                max = value;
            }
            sum += value;
        }
        System.out.print((sum / max) * 100.0 / se);
    }
}