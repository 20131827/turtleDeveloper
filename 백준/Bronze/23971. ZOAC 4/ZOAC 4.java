import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();
            String[]str = line.split(" ");
            // 행, 열, 세로공백, 가로공백 순으로 입력
            // a = 행 + 여유 / 여유 + 1
            // b = 열 + 여유 / 여유 + 1
            // result = a * b
            int i = Integer.parseInt(str[0]);
            int j = Integer.parseInt(str[1]);
            int n = Integer.parseInt(str[2]);
            int m = Integer.parseInt(str[3]);

            int a = (i+n) / (n+1);
            int b = (j+m) / (m+1);
            int result = a*b;

            System.out.println(result);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}