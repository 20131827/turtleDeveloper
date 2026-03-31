import java.io.*;
import java.util.*;
public class Main {

    static int n,m,x;
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
    static ArrayList<node>[] graph;
    static int[] goDist;
    static int[] backDist;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i = 1 ; i < n+1 ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[v].add(new node(u,cost));
        }

        int[] totalDist = new int[n+1];
        for (int i = 1; i < n + 1; i++) {
            goDist = new int[n + 1];
            Arrays.fill(goDist, Integer.MAX_VALUE);
            dijkstra(i, goDist);
            totalDist[i] = goDist[x];
        }

        backDist = new int[n+1];
        Arrays.fill(backDist, Integer.MAX_VALUE);
        dijkstra(x, backDist);
        for(int i = 1 ; i < n+1 ; i++){
            totalDist[i] += backDist[i];
        }

        int result = 0;
        for(int i = 1 ; i < n+1 ; i++){
            result = Math.max(result, totalDist[i]);
        }

        System.out.println(result);

    }

    public static void dijkstra(int start, int[] dist){
        PriorityQueue<node> pq = new PriorityQueue<>();
        pq.offer(new node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            node cur = pq.poll();
            int now = cur.v;
            int cost = cur.cost;

            if(dist[now] < cost) continue; // 이미 계산된 cost가 더 작다면 계산하지 않고 skeep

            for(node next : graph[now]){
                int nextCost = cost + next.cost ;

                if(nextCost < dist[next.v]){ // 최단거리를 구하기 위해 nextCost가 더 작다면..? dist[next] update해줘야지
                    dist[next.v] = nextCost;
                    pq.offer(new node(next.v, nextCost));
                }
            }
        }

    }
}