import java.io.*;
import java.util.*;

public class Main {

//   1: 화살표를 한 칸 아래로 내린다. (채널 i에서 i+1로)
//   2: 화살표를 위로 한 칸 올린다. (채널 i에서 i-1로)
//   3: 현재 선택한 채널을 한 칸 아래로 내린다. (채널 i와 i+1의 위치를 바꾼다. 화살표는 i+1을 가리키고 있는다)
//   4: 현재 선택한 채널을 위로 한 칸 올린다. (채널 i와 i-1의 위치를 바꾼다. 화살표는 i-1을 가리키고 있다)

    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();

            int n = Integer.parseInt(st.nextToken());
            String [] arr = new String[n];

            for(int i = 0 ; i < n ;i++){
                st = new StringTokenizer(br.readLine());
                arr[i] = st.nextToken();
            }

            int cursor = 0;

            while (true){

                if(arr[0].equals("KBS1") && arr[1].equals("KBS2")) break;

                if(!arr[0].equals("KBS1")){
                    int k1 = whereKbs(arr, "KBS1");
                    if(cursor < k1){
                        sb.append("1");
                        cursor++;
                    }else if(cursor > k1){
                        sb.append("2");
                        cursor--;
                    }else{
                        String temp = arr[cursor-1];
                        arr[cursor-1] = arr[cursor];
                        arr[cursor] = temp;
                        sb.append("4");
                        cursor--;
                    }
                }else if(!arr[1].equals("KBS2")){
                    int k2 = whereKbs(arr, "KBS2");
                    if(cursor < k2){
                        sb.append("1");
                        cursor++;
                    }else if(cursor > k2){
                        sb.append("2");
                        cursor--;
                    }else{
                        String temp = arr[cursor-1];
                        arr[cursor-1] = arr[cursor];
                        arr[cursor] = temp;
                        sb.append("4");
                        cursor--;
                    }
                }

            }

            System.out.println(sb.toString());


        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static int whereKbs(String[] arr, String x){
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i].equals(x)) return i;
        }
        return 1;
    }
}