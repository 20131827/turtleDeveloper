import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
   		/*
		백준 [1712] - 손익분기점
		[문제]
        월드전자는 노트북을 제조하고 판매하는 회사이다. 노트북 판매 대수에 상관없이 매년 임대료, 재산세, 보험료, 급여 등 A만원의 고정 비용이 들며,
        한 대의 노트북을 생산하는 데에는 재료비와 인건비 등 총 B만원의 가변 비용이 든다고 한다.
        예를 들어 A=1,000, B=70이라고 하자. 이 경우 노트북을 한 대 생산하는 데는 총 1,070만원이 들며, 열 대 생산하는 데는 총 1,700만원이 든다.
        노트북 가격이 C만원으로 책정되었다고 한다. 일반적으로 생산 대수를 늘려 가다 보면 어느 순간 총 수입(판매비용)이 총 비용(=고정비용+가변비용)보다 많아지게 된다.
        최초로 총 수입이 총 비용보다 많아져 이익이 발생하는 지점을 손익분기점(BREAK-EVEN POINT)이라고 한다.
        A, B, C가 주어졌을 때, 손익분기점을 구하는 프로그램을 작성하시오.
		[입력]
        첫째 줄에 A, B, C가 빈 칸을 사이에 두고 순서대로 주어진다. A, B, C는 21억 이하의 자연수이다.
		[출력]
        첫 번째 줄에 손익분기점 즉 최초로 이익이 발생하는 판매량을 출력한다. 손익분기점이 존재하지 않으면 -1을 출력한다.
		 */
        
        /*
        n : 판매수량
        a : 불변금액
        b : 재료값
        c : 판매값
        [공식]
        n * c = a + (n * b)
        => (n * c) - (n * b) = a
        => n(c - b) = a
        => n = a / (c - b)
        => 그런데 위의 공식대로라면 손익 분기점을 넘기는게 아니라 수익이 딱 0원이 되기에
         + 1 을 해주면 답을 구할수있다!
        */ 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken()); // 고정 비용
        int b = Integer.parseInt(st.nextToken()); // 재료 값
        int c = Integer.parseInt(st.nextToken()); // 판매 단가


        if (c <= b) {
            System.out.println("-1");
        } else {
            System.out.println(a / (c - b) + 1);
        }
    }
}