import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());  // 점수 리스트 길이
            int ts = Integer.parseInt(st.nextToken()); // 태수의 점수
            int p = Integer.parseInt(st.nextToken());  // 랭킹 리스트 자리

            List<Integer> list = new ArrayList<>();

            if(0 < n) {
                st = new StringTokenizer(br.readLine());
                for(int i = 0 ; i < n ; i++){
                    list.add(Integer.parseInt(st.nextToken()));
                }

                Collections.sort(list, Collections.reverseOrder());

                int rank = 1;
//                boolean flag = true;
//
//                int num = Math.min(n, p);
//
//                for(int i = 0 ; i < num ; i++){
//                    if(ts < list.get(i)) rank++;
//                    else if(rank == p && ts <= list.get(i)){
//                        flag = false;
//                        break;
//                    } else if (rank > p) {
//                        flag = false;
//                        break;
//                    }
//
//                }
//
//                System.out.println(flag ? rank : -1);

                int countBigger = 0;

                for (int score : list) {
                    if (score > ts) {
                        countBigger++;
                        rank++;
                    }
                }

                if (n == p && ts == list.get(p - 1)) {
                    // 리스트가 꽉 찼고, 태수 점수가 마지막 점수와 같으면 불가능
                    System.out.println(-1);
                } else if (countBigger >= p) {
                    // 태수 점수보다 큰 점수가 P개 이상이면 불가능
                    System.out.println(-1);
                } else {
                    System.out.println(rank);
                }

            }else{
                System.out.println(1);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
