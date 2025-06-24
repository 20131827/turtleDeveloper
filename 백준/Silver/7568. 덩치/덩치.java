import java.io.*;
import java.util.*;

public class Main {
    static class person {
        int id, h, w;

        // 생성자
        public person(int id, int h, int w) {
            this.id = id;
            this.h = h;
            this.w = w;
        }
    }
    public static void main(String[] args) {
        try{

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();

            int n = Integer.parseInt(st.nextToken());

            List<person> list = new ArrayList<>();
            for(int i = 0 ; i < n ; i++){
                st = new StringTokenizer(br.readLine());
                list.add(new person(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            int rank = 1;
            for(int i = 0 ; i < n ; i++) {
                person c = list.get(i);
                for (person p : list) {
                    if(c.h < p.h && c.w < p.w) rank++;
                }
                sb.append(rank).append(" ");
                rank = 1;
            }

            System.out.println(sb.toString());

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}