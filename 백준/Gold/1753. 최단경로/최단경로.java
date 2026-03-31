import java.io.*;
import java.util.*;
public class Main {
    static class node implements Comparable <node>{
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
    static ArrayList<node>[]graph;
    static int k,n,e;
    static int[] dist;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i = 1; i < n+1 ; i++){ // 정점이 1부터 시작하기 때문
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());

        for(int i = 0; i < e ; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 출발
            int v = Integer.parseInt(st.nextToken()); // 도착
            int w = Integer.parseInt(st.nextToken()); // 가중치
            graph[u].add(new node(v,w));
        }

        dist = new int[n+1]; // 시작점에서 i로 가는 최단거리를 저장하기 위한 배열(다익스트라 종료해야 최단거리고 돌고있는 중 이라면 최단거리를 보장할 수 없음)
        Arrays.fill(dist, Integer.MAX_VALUE); // dist에 최대값(무한)으로 모두 insert

        djikstra(k);

        for(int i = 1 ; i < n+1 ; i++){
            int result = dist[i];

            if(result == Integer.MAX_VALUE){
                System.out.println("INF");
            }else{
                System.out.println(result);
            }
        }

    }

    public static void djikstra(int start){
        PriorityQueue<node> pq = new PriorityQueue<>();

        pq.offer(new node(start,0));
        dist[start] = 0; // 시작점은 cost가 0

        while(!pq.isEmpty()){
            node cur = pq.poll();

            int now = cur.v;
            int cost = cur.cost;

            if(dist[now] < cost) continue; //dist는 초기화값이 MAX_VALUE로 되어있음. 따라서 now 정점으로 가는 cost중 가장 작은 값을 dist에 저장할때 최적화 하기위한 조건

            for(node n : graph[now]){ //현재위치에서 연결되어있는 모든 간선을 돌면서 계산
                int nextCost = cost + n.cost; // 현재 정점까지의 cost + 연결된 다음 정점으로의 cost = 다음 정점 까지의 총 cost

                if(nextCost < dist[n.v]){ // 지금 까지 계산되어있는 다음 정점으로의 cost와 방금 계산한 cost를 비교해서 기존 cost가 더 크다면? -> 방금계산한 cost가 더 최단거리 라는 뜻이기에, dist에 update 해준다
                    dist[n.v] = nextCost;
                    pq.add(new node(n.v, nextCost));
                }

            }

        }

    }

}