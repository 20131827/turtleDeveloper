import java.io.*;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int [] arr = new int[str.length()];

        for(int i = 0; i < str.length() ; i++){
            arr[i] = Integer.parseInt(str.substring(i,i+1));
        }

        for(int i = 0; i < str.length() ; i++){
            int Max = i;
            for(int j = i+1; j < str.length() ; j++){
                if(arr[j] > arr[Max]){
                    Max = j;
                }
            }
            if(arr[i] < arr[Max]){
                int temp = arr[i];
                arr[i] = arr[Max];
                arr[Max] = temp;
            }
        }

        for(int i = 0; i < str.length() ; i++){
            System.out.print(arr[i]);
        }
    }
}