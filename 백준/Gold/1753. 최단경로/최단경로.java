import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node>{
        int v; // 이동할 정점
        int cost; // 시작점에서 해당 정점까지의 cost

        Node(int v, int cost){
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int V,E;
    static int K;
    static ArrayList<Node>[] graph;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V + 1]; // 정점의 수가 1부터기 때문에 + 1 함
        dist = new int[V + 1]; // 정점의 수가 1부터기 때문에 + 1 함

        for(int i = 1; i <= V; i++){ // 정점 생성
            graph[i] = new ArrayList<>();
        }

        Arrays.fill(dist, Integer.MAX_VALUE);   // dist에 최대값(무한)으로 모두 insert

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken()); // 시작점 K 입력

        for(int i = 0 ; i < E ; i++){ // u->v 방향 으로 가중치 w 간선 생성
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
        }

        dijkstra(K);

        for (int i = 1; i < V + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(dist[i]);
        }

    }

    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(start, 0));
        dist[start] = 0; // 시작점은 cost가 0임

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            int now = cur.v;
            int cost = cur.cost;

            if(dist[now] < cost) continue; //dist는 초기화값이 MAX_VALUE로 되어있음. 따라서 now 정점으로 가는 cost중 가장 작은 값을 dist에 저장할때 최적화 하기위한 조건임

            for(Node next : graph[now]){
                int nextCost = cost + next.cost; // 다음 cost = 현재 cost + 현재에서 다음으로 가는 cost

                if(nextCost < dist[next.v]){ // 현재까지 계산된 다음 정점의 cost 보다 현재정점에서 다음 정점으로 가는 cost를 구한게 더 작다면? dist값을 update 해줘야함
                    dist[next.v] = nextCost;
                    pq.add(new Node(next.v, nextCost));
                }
            }
        }
        
    }

}