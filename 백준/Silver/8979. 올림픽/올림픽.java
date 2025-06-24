import java.io.*;
import java.util.*;

public class Main {
    static class Country {
        int id, gold, silver, bronze;

        // 생성자
        public Country(int id, int gold, int silver, int bronze) {
            this.id = id;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }
    public static void main(String[] args) {
        try{
//            금메달 수가 더 많은 나라
//            금메달 수가 같으면, 은메달 수가 더 많은 나라
//            금, 은메달 수가 모두 같으면, 동메달 수가 더 많은 나라

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int answerIndex = Integer.parseInt(st.nextToken());

            List<Country> list = new ArrayList<>();

            for(int i = 0 ; i < n ; i++){
                st = new StringTokenizer(br.readLine());
                list.add(new Country(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }


            int rank = 1;
            Country target = null;

            for (Country c : list) {
                if (c.id == answerIndex) {
                    target = c;
                    break;
                }
            }
            
            for (Country c : list) {
                if (c.gold > target.gold) {
                    rank++;
                } else if (c.gold == target.gold && c.silver > target.silver) {
                    rank++;
                } else if (c.gold == target.gold && c.silver == target.silver && c.bronze > target.bronze) {
                    rank++;
                }
            }

            System.out.println(rank);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}