import java.io.*;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->{ // a = 현재 insert되는 값(최하단 노드에 삽입) , b = a의 부모노드 값
            // 우선순위 큐는 Heap이라는 트리로된 자료구조
            // 우선순위가 높은 데이터를 찾는데 연산이 빠른 구조+
            // 완전 이진트리 + 우선순위가 항상 (부모 노드 > 자식노드) 상태를 유지 --> 해당 조건을 충족하면 root는 항상 우선순위가 가장 높은 값이 존재할 것
            // a가 방금 insert된 값 트리의 가장 마지막에 추가된다
            // 부모 노드보다 우선순위가 높으면? 부모 노드와 위치 교환
            // 부모 노드보다 우선순위가 낮으면? 현재 위치 유지.
            // insert한 값이 root까지 올라가거나, 부모 노드보다 우선순위기 낮아 현재 위치를 유지할때 까지 비교를 반복

            int abs_a = Math.abs(a);
            int abs_b = Math.abs(b);

            if(abs_a == abs_b){
                return a - b;   // 음수 반환 시 부모 노드와 위치 교환
            }else{
                return abs_a - abs_b; // 양수 반환 시 현재 위치 유지
            }

        });

        for(int i = 0 ; i < n ; i++){
            int x = Integer.parseInt(br.readLine());
            if(x != 0){
                q.add(x);
            }else if(q.size() != 0){
                System.out.println(q.poll());
            }else{
                System.out.println(0);
            }
        }
    }
}