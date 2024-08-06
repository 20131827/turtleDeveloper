import java.io.*;
import java.util.*;
public class Main
{
    public static class node{
        int cb;     // 클립보드
        int view;   // 화면
        int time;   // 시간
        public node(int cb, int view, int time){
            this.cb   = cb;
            this.view = view;
            this.time = time;
        }
    }
    static boolean[][] visited = new boolean [1001][1001]; // [클립보드][화면]
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        bfs(sc.nextInt()); // 총 만들어야할 이모티콘 개수
    }
    static void bfs(int s){
        Queue <node> q = new LinkedList<>();
        q.offer(new node(0, 1, 0));

        visited[0][1] = true;

        while(!q.isEmpty()){
            node c = q.poll();

            if(c.view == s){
                System.out.println(c.time);
                return;
            }

            // 1. 화면내용 클립보드 복사
            //
            if(!visited[c.view][c.view]){
                visited[c.view][c.view] = true;
                q.offer(new node(c.view, c.view, c.time + 1));
            }

            // 2. 클립보드에 있는 이모티콘 붙여넣기.
            // 클립보드 비어있지 않아야하고, 붙여넣은 후 개수가 총 개수보다 적어야 하며, 해당 행위를 한적 없을때
            //            if(c.cb > 0 && c.cb + c.view <= s && !visited[c.cb][c.view + c.cb]){

            //  -> 클립보드 비어있지 않고, 클립보드 + 화면의 수가 1000 이하이며, 해당 행위를 한적 없을 때
            if(c.cb > 0 && c.cb + c.view <= 1000 && !visited[c.cb][c.view + c.cb]){
                visited[c.cb][c.view + c.cb] = true;
                q.offer(new node(c.cb, c.view + c.cb, c.time + 1));
            }

            // 3. 화면 이모티콘 1개 삭제
            // 화면에 이모티콘 1개 이상이고, 클립보드 + 화면 이 총 개수 보다 크고, 해당 행위를 한적 없을때
//            if(c.view > 1 && c.cb + c.view > s && !visited[c.cb][c.view - 1]){
            // 화면에 이모티콘 1개 이상이고, 해당 행위를 한적 없을때
            if(c.view > 1 && !visited[c.cb][c.view - 1]){
                visited[c.cb][c.view - 1] = true;
                q.offer(new node(c.cb, c.view - 1, c.time + 1));
            }
        }
    }
}