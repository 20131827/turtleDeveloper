import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Queue <Integer> q = new LinkedList<>();

        for(int i = 1 ; i <= N ; i++){
            q.add(i);
        }
        boolean flag = true;

        int temp = 0;
        while (q.size() != 1){
            if(flag){
                q.poll();
                flag = false;
            }else{
                temp = q.remove();
                q.add(temp);
                flag = true;
            }
        }

        System.out.println(q.remove());

    }

}

