import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main
{ 
    public static void main(String args[])
    {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            quickSort(A, 0, N-1, K-1);
            System.out.println(A[K-1]);
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    static void quickSort(int[] A, int S, int E, int K){
        if(S < E) {
            int pivot = partition(A, S, E);
            if(pivot == K) return;
            else if(K < pivot) quickSort(A, S, pivot-1, K);
            else quickSort(A, pivot+1, E, K);
        }
    }

    static int partition(int[] A, int S, int E){
        if(S+1 == E) {
            if(A[S] > A[E]) swap(A, S, E);
            return E;
        }

        /**중간에서 탐색 안하면 50%에서 시간초과남**/
        int M = (S + E) / 2;
        swap(A, E, M); // 중앙값을 1번째 요소로 이동하기
        /***********[1]*************/
        // 3 8 1 2 5 '4' ====> 피벗 4
        int pivot =  A[E]; // 오릉쪽 데이터를 피벗 데이터로 지정
        int left = S, right = E-1; // 왼쪽은 첫번째 위치에서 시작, 오른쪽은 맨 오른쪽이 피벗이므로 그 앞에서 시작
        // 3 8 1 2 5 '4' ===> A[left]=3, A[right]=5

        while(left <= right){
            while(left<= E-1 && A[left] < pivot){ // 왼쪽이 피벗보다 큰 데이터를 만날때까지
                left++;
                /***********[3]*************/
                // 3 2 1 8 5 '4'에서 left가 2인 상태일때 A[2]=1 < pivot=4 는 true이므로
                // left += 1을 수행하여 left가 3이된다.
                // A[3]=8 < pivot=4 는 false 이므로 left는 3에서 끝남
            }
            while(right>=S && A[right] > pivot){ // 오른쪽이 피벗보다 작은 데이터를 만날떄까지
                right--;
                /***********[4]*************/
                // 3 2 1 8 5 '4'에서 right가 2일때 pivot=4 > A[2]=1 이므로 true이기 때문에 right는 2에서 끝남
            }
            if(left < right){
                /***********[2]*************/
                // 3 8 1 2 5 '4' ---> 3 2 1 8 5 '4'
                swap(A, left, right); // 왼쪽에 피벗보다 작은 데이터, 오른쪽에 피벗보다 큰 데이터로 이동
                left++; right--; /**이걸 안하면 17%에서 시간초과가 남*/
            } else {
                /***********[5]*************/
                // left=3 > right=2 이므로 종료
                break;
            }
        }

        /***********[5]*************/
        // A[left]애 있는 데이터는 [3]에서 A[3]=8 < pivot=4 으로 피벗보다 큰 데이터임을 알고 있다
        // 그래서 맨 오른쪽에 있는 피벗데이터와 left 값의 위치를 변경
        // 3 2 1 8(left) 5 '4'(E)
        A[E] = A[left];
        // 3 2 1 8 5 8
        A[left] = pivot;
        // 3 2 1 4 5 8
        return left; // 피벗 데이터(4)의 위치(3)을 반환
    }

    static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}