import java.io.*;
import java.util.*;
public class Main {
    static int [] dx = {0, 0, -1, 1};
    static int [] dy = {-1 ,1, 0, 0};
    static boolean [][] visited;
    static int [][] map;
    static int w, h;

    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] wh = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        h = wh[0]; // 세로
        w = wh[1]; // 가로

        // 배열 초기화
        map = new int [h][w];
        visited = new boolean [h][w];

        for(int i = 0; i < h ; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int cnt = 0; // 그림의 개수
        TreeSet<Integer> treeset = new TreeSet<>(); // TreeSet을 사용하면 요소가 자동으로 정렬됨. last() 메서드를 사용하면 가장 큰 값을 구할 수 있음.
                                                // HashSet과의 가장 큰 차이 : 트리셋은 이진 트리 구조를 사용하여 자동 정렬을 해줌
                                                // 같은 Set컬렉션 이지만 헤시셋은 해시테이블을 구현하였기에 add, remove 등의 메소드가 O(1)의 시간복잡도를 갖는 반면
                                                // 트리셋의 경우 해당 메소드의 시간복잡도가 시간복잡도가 O(logN)을 갖게됨
                                                // set의 장점 : 중복되는 데이터를 중복 저장하지 않음 (중복 자동제거)

        for(int i = 0 ; i < h ; i++){
            for(int j = 0 ; j < w ; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    cnt++;
                    treeset.add(dfsStack(i, j));
                }
            }
        }

        System.out.println(cnt); // 그림의 개수
        // set은 비어있을 경우 메소드를 호출하게되면 null 반환이 아닌 NoSuchElementException 발생함 따라서 isEmpty() 메소드로 null체크를 꼭 해야함
        System.out.println(treeset.isEmpty() ? 0 : treeset.last());  // 가장 넓은 그림의 크기
    }

    static int dfsStack(int a, int b){
        int size = 1;
        visited[a][b] = true;

        Stack<int []> stack = new Stack<>();
        stack.push(new int[]{a, b});

        while(!stack.empty()){
            int [] current = stack.pop();
            int yy = current[0];
            int xx = current[1];

            for(int i = 0 ; i < 4 ; i++){
                int my = dy[i] + yy;
                int mx = dx[i] + xx;
                if(my < h && my >= 0 && mx < w && mx >= 0 && map[my][mx] == 1 && !visited[my][mx]){
                    visited[my][mx] = true;
                    stack.push(new int[]{my, mx});
                    size++;
                }
            }
        }
        return size;
    }

}