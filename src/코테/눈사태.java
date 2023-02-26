package 코테;

import java.util.*;
import java.io.*;
import java.lang.*;

class 눈사태 {
    public static int[] solution(int n, int[] snow) {
        int[] max = new int[n+1];
        for(int i = 3; i > 0; i--)
            max[n-i] = 2 * (n-i) + 1;
        int[] answer = new int[n];

        for(int i = 0; i < n; i++) {
            if(snow[i] - max[i] > 0) {
                answer[i] = max[i];
                snow[i+1] = snow[i+1] + (snow[i] - max[i]);
            }
            else if(snow[i] - max[i] < 0) {
                answer[i] = snow[i];
            }
            else {
                answer[i] = max[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] snow = new int[n+1];
        int[] answer = {};

        for(int i = 0; i < n; i++) {
            snow[i] = Integer.parseInt(st.nextToken());
        }

        answer = solution(n, snow);

        for(int i = 0; i < answer.length; i++)
            System.out.print(answer[i]);
    }
}
