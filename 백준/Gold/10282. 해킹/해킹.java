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

    static int V,E,K;
    static int[] dist;
    static ArrayList<node>[] graph;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        for(int n = 0 ; n < num ; n++){
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            dist = new int[V + 1];
            Arrays.fill(dist, INF);

            graph = new ArrayList[V + 1];

            for(int i = 1 ; i < V + 1 ; i++){
                graph[i] = new ArrayList<>();
            }

            for(int i = 0 ; i < E ; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                graph[v].add(new node(u, w));
            }
            dijkstra(K);

            int cnt = 0;
            int result = 0;

            for(int i = 1 ; i < V + 1 ; i++){
                if(dist[i] != INF){
                    cnt++;
                    result = Math.max(dist[i], result);// 이렇게 해야 마지막 감염 시간을 구할 수 있음!! 마지막 검사한놈이 아니라, max(dist)여야함.. 
                }
            }

            System.out.println(cnt + " " + result);

        }

    }

    public static void dijkstra(int start){
        PriorityQueue<node> pq = new PriorityQueue<>();
        pq.add(new node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            node cur = pq.poll();
            int now = cur.v;
            int cost = cur.cost;

            if(dist[now] < cost) continue;

            for(node next : graph[now]){
                int nextCost = next.cost + cost;
                if(nextCost < dist[next.v]){
                    dist[next.v] = nextCost;
                    pq.add(new node(next.v, nextCost));
                }
            }
        }
    }

}