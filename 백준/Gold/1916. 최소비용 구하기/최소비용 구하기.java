import java.io.*;
import java.util.*;

public class Main {
    static class node implements Comparable<node>{
        int v;
        int cost;

        node(int v, int cost){
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(node o){
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int n,m,start,end;
    static ArrayList<node>[] graph;
    static int[] dist;
    static final int max = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 도시의 수

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // 버스의 수

        dist = new int[n+1];
        Arrays.fill(dist,max);

        graph = new ArrayList[n+1];
        for(int i = 1 ; i < n+1 ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[u].add(new node(v, cost));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(dist[end]);


    }

    public static void dijkstra(int start){
        PriorityQueue<node> pq = new PriorityQueue<>();
        pq.offer(new node(start,0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            node cur = pq.poll();
            int now = cur.v;
            int cost = cur.cost;

            if(dist[now] < cost) continue;

            for(node next : graph[now]) {
                int nextCost = cost + next.cost;
                if (nextCost < dist[next.v]) {
                    dist[next.v] = nextCost;
                    pq.offer(new node(next.v, nextCost));
                }
            }

        }
    }

}
