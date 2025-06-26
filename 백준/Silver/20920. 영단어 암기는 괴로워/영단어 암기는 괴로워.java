import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Map<String, Integer> h = new HashMap<>();

            for(int i = 0 ; i < n ; i++){
                st = new StringTokenizer(br.readLine());
                String temp = st.nextToken();
                if(m <= temp.length()){
                    if(h.containsKey(temp)) h.put(temp, h.get(temp)+1);
                    else h.put(temp, 1);
                }
            }
            List<String> keys = new ArrayList<>(h.keySet());

//            음수 (a < b)	a가 앞에 오도록 정렬
//            0 (a == b)	순서 변경 없음
//            양수 (a > b)	b가 앞에 오도록 정렬

            keys.sort((a, b)->{
                int av = h.get(a);
                int bv = h.get(b);
                if(av != bv) return bv - av;                                 // 1. 빈도수 내림차순
                if(a.length() != b.length()) return b.length() - a.length(); // 2. 길이 내림차순
                return a.compareTo(b);                                       // 3. 사전순 오름차순
            });

            for(String data: keys){
//                System.out.println(data);
                bw.write(data + "\n");
            }

            bw.flush();
            bw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}


//import java.io.*;
//import java.util.*;
//
//public class Main {
//
//    public static void main(String[] args) {
//        try{
////            음수 (a < b)	a가 앞에 오도록 정렬
////            0 (a == b)	순서 변경 없음
////            양수 (a > b)	b가 앞에 오도록 정렬
//
//            Map<String, Integer> m = new HashMap<>();
//            m.put("a", 4);
//            m.put("b", 2);
//            m.put("b", 2);
//            m.put("cc", 2);
//            m.put("cc", 2);
//            m.put("d", 3);
//            m.put("eeee", 4);
//            m.put("eeee", 4);
//            m.put("eeee", 4);
//
//            // e -> a -> d -> b -> c
//            List<String> list = new ArrayList<>(m.keySet());
//
//            list.sort((a, b) ->{
//                int av = m.get(a);
//                int bv = m.get(b);
//                if(av != bv) return bv - av;
//                if(a.length() != b.length()) return  b.length() - a.length();
//                return a.compareTo(b);
//            });
//
//            for(String data: list){
//                System.out.println(data);
//            }
//
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//}
