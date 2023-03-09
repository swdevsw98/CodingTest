package 그래프;
import java.io.*;
import java.util.*;

public class P1516_게임개발 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();

        for(int i = 0; i <= N; i++) {
            A.add(new ArrayList<>());
        }

        int[] indegree = new int[N+1];
        int[] selfBuild = new int[N+1];

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            selfBuild[i] = Integer.parseInt(st.nextToken());
            while(true) {
                int preTemp = Integer.parseInt(st.nextToken());
                if(preTemp == -1)
                    break;
                A.get(preTemp).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            if(indegree[i] == 0)
                queue.offer(i); // null, false를 반환하는 add
        }

        int[] result = new int[N+1];
        while(!queue.isEmpty()) {
            int now = queue.poll(); // null, false 반환하는 remove
            for(int next : A.get(now)) {
                indegree[next]--;
                result[next] = Math.max(result[next], result[now] + selfBuild[now]);
                if(indegree[next] == 0){
                    queue.offer(next);
                }
            }
        }

        for(int i = 1; i <= N; i++)
            System.out.println(result[i] + selfBuild[i]);
    }
}
