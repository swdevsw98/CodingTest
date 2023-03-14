package 그래프;

import java.util.*;
import java.io.*;

public class P11657_타임머신 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static long distance[];
    static Edge2 edges[];

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new Edge2[M + 1];
        distance = new long[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            edges[i] = new Edge2(start, end, time);
        }
        distance[1] = 0;
        for(int i = 1; i < N; i++){
            for(int j = 0; j < M; j++){
                Edge2 edge = edges[i];
                if(distance[edge.start] != Integer.MAX_VALUE
                    && distance[edge.end] > distance[edge.start] + edge.time) {
                    distance[edge.end] = distance[edge.start] + edge.time;
                }
            }
        }
        boolean mCycle = false;
        for(int i = 0; i < M; i++){
            Edge2 edge = edges[i];
            if(distance[edge.start] != Integer.MAX_VALUE
                && distance[edge.end] > distance[edge.start] + edge.time){
                mCycle = true;
            }
        }
        if (!mCycle) {
            for(int i = 2; i <= N; i++){
                if(distance[i] == Integer.MAX_VALUE)
                    System.out.println("-1");
                else
                    System.out.println(distance[i]);
            }
        } else {
            System.out.println("-1");
        }
    }
}
class Edge2{
    int start, end, time;
    public Edge2(int start, int end, int time) {
        this.start = start;
        this.end = end;
        this.time = time;
    }
}