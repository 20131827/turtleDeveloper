import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // Y = 2 / F = 3 / O = 4 명의 인원이 필요함, 본인을 제외할거니까 -1씩 처리하겠음
        // Y = 1 / F = 2 / O = 3

        int n = Integer.parseInt(st.nextToken()); // 총 지원자의 수
        String play = st.nextToken(); // 게임의 종류
        int num = 0; // 나머지 값으 구하기 위한 변수

        if(play.equals("Y")) num = 1;
        if(play.equals("F")) num = 2;
        if(play.equals("O")) num = 3;

        Set<String> set = new HashSet<>(); // 중복된 지원자와 게임하지 않기에, Set을 사용하여 중복값 자동 제거

        for(int i = 0 ; i < n ; i++){
            set.add(br.readLine());
        }

        System.out.println(set.size()/num);

    }
}