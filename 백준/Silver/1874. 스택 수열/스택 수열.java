import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int a[] = new int[N];

        for(int i = 0 ; i < N ; i++){
            a[i] = sc.nextInt();
        }

        Stack<Integer> s = new Stack<>();
        int num = 1;
        StringBuffer bf = new StringBuffer();
        boolean flag = true;
        
        for(int i = 0 ; i < N; i++){
            int su = a[i];

            if(su >= num){ // 현재 수열이 자연수 보다 크다면? 현재수열의 값까지 계속 push해서 ++ 해야함
                while(su >= num){
                    s.push(num++);
                    bf.append("+\n");
                }
                s.pop();
                bf.append("-\n");
            }else {  // 현재 수열의 값보다 자연수가 더 크다? 그럼 pop 해서 -- 해야지~
                int n = s.pop();
                if(n > su){ // 방금 pop으로 뺸 값이, 현재 수열의 값보다 크다면??
                    System.out.println("NO");
                    flag = false;
                    break;
                }else{
                    bf.append("-\n");
                }
            }
        }

        if(flag){
            System.out.println(bf.toString());
        }

    }

}

