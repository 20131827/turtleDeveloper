import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int dataSize = Integer.parseInt(st.nextToken());
        int [] dataArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(dataArr);

        st = new StringTokenizer(br.readLine());
        int searchSize = Integer.parseInt(st.nextToken());
        int [] searchArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i = 0 ; i < searchSize ; i ++){
            System.out.println(arrSort(dataArr, searchArr[i]));
        }


    }

    static public int arrSort(int [] dataArr, int target){
        int start = 0;
        int end = dataArr.length -1;

        while(start <= end){
            int mid = (start + end) / 2;

            if(dataArr[mid] < target){
                start = mid +1;
            }else if(dataArr[mid] > target){
                end = mid -1;
            }else{
                return 1;
            }
        }
        return 0;
    }

}