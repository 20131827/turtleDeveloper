import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue <Integer> q = new PriorityQueue<>((a, b)->{
            int a_abs = Math.abs(a);
            int b_abs = Math.abs(b);

            if(a_abs == b_abs){ // 절대값이 같은 경우 음수 우선
                return a > b ? 1 : -1;
            }

            return a_abs - b_abs;  // 절대값 작은 데이터 우선
        });

        for(int i = 0 ; i < n ; i++){
            int req = Integer.parseInt(br.readLine());
            if(req == 0){
                if(q.isEmpty()){
                    System.out.println("0");
                }else{
                    System.out.println(q.poll());
                }
            }else{
                q.add(req);
            }
        }

    }

}

