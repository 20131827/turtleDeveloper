import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            System.out.println(n % 2 == 0 ? "CY" : "SK");

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}