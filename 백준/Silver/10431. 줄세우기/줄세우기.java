import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());

        for (int t = 0; t < P; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int caseNum = Integer.parseInt(st.nextToken());

            int[] heights = new int[20];
            for (int i = 0; i < 20; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }

            List<Integer> line = new ArrayList<>();
            int totalMoves = 0;

            for (int i = 0; i < 20; i++) {
                int cur = heights[i];
                int insertPos = line.size(); // 기본은 맨 뒤

                for (int j = 0; j < line.size(); j++) {
                    if (line.get(j) > cur) {
                        insertPos = j;
                        break;
                    }
                }

                totalMoves += line.size() - insertPos;
                line.add(insertPos, cur);
            }

            System.out.println(caseNum + " " + totalMoves);
        }
    }
}

//✅ ArrayList vs 배열 비교
//항목	ArrayList	배열
//중간 삽입	add(index, value)로 간단히 삽입됨	수작업으로 요소들을 오른쪽으로 shift 해야 함
//코드 가독성	매우 좋음	로직이 지저분해짐
//성능 (이 문제 한정)	O(N²)이지만 N=20이므로 무시 가능	O(N²) 동일
//유연성	추후 확장성 높음	고정 크기 / 조작 불편

//🔍 실제로 왜 ArrayList가 적합한가?
//line.add(insertPos, cur) 하나로 삽입 + 이동이 한꺼번에 처리됨
//→ 따로 swap이나 shift 코드를 쓸 필요 없음

//밀린 인원 수는 line.size() - insertPos로 바로 계산 가능
//→ 추가 상태 변수 없이 처리

//배열 기반 구현보다 코드가 짧고 명확함
//→ 유지보수 / 디버깅이 쉬움
